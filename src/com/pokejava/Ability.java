package com.pokejava;

import java.text.SimpleDateFormat;

import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Ability extends ModelClass {
	private String Description; 
	
	public Ability(int ID){
		String data = "";
		data = get("ability/"+ID);
		
		JSONObject root = parse(data);
		try {
			//Define Properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Description = root.getString("description");
			
			this.ID = root.getInt("id");
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public String getDescription(){return Description;}
}
