import java.io.IOException;

import org.json.JSONObject;

/**
 * @author Michael
 *
 */
public class Sprite extends ModelClass {

	private String Name, URI, Created, Modified, Image;
	private int ID;
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
	
	
	public String getName(){ return Name;}
	public String getURI(){ return URI;}
	public String getCreated(){return Created;}
	public String getModified(){return Modified;}
	public String getImage(){return Image;}
	
	public int getID(){return ID;}
	
	public Pokemon getPokemon(){return pokemon;}
}
