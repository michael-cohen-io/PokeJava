package com.pokejava;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Game extends ModelClass {

	private int Generation, ReleaseYear;
	
	public Game(int ID){
		String data = "";
		
		data = get("game/"+ID);
		
		JSONObject root = parse(data);
		try {
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			
			this.ID = root.getInt("id");
			Generation = root.getInt("generation");
			ReleaseYear = root.getInt("release_year");
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getGeneration(){return Generation;}
	public int getReleaseYear(){return ReleaseYear;}
}
