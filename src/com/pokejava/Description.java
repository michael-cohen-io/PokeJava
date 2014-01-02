package com.pokejava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Description extends ModelClass {
	
	private ArrayList<Integer> Games;
	private Pokemon pokemon;
	
	public Description(int ID){
		String data = "";
		
		data = get("description/"+ID);
		
		JSONObject root = parse(data);
		try {
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			
			this.ID = root.getInt("id");
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
			
			String pokemonURI = root.getJSONObject("pokemon").getString("resource_uri");
			pokemonURI = pokemonURI.substring(16);
			pokemonURI = pokemonURI.replace("/", "");
			pokemon = new Pokemon(Integer.parseInt(pokemonURI));
			
			//Game ArrayList defining
			JSONArray gameNode = root.getJSONArray("games");
			Games = new ArrayList<Integer>();
			for (int i = 0; i < gameNode.length(); i++){
				String gameURI = gameNode.getJSONObject(i).getString("resource_uri");
				gameURI = gameURI.substring(13);
				gameURI = gameURI.replace("/", "");
				
				Games.add(Integer.parseInt(gameURI));
			}
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public Pokemon getPokemon(){return pokemon;}
	
	public ArrayList<Game> getGames() {
		ArrayList<Game> list = new ArrayList<Game>();
		
		for (int i = 0; i < Games.size(); i++) {
			Game g = new Game(Games.get(i));
			list.add(g);
		}
		if(list.isEmpty()) { return null;}
		
		return list;
	}
	
	public boolean hasGames(){
		if (Games.isEmpty()) return false;
		else return true;
	}
	
}
