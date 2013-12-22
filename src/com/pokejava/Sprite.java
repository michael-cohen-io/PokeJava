package com.pokejava;
import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael
 *
 */
public class Sprite extends ModelClass {

	private String Image;
	private Pokemon pokemon;
	
	public Sprite(int ID){
		String data = "";
		
		try {
			data = get("sprite/"+ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject root = parse(data);
		try {
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Created = root.getString("created");
			Modified = root.getString("modified");
			Image = root.getString("image");
			
			this.ID = root.getInt("id");
			
			String pokemonURI = root.getJSONObject("pokemon").getString("resource_uri");
			pokemonURI = pokemonURI.substring(16);
			pokemonURI = pokemonURI.replace("/", "");
			pokemon = new Pokemon(Integer.parseInt(pokemonURI));
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public String getImage(){return Image;}
	
	
	public Pokemon getPokemon(){return pokemon;}
}
