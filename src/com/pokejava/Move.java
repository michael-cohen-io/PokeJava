import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael
 *
 */
public class Move extends ModelClass {

	private String Category, Description;
	private int Power, Accuracy, PP;
	
	public Move(int ID){
		String data = "";
		
		try {
			data = get("move/"+ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject root = parse(data);
		try {
			//Define Properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Created = root.getString("created");
			Modified = root.getString("modified");
			Category = root.getString("category");
			Description = root.getString("description");
			
			ID = root.getInt("id");
			Power = root.getInt("power");
			Accuracy = root.getInt("accuracy");
			PP = root.getInt("pp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String getCategory(){return Category;}
	public String getDescription(){return Description;}
	
	public int getPower(){return Power;}
	public int getAccuracy(){return Accuracy;}
	public int getPP(){return PP;}
	
	public String toString(){
		String data = "Move: " + Name + "\nID: " + ID;
		return data;
	}
	
	public void printInfo(){
		System.out.println(toString());
	}
}
