/**
 * 
 */
package tester;

import java.util.ArrayList;
import java.util.Date;

import com.pokejava.EggGroup;
import com.pokejava.Pokemon;

/**
 * @author Michael
 *
 */
@SuppressWarnings("unused")
public class TestEggGroup {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EggGroup e = new EggGroup(5);
		Date d = e.getCreated();
		System.out.println(d.toString());
	}
	
	// ** LONG TESTS **

	//All Egg Group Tests
	private static long getAllEggTime(){
		long sTime = System.nanoTime();
		for (int i = 1; i <= 718; i++){
			EggGroup g = new EggGroup(i);
		}
		long eTime = System.nanoTime();
		
		
		return eTime-sTime;
	}
	
	private static boolean isAllEggName(){
		for(int i=1; i <= 718; i++){
			EggGroup g = new EggGroup(i);
			String n = g.getName();
		}
		return true;
	}
	
	private static boolean isAllEggPokemon(){
		for(int i=1; i <= 718; i++){
			EggGroup g = new EggGroup(i);
			ArrayList<Pokemon> a = g.getPokemon();
		}
		return true;
	}
	
	
		//CHECK ALL
	private static boolean allEggCheck(){
		if (isAllEggName() && isAllEggPokemon()) {
			return true;
		} else {
			return false;
		}
	}
	
	// ** QUICK TESTS **
	
	//Single Egg Group Tests
	private static long getEggTime(int ID){
		long sTime = System.nanoTime();
		EggGroup g = new EggGroup(ID);
		long eTime = System.nanoTime();
		
		return eTime-sTime;
	}
	
	private static boolean isEggName(int ID){
		EggGroup p = new EggGroup(ID);
		String n = p.getName();
		return true;
	}

	private static boolean isEggPokemon(int ID){
		EggGroup g = new EggGroup(ID);
		ArrayList<Pokemon> p = g.getPokemon();
		return true;
	}
	
		//CHECK ALL
	private static boolean eggCheck(int ID){
		if(isEggName(ID) && isEggPokemon(ID)) {
			return true;
		} else {
			return false;
		}
	}
	
		//Test Basic Properties
	private static boolean isEggBasics(int ID){
		EggGroup g = new EggGroup(ID);
		String n = g.getName();
		n = g.getURI();
		
		int i = g.getID();
		
		Date d = g.getCreated();
		d = g.getModified();
		
		return true;
	}
}
