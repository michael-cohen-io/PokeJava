import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Michael Cohen
 *
 */
public class EggGroup extends ModelClass {

	private ArrayList<Integer> Pokemon;
	
	public EggGroup(int ID) {
		
		String data = "";
		try {
			data = get("egg/"+ID);
		} catch (IOException e){
			e.printStackTrace();
		}
		
		JSONObject root = parse(data);
		
		try {
			//Define Properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Created = root.getString("created");
			Modified = root.getString("modified");
			
			this.ID = root.getInt("id");
		
			Pokemon = new ArrayList<Integer>();
			JSONArray pokemonNode = root.getJSONArray("pokemon");
			for (int i = 0; i < pokemonNode.length(); i++) {
				String pokemonURI = pokemonNode.getJSONObject(i).getString("resource_uri");
				pokemonURI = pokemonURI.substring(16);
				pokemonURI = pokemonURI.replace("/", "");
				
				Pokemon.add(Integer.parseInt(pokemonURI));
			}
			if (Pokemon.isEmpty()) { Pokemon.add(null);} // Will never actually execute. Just another layer of protection
			
		} catch (Exception e){
			e.printStackTrace();
		}	
	}
	
	
	public ArrayList<Pokemon> getPokemon(){
		ArrayList<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		for (int i = 0; i < Pokemon.size(); i++){
			Pokemon p = new Pokemon(Pokemon.get(i));
			pokemonList.add(p);
		}
		if (pokemonList.isEmpty()){ return null;} // Will never actually execute. Just another layer of protection
		
		return pokemonList;
	}
	
	
	public String toString(){
		String data = "Egg Group: " + Name + "\nID: " + ID;
		return data;
	}
	
	public void printInfo(){
		System.out.println(toString());
	}
}
