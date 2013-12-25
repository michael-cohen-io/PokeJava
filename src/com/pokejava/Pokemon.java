package com.pokejava;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.*;


public class Pokemon extends ModelClass {

	/* (non-Javadoc)
	 * @see ModelClass#parse(java.lang.String)
	 */

	private String EVYield, GrowthRate, Height, MFRatio, Species, Weight;
	private int Attack, CatchRate, Defense, EggCycles, Exp, Happiness, HP, SpAttack, SpDefense, Speed, Total;
	//private int EvolvesAt;
	private ArrayList<Integer> Abilities, Descriptions, Evolutions, EggGroups, Moves, Types;
	
	//Internal property
	private ArrayList<String> LearnTypes; //For moves class
	
	public Pokemon(int ID){
		
			String data = "";
			try {
				data = get("pokemon/"+ID);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			JSONObject root = parse(data);
			try {
				//Define properties
				Name = root.getString("name");
				
				EVYield =  root.getString("ev_yield");
				GrowthRate = root.getString("growth_rate");
				Height =  root.getString("height");
				MFRatio = root.getString("male_female_ratio");
				URI =  root.getString("resource_uri");
				Species = root.getString("species");
				Weight = root.getString("weight");
				
				Attack = root.getInt("attack");
				CatchRate = root.getInt("catch_rate");
				Defense =  root.getInt("defense");
				EggCycles = root.getInt("egg_cycles");
				Exp = root.getInt("exp");
				Happiness = root.getInt("happiness");
				HP = root.getInt("hp");
				this.ID = root.getInt("national_id");
				SpAttack = root.getInt("sp_atk");
				SpDefense = root.getInt("sp_def");
				Speed =  root.getInt("speed");
				Total =  root.getInt("total");
				
				Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("created").substring(0, 19));
				Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(root.getString("modified").substring(0, 19));
				
				/*
				 * Instead of initializing the ArrayList<Pokemon> at every Pokemon constructor, a list of IDs is initialized.
				 * This is not so much a problem with the Pokemon class as it is in classes such as Type, which would recursively continue initializing infinite Types
				 * due to the cyclical nature of types and their weaknessess/super-effectiveness
				 */
				
				//Abilities ArrayList Defining
				Abilities = new ArrayList<Integer>();
				JSONArray abilityNode = root.getJSONArray("abilities");
				for (int i = 0; i < abilityNode.length(); i++) {
					String abilityURI = abilityNode.getJSONObject(i).getString("resource_uri");
					abilityURI = abilityURI.substring(16);
					abilityURI = abilityURI.replace("/", "");
					
					Abilities.add(Integer.parseInt(abilityURI));
				}
				if (Abilities.isEmpty()) { Abilities.add(null);}
				
				//Descriptions ArrayList Defining
				Descriptions = new ArrayList<Integer>();
				JSONArray descriptionNode = root.getJSONArray("descriptions");
				for (int i = 0; i < descriptionNode.length(); i++){
					String descriptionURI = descriptionNode.getJSONObject(i).getString("resource_uri");
					descriptionURI = descriptionURI.substring(20);
					descriptionURI = descriptionURI.replace("/", "");
					
					Descriptions.add(Integer.parseInt(descriptionURI));
				}
				
				//Evolutions ArrayList Defining
				Evolutions = new ArrayList<Integer>();
				JSONArray evolutionNode = root.getJSONArray("evolutions");
				for (int i = 0; i < evolutionNode.length(); i++) {
					String evolutionURI = evolutionNode.getJSONObject(i).getString("resource_uri");
					evolutionURI = evolutionURI.substring(16);
					evolutionURI = evolutionURI.replace("/", "");
					
					/*
					if (evolutionNode.getJSONObject(i).getString("method").equals("level_up")) {EvolvesAt = evolutionNode.getJSONObject(i).getInt("level");}
					
					left out until level is fully implemented for all evolutions
					*/
					Evolutions.add(Integer.parseInt(evolutionURI));
				}
				
				
				//EggGroups ArrayList Defining
				EggGroups = new ArrayList<Integer>();
				JSONArray eggNode = root.getJSONArray("egg_groups");
				for (int i = 0; i < eggNode.length(); i++) {
					String eggURI = eggNode.getJSONObject(i).getString("resource_uri");
					eggURI = eggURI.substring(12);
					eggURI = eggURI.replace("/", "");
					
					EggGroups.add(Integer.parseInt(eggURI));
				}
				
				//Moves ArrayList Defining
				Moves = new ArrayList<Integer>();
				LearnTypes = new ArrayList<String>();
				JSONArray moveNode = root.getJSONArray("moves");
				for (int i = 0; i < moveNode.length(); i++) {
					String moveURI = moveNode.getJSONObject(i).getString("resource_uri");
					moveURI = moveURI.substring(13);
					moveURI = moveURI.replace("/", "");
					LearnTypes.add(moveNode.getJSONObject(i).getString("learn_type"));
					
					Moves.add(Integer.parseInt(moveURI));
				}
				
				//Types ArrayList Defining
				Types = new ArrayList<Integer>();
				JSONArray typeNode = root.getJSONArray("types");
				for (int i = 0; i < typeNode.length(); i++) {
					String typesURI = typeNode.getJSONObject(i).getString("resource_uri");
					typesURI = typesURI.substring(13);
					typesURI = typesURI.replace("/", "");
					
					Types.add(Integer.parseInt(typesURI));
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}
	
	public String getEVYield(){ return EVYield;}
	public String getGrowthRate(){ return GrowthRate;}
	public String getHeight(){ return Height;}
	public String getMFRatio(){ return MFRatio;}
	public String getSpecies(){ return Species;}
	public String getWeight(){ return Weight;}
	
	public int getAttack(){ return Attack;}
	public int getCatchRate(){ return CatchRate;}
	public int getDefense(){ return Defense;}
	public int getEggCycle(){ return EggCycles;}
	public int getExp(){ return Exp;}
	public int getHappiness(){ return Happiness;}
	public int getHP(){ return HP;}
	public int getSpAttack(){ return SpAttack;}
	public int getSpDefense(){ return SpDefense;}
	public int getSpeed(){ return Speed;}
	public int getTotal(){ return Total;}
	//public int EvolvesAt(){ return EvolvesAt;}
	
	public ArrayList<Ability> getAbilities(){ 
		ArrayList<Ability> abilityList = new ArrayList<Ability>();
		if(!Abilities.isEmpty()){
			for (int i = 0; i < Abilities.size(); i++) {
				Ability a = new Ability(Abilities.get(i));
				abilityList.add(a);
			}
		}
		else { return null; }
		return abilityList;
	}
	
	public ArrayList<Description> getDescriptions(){
		ArrayList<Description> descriptionList = new ArrayList<Description>();
		if (!Descriptions.isEmpty()){
			for (int i = 0; i < Descriptions.size(); i++){
				Description d = new Description(Descriptions.get(i));
				descriptionList.add(d);
			}
		}
		else {return null;}
		return descriptionList;
		
	}
	
	public ArrayList<Pokemon> getEvolutions(){ 
		ArrayList<Pokemon> evolutionList = new ArrayList<Pokemon>();
		
		if (!Evolutions.isEmpty()) {
			for (int i = 0; i < Evolutions.size(); i++) {
				Pokemon p = new Pokemon(Evolutions.get(i));
				evolutionList.add(p);
			}
		}
		else { return null; }
		return evolutionList;
	}
	
	public ArrayList<EggGroup> getEggGroup(){ 
		ArrayList<EggGroup> eggList = new ArrayList<EggGroup>();
		
		if (!EggGroups.isEmpty()) {
			for (int i = 0; i < EggGroups.size(); i++) {
				EggGroup e = new EggGroup(EggGroups.get(i));
				eggList.add(e);
			}
		}
		else { return null; }
		return eggList;
	}
	
	public ArrayList<Move> getMoves(){ 
		ArrayList<Move> moveList = new ArrayList<Move>();
		
		if (!Moves.isEmpty()) {	
			for (int i = 0; i < Moves.size(); i++) {
				Move m = new Move(Moves.get(i), LearnTypes.get(i));
				moveList.add(m);
			}
		}
		else { return null; }
		return moveList;
	}
	
	public ArrayList<Type> getTypes(){ 
		ArrayList<Type> typeList = new ArrayList<Type>();
		
		if (!Types.isEmpty()){
			for (int i = 0; i < Types.size(); i++) {
				Type t = new Type(Types.get(i));
				typeList.add(t);
			}
		}
		else { return null; }
		
		return typeList;
	}

	public boolean hasEvolution(){
		if (getEvolutions() == null) return false;
		else return true;
	}
	
	public boolean hasDescription(){
		if (getDescriptions() == null) return false;
		else return true;
	}
}
