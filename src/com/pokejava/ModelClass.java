package com.pokejava;
/**
 * @author Michael Cohen
 *
 */

import org.apache.http.client.fluent.Request;
import org.json.*;

public abstract class ModelClass {
	
	public String Name, URI, Created, Modified;
	public int ID;

	
	protected JSONObject parse(String data) {
		long sTime = System.nanoTime();
		JSONObject root;
		try {
		root = new JSONObject(data);		
		
		long eTime = System.nanoTime();
		System.out.println("Parse: " + (eTime-sTime));
		
		return root;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	protected String get(String urlAddress) {
		long sTime = System.nanoTime();
		String data = "";
		try {
			data = Request.Get("http://pokeapi.co/api/v1/" + urlAddress).execute().returnContent().asString();
		} catch (Exception e){
			e.printStackTrace();
		}
		
		long eTime = System.nanoTime();
		System.out.println("Get: " + (eTime-sTime));
		
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
