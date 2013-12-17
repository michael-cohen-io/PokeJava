/**
 * @author Michael Cohen
 *
 */
import java.io.IOException;
import java.util.Map;


public class Pokemon extends ModelClass {

	/* (non-Javadoc)
	 * @see ModelClass#parse(java.lang.String)
	 */
	private String Name, Created, EVYield, GrowthRate, Height, Modified, URI, Species, Weight;
	private int Attack, CatchRate, Defense, EggCycles, Exp, Happiness, HP, ID, SpAttack, SpDefense, Speed, Total;
	
	@SuppressWarnings("rawtypes")
	public Pokemon(int ID){
		String data = "";
		try {
			data = get("pokemon/"+ID);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Map root = parse(data);
		
		//Define properties
		Name = (String) root.get("name");
		Created = (String) root.get("created");
		EVYield = (String) root.get("ev_yeild");
		GrowthRate = (String) root.get("growth_rate");
		Height = (String) root.get("height");
		Modified = (String) root.get("modified");
		URI = (String) root.get("resource_uri");
		Species = (String) root.get("species");
		Weight = (String) root.get("weight");
		
		Attack = (int) root.get("attack");
		CatchRate = (int) root.get("catch_rate");
		Defense = (int) root.get("defense");
		EggCycles = (int) root.get("egg_cycles");
		Exp = (int) root.get("exp");
		Happiness = (int) root.get("happiness");
		HP = (int) root.get("hp");
		this.ID = (int) root.get("national_id");
		SpAttack = (int) root.get("sp_atk");
		SpDefense = (int) root.get("sp_def");
		Speed = (int) root.get("speed");
		Total = (int) root.get("total");
		
	}
	


}
