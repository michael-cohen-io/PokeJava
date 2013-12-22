package tester;


import java.util.ArrayList;

import com.pokejava.*;

public class TestPokemon {

	public static void main(String[] args){
		System.out.println(pokemonCheck(65));
	}
	
	
	// ** LONG TESTS **
	
	//All Pokemon Tests
	
	private static long getAllPokemonTime(){
		long sTime = System.nanoTime();
		for (int i = 1; i <= 718; i++){
			Pokemon p = new Pokemon(i);
		}
		long eTime = System.nanoTime();
		
		
		return eTime-sTime;
	}
	
	private static boolean isAllPokemonName(){
		for(int i=1; i <= 718; i++){
			Pokemon p = new Pokemon(i);
			String n = p.getName();
		}
		return true;
	}
	
	private static boolean isAllPokemonAbility(){
		for(int i=1; i <= 718; i++){
			Pokemon p = new Pokemon(i);
			ArrayList<Ability> a = p.getAbilities();
		}
		return true;
	}
	
	private static boolean isAllPokemonEggGroup(){
		for(int i=1; i <= 718; i++){
			Pokemon p = new Pokemon(i);
			ArrayList<EggGroup> g = p.getEggGroup();
		}
		return true;
	}
	
	private static boolean isAllPokemonEvolutions(){
		for(int i=1; i <= 718; i++){
			Pokemon p = new Pokemon(i);
			if (p.hasEvolution()){ ArrayList<Pokemon> e = p.getEvolutions();}
		}
		return true;
	}
	
	private static boolean isAllPokemonTypes(){
		for(int i=1; i <= 718; i++){
			Pokemon p = new Pokemon(i);
			ArrayList<Type> t = p.getTypes();
		}
		return true;
	}
	
	private static boolean allPokemonCheck(){
		if (isAllPokemonName() && isAllPokemonAbility() && isAllPokemonEggGroup() && isAllPokemonEvolutions() && isAllPokemonTypes()){
			return true;
		}
		else {
			return false;
		}
	}

	
	
	// ** QUICK TESTS **
	
	//Single Pokemon tests
	
	private static long getPokemonTime(int ID){
		long sTime = System.nanoTime();
		Pokemon p = new Pokemon(ID);
		long eTime = System.nanoTime();
		
		return eTime-sTime;
	}

	private static boolean isPokemonName(int ID){
		Pokemon p = new Pokemon(ID);
		String n = p.getName();
		return true;
	}
	
	private static boolean isPokemonAbility(int ID){
		Pokemon p = new Pokemon(ID);
		ArrayList<Ability> a = p.getAbilities();
		return true;
	}
	
	private static boolean isPokemonEggGroup(int ID){
		Pokemon p = new Pokemon(ID);
		ArrayList<EggGroup> g = p.getEggGroup();
		return true;
	}
	
	private static boolean isPokemonEvolutions(int ID){
		Pokemon p = new Pokemon(ID);
		if(p.hasEvolution()){ArrayList<Pokemon> e = p.getEvolutions();}
		return true;
	}
	
	private static boolean isPokemonTypes(int ID){
		Pokemon p = new Pokemon(ID);
		ArrayList<Type> t = p.getTypes();
		return true;
	}
	
	private static boolean pokemonCheck(int ID){
		if (isPokemonName(ID) && isPokemonAbility(ID) && isPokemonEggGroup(ID) && isPokemonEvolutions(ID) && isPokemonTypes(ID)) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
