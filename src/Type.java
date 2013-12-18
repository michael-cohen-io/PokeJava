import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * @author Michael
 *
 */
public class Type extends ModelClass {
	private String Name, URI, Created, Modified;
	private int ID;
	private ArrayList<Integer> Ineffective, NoEffect, Resistance, SuperEffective, Weakness;
	
	public Type(int ID) {
		String data = "";
		try {
			data = get("type/"+ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject root = parse(data);
		try {
			//Define properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			Created = root.getString("created");
			Modified = root.getString("modified");
			
			this.ID = root.getInt("id");
			
			//Ineffective ArrayList defining
			JSONArray ineffectiveNode = root.getJSONArray("ineffective");
			Ineffective = new ArrayList<Integer>();
				for (int i = 0; i < ineffectiveNode.length(); i++) {
					String ineffectiveURI = ineffectiveNode.getJSONObject(i).getString("resource_uri");
					ineffectiveURI = ineffectiveURI.substring(13);
					ineffectiveURI = ineffectiveURI.replace("/", "");
					
					Ineffective.add(Integer.parseInt(ineffectiveURI));
				}
			if (Ineffective.isEmpty()) { Ineffective.add(null);}
			
			//NoEffect ArrayList defining
			JSONArray noeffectNode = root.getJSONArray("no_effect");
			NoEffect = new ArrayList<Integer>();
				for (int i = 0; i < noeffectNode.length(); i++) {
					String noeffectURI = noeffectNode.getJSONObject(i).getString("resource_uri");
					noeffectURI = noeffectURI.substring(13);
					noeffectURI = noeffectURI.replace("/", "");
					
					NoEffect.add(Integer.parseInt(noeffectURI));
				}
			if (NoEffect.isEmpty()){ NoEffect.add(null);}
			
			//Resistance ArrayList defining
			JSONArray resistanceNode = root.getJSONArray("resistance");
			Resistance = new ArrayList<Integer>();
				for (int i = 0; i < resistanceNode.length(); i++) {
					String resistanceURI = resistanceNode.getJSONObject(i).getString("resource_uri");
					resistanceURI = resistanceURI.substring(13);
					resistanceURI = resistanceURI.replace("/", "");
					
					Resistance.add(Integer.parseInt(resistanceURI));
				}
			if (Resistance.isEmpty()){ Resistance.add(null);}
				
			//SuperEffective ArrayList defining
			JSONArray supereffectiveNode = root.getJSONArray("super_effective");
			SuperEffective = new ArrayList<Integer>();
				for (int i = 0; i < supereffectiveNode.length(); i++) {
					String supereffectiveURI = supereffectiveNode.getJSONObject(i).getString("resource_uri");
					supereffectiveURI = supereffectiveURI.substring(13);
					supereffectiveURI = supereffectiveURI.replace("/", "");
					
					SuperEffective.add(Integer.parseInt(supereffectiveURI));
				}
			if (SuperEffective.isEmpty()){ SuperEffective.add(null); }
				
			//Weakness ArrayList defining
			JSONArray weaknessNode = root.getJSONArray("weakness");
			Weakness = new ArrayList<Integer>();
				for (int i = 0; i < weaknessNode.length(); i++) {
					String weaknessURI = weaknessNode.getJSONObject(i).getString("resource_uri");
					weaknessURI = weaknessURI.substring(13);
					weaknessURI = weaknessURI.replace("/", "");
					
					Weakness.add(Integer.parseInt(weaknessURI));
				}
			if (Weakness.isEmpty()) { Weakness.add(null);}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getName(){ return Name;}
	public String getURI(){ return URI;}
	public String getCreated(){return Created;}
	public String getModified(){return Modified;}
	
	public int getID(){return ID;}
	
	public ArrayList<Type> getIneffective(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		for (int i = 0; i < Ineffective.size(); i++){
			Type t = new Type(Ineffective.get(i));
			list.add(t);
		}
		if (list.isEmpty()) { return null;}
		
		return list;
	}
	public ArrayList<Type> getNoEffect(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		for (int i = 0; i < NoEffect.size(); i++){
			Type t = new Type(NoEffect.get(i));
			list.add(t);
		}
		if (list.isEmpty()) { return null;}
		
		return list;
	}
	public ArrayList<Type> getResistance(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		for (int i = 0; i < Resistance.size(); i++){
			Type t = new Type(Resistance.get(i));
			list.add(t);
		}
		if (list.isEmpty()) { return null;}
		
		return list;
	}
	public ArrayList<Type> getSuperEffective(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		for (int i = 0; i < Resistance.size(); i++){
			Type t = new Type(Resistance.get(i));
			list.add(t);
		}
		if (list.isEmpty()) { return null;}
		
		return list;
	}
	public ArrayList<Type> getWeakness(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		for (int i = 0; i < Resistance.size(); i++){
			Type t = new Type(Resistance.get(i));
			list.add(t);
		}
		if (list.isEmpty()) { return null;}
		
		return list;
	}
	
	public String toString(){
		String data = "Type: " + Name + "\nID: " + ID;
		return data;
	}
	
	public void printInfo(){
		System.out.println(toString());
	}
}
