package pokemon.model;

public class Pokemon
{
	
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
		return 0;
	}
	
	public int getAttackPoints()
	{
		return 0;
	}

	public String getname() {
		
		return null;
	}

	public void setAttackPoints(int combat) {
		
	}

	public void setSpeed(double speed) {
		
		
	}

	public void setHealthPoints(String name) {
		
		
	}

	public void setName(String name) {
		
		
	}
}
