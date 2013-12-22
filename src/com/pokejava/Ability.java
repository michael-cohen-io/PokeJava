import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Ability extends ModelClass {
	private String Description; 
	
	public Ability(int ID){
		String data = "";
		try {
			data = get("ability/"+ID);
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
			Description = root.getString("description");
			
			this.ID = root.getInt("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public String getDescription(){return Description;}
	
	public String toString(){
		String data = "Ability: " + Name + "\nID: " + ID;
		return data;
	}
	
	public void printInfo(){
		System.out.println(toString());
	}
}
