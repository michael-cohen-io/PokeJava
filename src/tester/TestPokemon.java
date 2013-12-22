package tester;

import java.util.ArrayList;

import com.pokejava.*;

public class TestPokemon {

	public static void main(String[] args){
			/*
			ArrayList<Pokemon> l = getAllPokemon();
			for (Pokemon p : l){
				p.printInfo();
			}
			*/
			Pokemon p = new Pokemon(523);
	}
	
	
	public static ArrayList<Pokemon> getAllPokemon(){
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		
		for (int i = 1; i <= 718; i++){
			list.add(new Pokemon(i));
		}
		
		return list;
	}
	
}
