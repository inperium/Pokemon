package pokemon.model.names;

import java.awt.Color;

import pokemon.model.Pokemon;
import pokemon.model.types.*;

public class Jolteon extends Pokemon implements Electricity
{

	public Jolteon()
	{
		super("Jolteon", 23, 50, 30, 45);
		super.setBackgroundColor(new Color(255,185,47));
	}

	@Override
	public void staticMove() {
		
	}

	@Override
	public void shockMove() {
		
	}
	
}
