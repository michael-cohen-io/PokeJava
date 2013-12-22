package com.pokejava;
import java.text.SimpleDateFormat;

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
		
		data = get("sprite/"+ID);
		
		JSONObject root = parse(data);
		try {
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Image = root.getString("image");
			
			this.ID = root.getInt("id");
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
			
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
