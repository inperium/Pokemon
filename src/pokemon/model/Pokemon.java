package pokemon.model;

public class Pokemon
{
	
	private String name;
	private int pokedexID;
	private int healthPoints;
	private int attackPoints;
	private int speed;
	
	public Pokemon(String name, int pokedexID) 
	{
		this.name = name;
		this.pokedexID = pokedexID;
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
}
