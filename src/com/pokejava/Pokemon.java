package com.pokejava;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.*;


/**
 * @author Michael Cohen
 *
 */
public class Pokemon extends ModelClass {

	/* (non-Javadoc)
	 * @see ModelClass#parse(java.lang.String)
	 */

	private String EVYield, GrowthRate, Height, MFRatio, Species, Weight;
	private int Attack, CatchRate, Defense, EggCycles, Exp, Happiness, HP, SpAttack, SpDefense, Speed, Total;
	private ArrayList<Integer> Abilities, Descriptions, Evolutions, EggGroups, Moves, Types;
	private int EvolvesAt;
	
	//Internal property
	private ArrayList<String> LearnTypes; //For moves class
	
	/**
	 * Initializes Pokemon null object
	 * @param int ID
	 */
	public Pokemon(){
		initializePokemon("");
	}
	
	/**
	 * Initializes Pokemon object using said Pokemon's national dex ID
	 * @param int ID
	 */
	public Pokemon(int ID){
		
		String data = "";
		try {
			data = get("pokemon/"+ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		initializePokemon(data);
	}
	
	/**
	 * Initializes Pokemon object using said Pokemon's name
	 * @param String name
	 */
	public Pokemon(String name){
		String data = "";
		try {
			data = get("pokemon/"+name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		initializePokemon(data);
		
	}
	
	//Takes arguments from Constructors and initializes all properties
	private void initializePokemon(String data){
		if (data.equals("")){
			
			Name = "";
			EVYield = "";
			GrowthRate = "";
			Height = "";
			MFRatio =  "";
			URI =   "";
			Species =  "";
			Weight =  "";
			
			Attack = 0;
			CatchRate = 0;
			Defense = 0;
			EggCycles = 0;
			Exp = 0;
			Happiness = 0;
			HP = 0;
			this.ID = 0;
			SpAttack = 0;
			SpDefense = 0;
			Speed =  0;
			Total =  0;
			
			try {
				Created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2013-11-02T13:28:04.914889");
				Modified = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2013-11-02T13:28:04.914889");
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
		}
		else{
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
					
					if (evolutionNode.getJSONObject(i).getString("method").equals("level_up")) {EvolvesAt = evolutionNode.getJSONObject(i).getInt("level");}
					else EvolvesAt = -1;
					
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
	}
	
	
	/**
	 * @return String EVYield
	 */
	public String getEVYield(){ return EVYield;}
	
	/**
	 * @return String GrowthRate
	 */
	public String getGrowthRate(){ return GrowthRate;}
	
	/**
	 * @return String Height
	 */
	public String getHeight(){ return Height;}
	
	/**
	 * @return String MaleToFemaleRatio
	 */
	public String getMFRatio(){ return MFRatio;}
	
	/**
	 * @return String Species
	 */
	public String getSpecies(){ return Species;}
	
	/**
	 * @return String Weight
	 */
	public String getWeight(){ return Weight;}
	
	/**
	 * @return int Attack
	 */
	public int getAttack(){ return Attack;}
	
	/**
	 * @return int CatchRate
	 */
	public int getCatchRate(){ return CatchRate;}
	
	/**
	 * @return int Defense
	 */
	public int getDefense(){ return Defense;}
	
	/**
	 * @return int EggCycle
	 */
	public int getEggCycle(){ return EggCycles;}
	
	/**
	 * @return int EvolvesAt
	 */
	public int getEvolvesAt(){ return EvolvesAt;}
	
	/**
	 * @return int Experience
	 */
	public int getExp(){ return Exp;}
	
	/**
	 * @return int Happiness
	 */
	public int getHappiness(){ return Happiness;}
	
	/**
	 * @return int HP
	 */
	public int getHP(){ return HP;}
	
	/**
	 * @return int SpecialAttack
	 */
	public int getSpAttack(){ return SpAttack;}
	
	/**
	 * @return int SpecialDefense
	 */
	public int getSpDefense(){ return SpDefense;}
	
	/**
	 * @return int Speed
	 */
	public int getSpeed(){ return Speed;}

	/**
	 * @return int Total: Sum of Speed, SpDefense, SpAttack, HP, Attack, and Defense
	 */
	public int getTotal(){ return Total;}
	
	
	/**
	 * @return ArrayList<Ability> AbilityList: All the abilities of the Pokemon
	 */
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
	
	/**
	 * @return ArrayList<Description> DescriptionList: All the descriptions of the Pokemon from all games
	 */
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
	
	/**
	 * @return ArrayList<Pokemon> EvolutionsList: An ArrayList of all Pokemon that this Pokemon can evolve to
	 */
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
	
	/**
	 * @return ArrayList<EggGroup> EggGroupList: An ArrayList of all Egg groups this Pokemon belongs to
	 */
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
	
	/**
	 * @return ArrayList<Move> MovesList: An ArrayList containing all of the possible Moves this Pokemon can learn
	 */
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
	
	/**
	 * @return ArrayList<Type> TypesList: An ArrayList containing all of this Pokemon's types
	 */
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
	
	/**
	 * @return true if this Pokemon has abilities, false if not
	 */
	public boolean hasAbility(){
		if (Abilities.isEmpty()) return false;
		else return true;
	}
	
	/**
	 * @return true if this Pokemon has descriptions, false if not
	 */
	public boolean hasDescription(){
		if (Descriptions.isEmpty()) return false;
		else return true;
	}
	
	/**
	 * @return true if this Pokemon has evolutions, false if not
	 */
	public boolean hasEvolution(){
		if (Evolutions.isEmpty()) return false;
		else return true;
	}
	
	/**
	 * @return true if this Pokemon belongs to Egg Groups, false if not
	 */
	public boolean hasEggGroup(){
		if (EggGroups.isEmpty()) return false;
		else return true;
	}
	
	/**
	 * @return true if this Pokemon can learn any moves, false if not
	 */
	public boolean hasMove(){
		if (Moves.isEmpty()) return false;
		else return true;
	}
	
	/**
	 * @return true if this Pokemon has any types, false if not
	 */
	public boolean hasType(){
		if (Types.isEmpty()) return false;
		else return true;
	}
	
}
