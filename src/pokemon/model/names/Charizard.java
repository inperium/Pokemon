package pokemon.model.names;

import java.awt.Color;

import pokemon.model.Pokemon;
import pokemon.model.types.Fire;

public class Charizard extends Pokemon implements Fire
{

	public Charizard(String name)
	{
		super(name, 56, 15, 60, 80);
		super.setBackgroundColor(new Color(255,49,47));
	}

	@Override
	public void flameAttack() {
		
	}

	@Override
	public void burnAttack() {
		
	}
	
}
