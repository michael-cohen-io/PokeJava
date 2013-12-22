package com.pokejava;
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
			Created = root.getString("created");
			Modified = root.getString("modified");
			
			this.ID = root.getInt("id");
			Generation = root.getInt("generation");
			ReleaseYear = root.getInt("release_year");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getGeneration(){return Generation;}
	public int getReleaseYear(){return ReleaseYear;}
}
