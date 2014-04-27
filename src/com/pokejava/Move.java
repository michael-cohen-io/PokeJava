package com.pokejava;
import java.text.SimpleDateFormat;

import org.json.JSONObject;

/**
 * @author Michael
 *
 */
public class Move extends ModelClass {

	private String Category, Description, LearnType;
	private int Power, Accuracy, PP, LearnedAt;
	
	/**
	 * @param ID
	 * @param LearnType
	 * @param LearnedAt
	 */
	public Move(int ID, String LearnType, int LearnedAt){
		String data = "";
		
		data = get("move/"+ID);
		
		JSONObject root = parse(data);
		try {
			//Define Properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Category = root.getString("category");
			Description = root.getString("description");
			this.LearnType = LearnType;
			
			this.ID = root.getInt("id");
			Power = root.getInt("power");
			Accuracy = root.getInt("accuracy");
			PP = root.getInt("pp");
			this.LearnedAt = LearnedAt;
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param ID
	 * @param LearnType
	 */
	public Move(int ID, String LearnType){
		this(ID, LearnType, -1);
	}
	
	/**
	 * @param ID
	 * @param LearnedAt
	 */
	public Move(int ID, int LearnedAt){
		this(ID, "level up", LearnedAt);
	}
	
	/**
	 * @param ID
	 */
	public Move(int ID){
		this(ID, "", -1);
	}
	
	/**
	 * @return Category
	 */
	public String getCategory(){return Category;}
	/**
	 * @return Description
	 */
	public String getDescription(){return Description;}
	/**
	 * @return LearnType
	 */
	public String getLearnType(){return LearnType;}
	
	/**
	 * @return Power
	 */
	public int getPower(){return Power;}
	/**
	 * @return Accuracy
	 */
	public int getAccuracy(){return Accuracy;}
	/**
	 * @return PP
	 */
	public int getPP(){return PP;}
	/**
	 * @return Level
	 */
	public int getLevel(){return LearnedAt;}
	
}
