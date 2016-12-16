package pokemon.model.names;

import java.awt.Color;

import pokemon.model.Pokemon;
import pokemon.model.types.*;

public class Zapados extends Pokemon implements Fire, Electricity
{

	public Zapados()
	{
		super("Zapados", 49, 61, 20, 35);
		super.setBackgroundColor(new Color(255,185,47));
	}

	@Override
	public void staticMove() {
		
	}

	@Override
	public void shockMove() {
		
	}

	@Override
	public void flameAttack() {
		
	}

	@Override
	public void burnAttack() {
		
	}
	
}
	