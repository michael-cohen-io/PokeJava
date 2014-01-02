package com.pokejava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * @author Michael
 *
 */
public class Type extends ModelClass {
	
	private ArrayList<Integer> Ineffective, NoEffect, Resistance, SuperEffective, Weakness;
	
	public Type(int ID) {
		String data = "";
		data = get("type/"+ID);
		
		JSONObject root = parse(data);
		try {
			//Define properties
			Name = root.getString("name");
			URI = root.getString("resource_uri");
			
			this.ID = root.getInt("id");
			
			Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
			Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
			
			//Ineffective ArrayList defining
			JSONArray ineffectiveNode = root.getJSONArray("ineffective");
			Ineffective = new ArrayList<Integer>();
				for (int i = 0; i < ineffectiveNode.length(); i++) {
					String ineffectiveURI = ineffectiveNode.getJSONObject(i).getString("resource_uri");
					ineffectiveURI = ineffectiveURI.substring(13);
					ineffectiveURI = ineffectiveURI.replace("/", "");
					
					Ineffective.add(Integer.parseInt(ineffectiveURI));
				}
			
			//NoEffect ArrayList defining
			JSONArray noeffectNode = root.getJSONArray("no_effect");
			NoEffect = new ArrayList<Integer>();
				for (int i = 0; i < noeffectNode.length(); i++) {
					String noeffectURI = noeffectNode.getJSONObject(i).getString("resource_uri");
					noeffectURI = noeffectURI.substring(13);
					noeffectURI = noeffectURI.replace("/", "");
					
					NoEffect.add(Integer.parseInt(noeffectURI));
				}
			
			//Resistance ArrayList defining
			JSONArray resistanceNode = root.getJSONArray("resistance");
			Resistance = new ArrayList<Integer>();
				for (int i = 0; i < resistanceNode.length(); i++) {
					String resistanceURI = resistanceNode.getJSONObject(i).getString("resource_uri");
					resistanceURI = resistanceURI.substring(13);
					resistanceURI = resistanceURI.replace("/", "");
					
					Resistance.add(Integer.parseInt(resistanceURI));
				}
				
			//SuperEffective ArrayList defining
			JSONArray supereffectiveNode = root.getJSONArray("super_effective");
			SuperEffective = new ArrayList<Integer>();
				for (int i = 0; i < supereffectiveNode.length(); i++) {
					String supereffectiveURI = supereffectiveNode.getJSONObject(i).getString("resource_uri");
					supereffectiveURI = supereffectiveURI.substring(13);
					supereffectiveURI = supereffectiveURI.replace("/", "");
					
					SuperEffective.add(Integer.parseInt(supereffectiveURI));
				}
				
			//Weakness ArrayList defining
			JSONArray weaknessNode = root.getJSONArray("weakness");
			Weakness = new ArrayList<Integer>();
				for (int i = 0; i < weaknessNode.length(); i++) {
					String weaknessURI = weaknessNode.getJSONObject(i).getString("resource_uri");
					weaknessURI = weaknessURI.substring(13);
					weaknessURI = weaknessURI.replace("/", "");
					
					Weakness.add(Integer.parseInt(weaknessURI));
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public ArrayList<Type> getIneffective(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		if (!Ineffective.isEmpty()){	
			for (int i = 0; i < Ineffective.size(); i++){
				Type t = new Type(Ineffective.get(i));
				list.add(t);
			}
		}
		else { return null;}
		
		return list;
	}
	public boolean hasIneffective(){
		if (Ineffective.isEmpty()) return false;
		else return true;
	}
	
	public ArrayList<Type> getNoEffect(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		if (!NoEffect.isEmpty()){
			for (int i = 0; i < NoEffect.size(); i++){
				Type t = new Type(NoEffect.get(i));
				list.add(t);
			}
		}
		else { return null;}
		
		return list;
	}
	public boolean hasNoEffect(){
		if (NoEffect.isEmpty()) return false;
		else return true;
	}
	
	public ArrayList<Type> getResistance(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		if (!Resistance.isEmpty()) {
			for (int i = 0; i < Resistance.size(); i++){
				Type t = new Type(Resistance.get(i));
				list.add(t);
			}
		}
		else { return null;}
		
		return list;
	}
	public boolean hasResistance(){
		if (Resistance.isEmpty()) return false;
		else return true;
	}
	
	
	
	public ArrayList<Type> getSuperEffective(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		if (!SuperEffective.isEmpty()) {
			for (int i = 0; i < SuperEffective.size(); i++){
				Type t = new Type(SuperEffective.get(i));
				list.add(t);
			}
		}
		else { return null;}
		
		return list;
	}
	public boolean hasSuperEffective(){
		if (SuperEffective.isEmpty()) return false;
		else return true;
	}
	
	
	public ArrayList<Type> getWeakness(){
		ArrayList<Type> list = new ArrayList<Type>();
		
		if (!Weakness.isEmpty()) {
			for (int i = 0; i < Weakness.size(); i++){
				Type t = new Type(Weakness.get(i));
				list.add(t);
			}
		}
		else { return null;}
		
		return list;
	}
	public boolean hasWeakness(){
		if (Weakness.isEmpty()) return false;
		else return true;
	}
	
	

}
