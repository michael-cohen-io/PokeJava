package com.pokejava;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Pokedex extends ModelClass {
	

	private ArrayList<Integer> Pokemons;
	
	public Pokedex(){
		String data = "";
		
		try {
			data = get("pokedex/1"); //Only one pokedex available; no ID necesarry
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject root = parse(data);
		try {
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Created = root.getString("created");
			Modified = root.getString("modified");
			
			//Pokemon ArrayList defining
			JSONArray pokemonNode = root.getJSONArray("pokemon");
			Pokemons = new ArrayList<Integer>();
				for (int i = 0; i < pokemonNode.length(); i++) {
					String pokemonURI = pokemonNode.getJSONObject(i).getString("resource_uri");
					pokemonURI = pokemonURI.substring(15);
					pokemonURI = pokemonURI.replace("/", "");
					
					Pokemons.add(Integer.parseInt(pokemonURI));
				}
			if (Pokemons.isEmpty()){ Pokemons.add(null);}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Pokemon> getPokemons(){
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		
		for (int i = 0; i < Pokemons.size(); i++){
			Pokemon p = new Pokemon(Pokemons.get(i));
			list.add(p);
		}
		if (list.isEmpty()) { return null;}
		
		return list;
	}
}
