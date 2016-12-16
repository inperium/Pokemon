package pokemon.model.names;

import java.awt.Color;

import pokemon.model.Pokemon;
import pokemon.model.types.*;

public class Pikachu extends Pokemon implements Electricity
{

	public Pikachu()
	{
		super("Pikachu", 1, 88, 38, 50);
		super.setBackgroundColor(new Color(255,185,47));
	}

	@Override
	public void staticMove() {
		
	}

	@Override
	public void shockMove() {

		
	}
	
}
