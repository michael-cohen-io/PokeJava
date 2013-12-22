package tester;


import java.util.ArrayList;

import com.pokejava.*;

public class TestPokemon {

	public static void main(String[] args){
		/*long sTime = System.nanoTime();
		ArrayList<Pokemon> p = getAllPokemon();
		long eTime = System.nanoTime();
		
		System.out.println("Total time: " + (eTime-sTime));
		*/
		Pokemon p = new Pokemon(1);
	}
	
	public static ArrayList<Pokemon> getAllPokemon(){
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
		
		for (int i = 1; i <= 718; i++){
			list.add(new Pokemon(i));
			//list.get(i-1).printInfo();
		}
		
		return list;
	}

	
}
