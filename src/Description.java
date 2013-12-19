import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class Description extends ModelClass {
	
	private String Name, URI, Created, Modified;
	private int ID;
	private ArrayList<Integer> Games;
	private Pokemon pokemon;
	
	public Description(int ID){
		String data = "";
		
		try {
			data = get("description/"+ID);
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
			
			String pokemonURI = root.getJSONObject("pokemon").getString("resource_uri");
			pokemonURI = pokemonURI.substring(16);
			pokemonURI = pokemonURI.replace("/", "");
			pokemon = new Pokemon(Integer.parseInt(pokemonURI));
			
			//Game ArrayList defining
			JSONArray gameNode = root.getJSONArray("games");
			for (int i = 0; i < gameNode.length(); i++){
				String gameURI = gameNode.getJSONObject(i).getString("resource_uri");
				gameURI = gameURI.substring(13);
				gameURI = gameURI.replace("/", "");
				
				Games.add(Integer.parseInt(gameURI));
			}
			if(Games.isEmpty()){ Games.add(null);}
			
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public String getName(){ return Name;}
	public String getURI(){ return URI;}
	public String getCreated(){return Created;}
	public String getModified(){return Modified;}
	
	public int getID(){return ID;}
	
	public Pokemon getPokemon(){return pokemon;}
	
	public ArrayList<Game> getGames() {
		ArrayList<Game> list = new ArrayList<Game>();
		
		for (int i = 0; i < Games.size(); i++) {
			Game g = new Game(Games.get(i));
			list.add(g);
		}
		if(list.isEmpty()) { return null;}
		
		return list;
	}
	
}
