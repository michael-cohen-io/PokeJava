package com.pokejava;
import org.json.JSONObject;

/**
 * @author Michael
 *
 */
public class Move extends ModelClass {

	private String Category, Description, LearnType;
	private int Power, Accuracy, PP;
	
	public Move(int ID, String LearnType){
		String data = "";
		
		data = get("move/"+ID);
		
		JSONObject root = parse(data);
		try {
			//Define Properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Created = root.getString("created");
			Modified = root.getString("modified");
			Category = root.getString("category");
			Description = root.getString("description");
			this.LearnType = LearnType;
			
			this.ID = root.getInt("id");
			Power = root.getInt("power");
			Accuracy = root.getInt("accuracy");
			PP = root.getInt("pp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Move(int ID){
		this(ID, "Default");
	}
	
	public String getCategory(){return Category;}
	public String getDescription(){return Description;}
	public String getLearnType(){return LearnType;}
	
	public int getPower(){return Power;}
	public int getAccuracy(){return Accuracy;}
	public int getPP(){return PP;}
	
}
