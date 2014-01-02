package com.pokejava;
import java.text.SimpleDateFormat;
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
		
		data = get("pokedex/1"); //Only one pokedex available; no ID necesarry
		
		JSONObject root = parse(data);
		try {
			Name = root.getString("name");
			URI = root.getString("resource_uri");

			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
			
			//Pokemon ArrayList defining
			JSONArray pokemonNode = root.getJSONArray("pokemon");
			Pokemons = new ArrayList<Integer>();
				for (int i = 0; i < pokemonNode.length(); i++) {
					String pokemonURI = pokemonNode.getJSONObject(i).getString("resource_uri");
					pokemonURI = pokemonURI.substring(15);
					pokemonURI = pokemonURI.replace("/", "");
					
					Pokemons.add(Integer.parseInt(pokemonURI));
				}
			
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
	
	public boolean hasPokemon(){
		if (Pokemons.isEmpty()) return false;
		else return true;
	}
}
