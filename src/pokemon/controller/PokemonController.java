package pokemon.controller;

import java.util.ArrayList;
import pokemon.model.*;
import pokemon.model.names.*;
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
		pokedex.add(new Charizard("Charizard"));
		pokedex.add(new Jolteon());
		pokedex.add(new Pikachu());
		pokedex.add(new Squirtle());
		pokedex.add(new Zapados());
		pokedex.add(new Charizard("Fire Dragon"));
	}
	
	public String[] buildPokedexText()
	{
		String [] pokemonNames = new String[pokedex.size()];
		
		for(int index = 0; index < pokedex.size(); index++)
		{
			pokemonNames[index] = pokedex.get(index).getName();
		}
		return pokemonNames;
	}

	public void updateSelected(int index, String name, int attackPoints, double speed, double healthPoints)
	{
	Pokemon current = pokedex.get(index);
	current.setName(name);
	current.setAttackPoints(attackPoints);
	current.setSpeed(speed);
	current.setHealthPoints(healthPoints);
	}
	
	public ArrayList<Pokemon> getPokedex()
		{
			return pokedex;
		}
	
	public PokemonFrame getBaseFrame() {
		return baseFrame;
	}	
}
