package com.pokejava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Pokedex extends ModelClass {
	
	//I thing it will be better to have a Map with the PokemonId and the name
	private Map<Integer,String> Pokemons;
	
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
			//I used a TreeMap because it will be sorted by keys
			Pokemons = new TreeMap<Integer,String>();
			
				for (int i = 0; i < pokemonNode.length(); i++) {
					String pokemonURI = pokemonNode.getJSONObject(i).getString("resource_uri");
					//gets the pokemon name
					String pokemonName = pokemonNode.getJSONObject(i).getString("name");
					pokemonURI = pokemonURI.substring(15);
					pokemonURI = pokemonURI.replace("/", "");
					//puts the pokemonId and the name into the map
					Pokemons.put(Integer.parseInt(pokemonURI),pokemonName);
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
	
	/**
	 * I need a method that return all the pokemons names
	 * If I use the getPokemons() method it will do one request per Pokemon so it will be slow to get all pokemons
	 * @return A collection with all the pokemons names
	 */
	public Collection<String> getPokemonsNames(){
		return Pokemons.values();
	}
}
