package tester;

import java.util.ArrayList;

import com.pokejava.Description;
import com.pokejava.Game;
import com.pokejava.Pokemon;

public class TestDescription {

	public static void main(String[] args) {
		
		System.out.println(descriptionCheck(1));
		
	}

	// ** QUICK TESTS **
	
	//Single Description Tests
	
	private static long getDescriptionTime(int ID) {
		long sTime = System.nanoTime();
		Description d = new Description(ID);
		long eTime = System.nanoTime();
		
		return eTime-sTime;
	}
	
	private static boolean isDescriptionName(int ID){
		Description d = new Description(ID);
		String n = d.getName();
		return true;
	}
	
	private static boolean isDescriptionGame(int ID){
		Description d = new Description(ID);
		ArrayList<Game> g = d.getGames();
		return true;
	}
	
	private static boolean isDescriptionPokemon(int ID){
		Description d = new Description(ID);
		Pokemon p = d.getPokemon();
		return true;
	}
	
		//CHECK ALL
	private static boolean descriptionCheck(int ID){
		if (isDescriptionName(ID) && isDescriptionGame(ID) && isDescriptionPokemon(ID)) {
			return true;
		} else { 
			return false;
		}
	}
}
