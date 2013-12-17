/**
 * @author Michael Cohen
 *
 */
import java.io.IOException;
import java.util.ArrayList;

import org.json.*;


public class Pokemon extends ModelClass {

	/* (non-Javadoc)
	 * @see ModelClass#parse(java.lang.String)
	 */
	
	//TODO: Change Created, Modified, other special types from String to specific types 
	private String Name, Created, EVYield, GrowthRate, Height, MFRatio, Modified, URI, Species, Weight;
	private int Attack, CatchRate, Defense, EggCycles, Exp, Happiness, HP, ID, SpAttack, SpDefense, Speed, Total;
	private ArrayList<Integer> Abilities, Evolutions, EggGroups, Moves, Types;
	
	
	
	public Pokemon(int ID){
		String data = "";
		try {
			data = get("pokemon/"+ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject root = parse(data);
		try {
			//Define properties
			Name = root.getString("name");
			Created = root.getString("created");
			EVYield =  root.getString("ev_yield");
			GrowthRate = root.getString("growth_rate");
			Height =  root.getString("height");
			MFRatio = root.getString("male_female_ratio");
			Modified = root.getString("modified");
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
			
			//Evolutions ArrayList Defining
			Evolutions = new ArrayList<Integer>();
			JSONArray evolutionNode = root.getJSONArray("evolutions");
			for (int i = 0; i < evolutionNode.length(); i++) {
				String evolutionURI = evolutionNode.getJSONObject(i).getString("resource_uri");
				evolutionURI = evolutionURI.substring(16);
				evolutionURI = evolutionURI.replace("/", "");
				
				Evolutions.add(Integer.parseInt(evolutionURI));
			}
			if (Evolutions.isEmpty()) { Evolutions.add(null);}
			
			
			//EggGroups ArrayList Defining
			EggGroups = new ArrayList<Integer>();
			JSONArray eggNode = root.getJSONArray("egg_groups");
			for (int i = 0; i < eggNode.length(); i++) {
				String eggURI = eggNode.getJSONObject(i).getString("resource_uri");
				eggURI = eggURI.substring(12);
				eggURI = eggURI.replace("/", "");
				
				EggGroups.add(Integer.parseInt(eggURI));
			}
			if (EggGroups.isEmpty()) { EggGroups.add(null);}
			
			//Moves ArrayList Defining
			Moves = new ArrayList<Integer>();
			JSONArray moveNode = root.getJSONArray("moves");
			for (int i = 0; i < moveNode.length(); i++) {
				String moveURI = moveNode.getJSONObject(i).getString("resource_uri");
				moveURI = moveURI.substring(13);
				moveURI = moveURI.replace("/", "");
				
				Moves.add(Integer.parseInt(moveURI));
			}
			if (Moves.isEmpty()) { Moves.add(null);}
			
			//Types ArrayList Defining
			Types = new ArrayList<Integer>();
			JSONArray typeNode = root.getJSONArray("types");
			for (int i = 0; i < typeNode.length(); i++) {
				String typesURI = typeNode.getJSONObject(i).getString("resource_uri");
				typesURI = typesURI.substring(13);
				typesURI = typesURI.replace("/", "");
				
				Types.add(Integer.parseInt(typesURI));
			}
			if (Types.isEmpty()) { Types.add(null);}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getName(){ return Name;}
	public String getCreated() { return Created;}
	public String getEVYield(){ return EVYield;}
	public String getGrowthRate(){ return GrowthRate;}
	public String getHeight(){ return Height;}
	public String getMFRatio(){ return MFRatio;}
	public String getModified(){ return Modified;}
	public String getURI(){ return URI;}
	public String getSpecies(){ return Species;}
	public String getWeight(){ return Weight;}
	
	public int getAttack(){ return Attack;}
	public int getCatchRate(){ return CatchRate;}
	public int getDefense(){ return Defense;}
	public int getEggCycle(){ return EggCycles;}
	public int getExp(){ return Exp;}
	public int getHappiness(){ return Happiness;}
	public int getHP(){ return HP;}
	public int getID(){ return ID;}
	public int getSpAttack(){ return SpAttack;}
	public int getSpDefense(){ return SpDefense;}
	public int getSpeed(){ return Speed;}
	public int getTotal(){ return Total;}
	
	public ArrayList<Ability> getAbilities(){ 
		ArrayList<Ability> abilityList = new ArrayList<Ability>();
		
		for (int i = 0; i < Abilities.size(); i++) {
			Ability a = new Ability(Abilities.get(i));
			abilityList.add(a);
		}
		if (abilityList.isEmpty()) { return null; }
		return abilityList;
	}
	
	public ArrayList<Pokemon> getEvolutions(){ 
		ArrayList<Pokemon> evolutionList = new ArrayList<Pokemon>();
		
		for (int i = 0; i < Evolutions.size(); i++) {
			Pokemon p = new Pokemon(Evolutions.get(i));
			evolutionList.add(p);
		}
		if (evolutionList.isEmpty()) { return null; }
		return evolutionList;
	}
	
	public ArrayList<EggGroup> getEggGroup(){ 
		ArrayList<EggGroup> eggList = new ArrayList<EggGroup>();
		
		for (int i = 0; i < EggGroups.size(); i++) {
			EggGroup e = new EggGroup(EggGroups.get(i));
			eggList.add(e);
		}
		if (eggList.isEmpty()) { return null; }
		return eggList;
	}
	
	public ArrayList<Move> getMoves(){ 
		ArrayList<Move> moveList = new ArrayList<Move>();
		
		for (int i = 0; i < Moves.size(); i++) {
			Move m = new Move(Moves.get(i));
			moveList.add(m);
		}
		if (moveList.isEmpty()) { return null; }
		return moveList;
	}
	
	public ArrayList<Type> getTypes(){ 
		ArrayList<Type> typeList = new ArrayList<Type>();
		
		for (int i = 0; i < Types.size(); i++) {
			Type t = new Type(Types.get(i));
			typeList.add(t);
		}
		if (typeList.isEmpty()) { return null; }
		return typeList;
	}
	
	
	public String toString(){
		String data = "Pokemon: " + Name + "\nID: " + ID;
		return data;
	}
	
	public void printInfo(){
		System.out.println(toString());
	}

}
