package tester;

import java.util.ArrayList;
import java.util.Date;

import com.pokejava.Pokedex;
import com.pokejava.Pokemon;


/**
 * @author Michael Cohen
 *
 */
@SuppressWarnings("unused")
public class TestPokedex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Pokedex p = new Pokedex();
		Date d = p.getModified();
		System.out.println(d.toString());
	}
	
		// ** QUICK TESTS **
	
		//Single Type tests
		
		private static long getPokedexTime(){
			long sTime = System.nanoTime();
			Pokedex p = new Pokedex();
			long eTime = System.nanoTime();
			
			return eTime - sTime;
		}
		
		private static boolean isPokedexName(){
			Pokedex p = new Pokedex();
			String n = p.getName();
			return true;
		}
		
		private static boolean isPokedexPokemon(){
			Pokedex p = new Pokedex();
			if (p.hasPokemon()){ ArrayList<Pokemon> a = p.getPokemons(); }
			return true;
		}
		
		private static boolean pokedexCheck() {
			if (isPokedexName() && isPokedexPokemon()) return true;
			else return false;
		}
}
