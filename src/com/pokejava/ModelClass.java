package com.pokejava;
/**
 * @author Michael Cohen
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;

public abstract class ModelClass {
	
	public String Name, URI, Created, Modified;
	public int ID;
	
	
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

	protected String get(String urlAddress) throws IOException {
		urlAddress = "http://pokeapi.co/api/v1/" + urlAddress;
		URL url = new URL(urlAddress);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		if (conn.getResponseCode() != 200) {
			throw new IOException(conn.getResponseMessage());
		}
		
		//Buffer Result into a string
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		//Disconnect
		rd.close();
		conn.disconnect();

		return sb.toString();
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
