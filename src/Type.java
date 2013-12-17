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
	private ArrayList<Type> Ineffective, NoEffect, Resistance, SuperEffective, Weakness;
	
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
			Ineffective = new ArrayList<Type>();
				for (int i = 0; i < ineffectiveNode.length(); i++) {
					String ineffectiveURI = ineffectiveNode.getJSONObject(i).getString("resource_uri");
					ineffectiveURI = ineffectiveURI.substring(13);
					ineffectiveURI = ineffectiveURI.replace("/", "");
					Type IneffectiveType = new Type(Integer.parseInt(ineffectiveURI));
					Ineffective.add(IneffectiveType);
				}
			if (Ineffective.isEmpty()) { Ineffective.add(null);}
			//NoEffect ArrayList defining
			JSONArray noeffectNode = root.getJSONArray("no_effect");
			NoEffect = new ArrayList<Type>();
				for (int i = 0; i < noeffectNode.length(); i++) {
					String noeffectURI = noeffectNode.getJSONObject(i).getString("resource_uri");
					noeffectURI = noeffectURI.substring(13);
					noeffectURI = noeffectURI.replace("/", "");
					Type NoEffectType = new Type(Integer.parseInt(noeffectURI));
					NoEffect.add(NoEffectType);
				}
			if (NoEffect.isEmpty()){ NoEffect.add(null);}
			
			//Resistance ArrayList defining
			JSONArray resistanceNode = root.getJSONArray("resistance");
			Resistance = new ArrayList<Type>();
				for (int i = 0; i < resistanceNode.length(); i++) {
					String resistanceURI = resistanceNode.getJSONObject(i).getString("resource_uri");
					resistanceURI = resistanceURI.substring(13);
					resistanceURI = resistanceURI.replace("/", "");
					Type ResistanceType = new Type(Integer.parseInt(resistanceURI));
					Resistance.add(ResistanceType);
				}
			if (Resistance.isEmpty()){ Resistance.add(null);}
				
			//SuperEffective ArrayList defining
			JSONArray supereffectiveNode = root.getJSONArray("super_effective");
			SuperEffective = new ArrayList<Type>();
				for (int i = 0; i < supereffectiveNode.length(); i++) {
					String supereffectiveURI = supereffectiveNode.getJSONObject(i).getString("resource_uri");
					supereffectiveURI = supereffectiveURI.substring(13);
					supereffectiveURI = supereffectiveURI.replace("/", "");
					Type SuperEffectiveType = new Type(Integer.parseInt(supereffectiveURI));
					SuperEffective.add(SuperEffectiveType);
				}
			if (SuperEffective.isEmpty()){ SuperEffective.add(null); }
				
			//Weakness ArrayList defining
			JSONArray weaknessNode = root.getJSONArray("weakness");
			Weakness = new ArrayList<Type>();
				for (int i = 0; i < weaknessNode.length(); i++) {
					String weaknessURI = weaknessNode.getJSONObject(i).getString("resource_uri");
					weaknessURI = weaknessURI.substring(13);
					weaknessURI = weaknessURI.replace("/", "");
					Type WeaknessType = new Type(Integer.parseInt(weaknessURI));
					Weakness.add(WeaknessType);
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
	
	public ArrayList<Type> getIneffective(){return Ineffective;}
	public ArrayList<Type> getNoEffect(){return NoEffect;}
	public ArrayList<Type> getResistance(){return Resistance;}
	public ArrayList<Type> getSuperEffective(){return SuperEffective;}
	public ArrayList<Type> getWeakness(){return Weakness;}
}
