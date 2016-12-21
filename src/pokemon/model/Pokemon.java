package pokemon.model;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Pokemon
{
	
	private String name;
	private static int pokedexID;
	private int healthPoints;
	private int attackPoints;
	private int speed;
	private Color backgroundColor;
	
	public Pokemon(String name, int pokedexID, int speed, int attackPoints, int healthPoints) 
	{
		this.healthPoints = healthPoints;
		this.name = name;
		this.pokedexID = pokedexID;
		this.speed = speed;
		this.setSpeed(speed);
		this.attackPoints = attackPoints;
	}
	
	public String getAttackString() {
		String attackString = "";
		for(Class<?> interfacez : getClass().getInterfaces()){
			for(Method method : interfacez.getMethods()){
				attackString += "The method "+ method.getName() + " does ";
				try{
					Method attackMethod = getClass().getMethod(method.getName());
					int attackNum = (int) attackMethod.invoke(this);
					attackString += attackNum + " attack damage.\n";
				}catch(IllegalArgumentException | NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return attackString;
	}

	public String getPokemonTypes()
	{
		String pokemonTypes = "This Pokemon is of type(s):\n";
		Class<?> [] types = getClass().getInterfaces();
		String [] pokeTypes = new String[types.length];
		for(int index = 0; index < types.length; index++)
		{
			String temp = types[index].getName();
			
			pokeTypes[index] = temp;
		}
		
		for(String current : pokeTypes)
		{
			String temp = current.replace(this.getClass().getPackage().getName() + ".", "");
			pokemonTypes += temp = "\n";
		}
		
		return pokemonTypes;
	}

	public String toString()
	{
		return null;
	}
	
	public String getPokemonInformation()
	{
		String pokemonInfo = "This Pokemon is of type: " + this.getClass().getSimpleName();
		
		return pokemonInfo;
	}
	
	public int getHealthPoints()
	{
		return healthPoints;
	}
	
	public int getAttackPoints()
	{
		return attackPoints;
	}

	public String getName() {
		
		return name;
	}

	public void setAttackPoints(int attackPoints) {
		this.attackPoints = attackPoints;
	}

	public void setSpeed(double speed) {
		this.speed = (int) speed;

	}

	public void setHealthPoints(double healthPoints) {
		this.healthPoints = (int) healthPoints;

	}

	public void setName(String name) {
		this.name = name;
		
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getPokedexID() {
		return pokedexID;
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
