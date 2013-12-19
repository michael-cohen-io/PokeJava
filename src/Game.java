import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Game extends ModelClass {

	private String Name, URI, Created, Modified;
	private int ID, Generation, ReleaseYear;
	
	public Game(int ID){
		String data = "";
		
		try {
			data = get("game/"+ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
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
	
	public String getName(){ return Name;}
	public String getURI(){ return URI;}
	public String getCreated(){return Created;}
	public String getModified(){return Modified;}
	
	public int getID(){return ID;}
	public int getGeneration(){return Generation;}
	public int getReleaseYear(){return ReleaseYear;}
}
