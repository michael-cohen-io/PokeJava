package com.pokejava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class EggGroup extends ModelClass {

	private ArrayList<Integer> Pokemon;
	
	public EggGroup(int ID) {
		
		String data = "";
		data = get("egg/"+ID);
		
		JSONObject root = parse(data);
		
		try {
			//Define Properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			
			this.ID = root.getInt("id");
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
		
			Pokemon = new ArrayList<Integer>();
			JSONArray pokemonNode = root.getJSONArray("pokemon");
			for (int i = 0; i < pokemonNode.length(); i++) {
				String pokemonURI = pokemonNode.getJSONObject(i).getString("resource_uri");
				pokemonURI = pokemonURI.substring(16);
				pokemonURI = pokemonURI.replace("/", "");
				
				Pokemon.add(Integer.parseInt(pokemonURI));
			}
			if (Pokemon.isEmpty()) { Pokemon.add(null);} // Will never actually execute. Just another layer of protection
			
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	
	public ArrayList<Pokemon> getPokemon(){
		ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		for (int i = 0; i < Pokemon.size(); i++){
			Pokemon p = new Pokemon(Pokemon.get(i));
			pokemonList.add(p);
		}
		if (pokemonList.isEmpty()){ return null;} // Will never actually execute. Just another layer of protection
		
		return pokemonList;
	}
	
	public boolean hasPokemon(){
		if (Pokemon.isEmpty()) return false;
		else return true;
	}
	
	
}
