package pokemon.controller;

import java.util.ArrayList;

import pokemon.model.Pokemon;
import pokemon.view.PokemonFrame;

public class PokemonController
{
	private ArrayList<Pokemon> pokedex;
	private PokemonFrame baseFrame;
	

	public PokemonController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		baseFrame = new PokemonFrame(this);
	}
	
	
	public void start()
	{
		
	}
	
	
	private void buildPokedex()
	{
		
	}
	
	
	public String[] buildPokedexText()
	{
		String [] pokemonNames = new String[pokedex.size()];
		
		for(int index = 0; index < pokedex.size(); index++)
		{
			pokemonNames[index] = pokedex.get(index).getname();
		}
		return pokemonNames;
	}

	
	public void updateSelected(int index, String name, int combat, int health, double speed)
	{
	Pokemon current = pokedex.get(index);
	current.setName(name);
	current.setAttackPoints(combat);
	current.setSpeed(speed);
	current.setHealthPoints(name);
	}
	
	public ArrayList<Pokemon> getPokedex()
		{
	
		}
}
