package tester;

import java.util.ArrayList;
import java.util.Date;

import com.pokejava.Type;

@SuppressWarnings("unused")
public class TestType {
	
	public static void main(String[] args) {

		Type t = new Type(7);
		Date d = t.getCreated();
		System.out.println(d.toString());

	}

	
	// ** LONG TESTS
	
	//All Type Tests
	private static long getAllTypeTime(){
		long sTime = System.nanoTime();
		for (int i = 1; i <= 18; i++) {
			Type t = new Type(i);
		}
		long eTime = System.nanoTime();
		
		return eTime-sTime;
	}

	private static boolean isAllTypeName(){
		for(int i=1; i <= 18; i++){
			Type t = new Type(i);
			String n = t.getName();
		}
		return true;
	}
	
	private static boolean isAllTypeIneffective(){
		for(int i=1; i <= 18; i++){
			Type t = new Type(i);
			if(t.hasIneffective()){ ArrayList<Type> a = t.getIneffective();}
		}
		return true;
	}
	
	private static boolean isAllTypeNoEffect(){
		for(int i=1; i <= 18; i++){
			Type t = new Type(i);
			if(t.hasNoEffect()){ ArrayList<Type> a = t.getNoEffect();}
		}
		return true;
	}
	
	private static boolean isAllTypeResistance(){
		for(int i=1; i <= 18; i++){
			Type t = new Type(i);
			if(t.hasResistance()){ ArrayList<Type> a = t.getResistance();}
		}
		return true;
	}
	
	private static boolean isAllTypeSuperEffective(){
		for(int i=1; i <= 18; i++){
			Type t = new Type(i);
			if(t.hasSuperEffective()){ ArrayList<Type> a = t.getSuperEffective();}
		}
		return true;
	}
	
	private static boolean isAllTypeWeakness(){
		for(int i=1; i <= 18; i++){
			Type t = new Type(i);
			if(t.hasWeakness()){ ArrayList<Type> a = t.getWeakness();}
		}
		return true;
	}

		//CHECK ALL
	private static boolean allTypeCheck(){
		if (isAllTypeName() && isAllTypeIneffective() && isAllTypeNoEffect() && isAllTypeResistance() && isAllTypeSuperEffective() && isAllTypeWeakness()) {
			return true;
		} else {
			return false;
		}
	}
	
	// ** QUICK TESTS **
	
	//Single Type tests
	
	private static long getTypeTime(int ID){
		long sTime = System.nanoTime();
		Type t = new Type(ID);
		long eTime = System.nanoTime();
		
		return eTime - sTime;
	}
	
	private static boolean isTypeName(int ID){
		Type t = new Type(ID);
		String n = t.getName();
		return true;
	}
	
	private static boolean isTypeIneffective(int ID){
		Type t = new Type(ID);
		if (t.hasIneffective()){ ArrayList<Type> a = t.getIneffective(); }
		return true;
	}
	
	private static boolean isTypeNoEffect(int ID){
		Type t = new Type(ID);
		if (t.hasNoEffect()){ ArrayList<Type> a = t.getNoEffect(); }
		return true;
	}
	
	private static boolean isTypeResistance(int ID){
		Type t = new Type(ID);
		if (t.hasResistance()){ ArrayList<Type> a = t.getResistance(); }
		return true;
	}
	
	private static boolean isTypeSuperEffective(int ID){
		Type t = new Type(ID);
		if (t.hasSuperEffective()){ ArrayList<Type> a = t.getSuperEffective(); }
		return true;
	}
	
	private static boolean isTypeWeakness(int ID){
		Type t = new Type(ID);
		if (t.hasWeakness()){ ArrayList<Type> a = t.getWeakness(); }
		return true;
	}
	
		//CHECK ALL
	private static boolean typeCheck(int ID) {
		if (isTypeName(ID) && isTypeIneffective(ID) && isTypeNoEffect(ID) && isTypeResistance(ID) && isTypeSuperEffective(ID) && isTypeWeakness(ID)) {
			return true;
		}
		else {
			return false;
		}
	}
		
		//Test Basic properties
	private static boolean isTypeBasics(int ID){
		Type t = new Type(ID);
		
		String s = t.getURI();
		
		int i = t.getID();
		
		Date d = t.getCreated();
		d = t.getModified();
		
		return true;
	}
	
}
