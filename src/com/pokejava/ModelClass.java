package com.pokejava;
/**
 * @author Michael Cohen
 *
 */

import java.util.Date;

import org.apache.http.client.fluent.Request;
import org.json.*;



/**
 * @author root
 *
 */
public abstract class ModelClass {
	
	protected String Name, URI;
	protected int ID;
	protected Date Created, Modified;
	
	

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
	
	/**
	 * @return String Name: Name representation of object
	 */
	public String getName(){ return Name;}
	
	
	/**
	 * @return String URI: URI to the specific Object
	 */
	public String getURI(){ return URI;}
	
	
	/**
	 * @return Date Modified: A date object representing the last time said API was updated
	 */
	public Date getModified(){return Modified;}
	
	
	/**
	 * @return Date Created: A date object representing the API's creation
	 */
	public Date getCreated(){ return Created;}
	
	
	/**
	 * @return int ID: ID number of the object within the pokeapi database
	 */
	public int getID(){return ID;}
	
	public String toString(){
		String data = this.getClass().getSimpleName() + ": " + Name + "\nID: " + ID;
		return data;
	}
	
	/**
	 * Prints the toString() of the object to the console
	 */
	public void printInfo(){
		System.out.println(toString());
	}
}
