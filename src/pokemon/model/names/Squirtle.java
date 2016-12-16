package pokemon.model.names;

import java.awt.Color;

import pokemon.model.Pokemon;
import pokemon.model.types.*;

public class Squirtle extends Pokemon implements Water
{

	public Squirtle()
	{
		super("Squirtle", 15, 96, 25, 40);
		super.setBackgroundColor(new Color(91,145,255));
	}

	@Override
	public void blastAttack() {
		
	}

	@Override
	public void hydrocannonAttack() {
		
	}
	
}