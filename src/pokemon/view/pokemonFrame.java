package pokemon.view;

import javax.swing.JFrame;
import pokemon.controller.PokemonController;

public class PokemonFrame extends JFrame
{
	private PokemonController baseController;
	private PokemonPanel pokemonPanel;
	
	public PokemonFrame(PokemonController pokemonController) 
	{
		super();
		this.baseController = pokemonController;
		this.pokemonPanel = new PokemonPanel(baseController);
		
		this.setupFrame();
	}

	private void setupFrame() {
		this.setContentPane(pokemonPanel);
		this.setTitle("The Pokedex");
		this.setSize(1200, 800);
		this.setVisible(true);	
	}



}
