package com.pokejava;
/**
 * @author Michael Cohen
 *
 */

import org.apache.http.client.fluent.Request;
import org.json.*;

public abstract class ModelClass {
	
	protected String Name, URI, Created, Modified;
	protected int ID;

	
	protected JSONObject parse(String data) {
		JSONObject root;
		try {
		root = new JSONObject(data);		
		return root;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	protected String get(String urlAddress) {
		String data = "";
		try {
			data = Request.Get("http://pokeapi.co/api/v1/" + urlAddress).execute().returnContent().asString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		return data;
	}
	
	public String getName(){ return Name;}
	public String getURI(){ return URI;}
	public String getCreated(){return Created;}
	public String getModified(){return Modified;}
	
	public int getID(){return ID;}
	
	public String toString(){
		String data = this.getClass().getSimpleName() + ": " + Name + "\nID: " + ID;
		return data;
	}
	
	public void printInfo(){
		System.out.println(toString());
	}
}
