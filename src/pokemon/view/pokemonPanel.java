package pokemon.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import pokemon.controller.PokemonController;

public class PokemonPanel
{
	private JButton updateButton;
	private PokemonController baseController;
	
	public void Pokemon(PokemonController baseController)
	{
		super();
		this.baseController = baseController;
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupDropdown()
	{
		
	}
	
	private void setupListeners()
	{
		pokedexSelector.addActionListner(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selected = pokedexSelector.getSelectedIndex();
				nameField.setText(baseController.getPokedex().get(selected).getName());
				numberField.setText(baseController.getPokedex().get(selected).getNumber() + "");
				combatField.setText(baseController.getPokedex().get(selected).getAttackPoints() + "");
				speedField.setText(baseController.getPokedex().get(selected).getSpeed() + "");
				healthField.setText(baseController.getPokedex().get(selected).getHealthPoints() + "");
				numberField.setText(baseController.getPokedex().get(selected).getNumber() + "");
				
				
			}
		});
		
		updateButton.addActionListener(new ActionListener(){
			public void actionperformed(ActionEvent selection)
			{
				if(isValidName(nameField.getText()) && isValidInteger(combatField.getText()) && isValicInteger(healthField.gettext()))
				{
					int selected = pokedexSelector.getSelectedIndex();
					baseController.getPokedex().get(selected).setName(nameField.getText());
					baseController.getPokedex().get(selected).setHealthPoints(Integer.parseInt(healthField.getText()));
					baseController.getPokedex().get(selected).setAttackPoints(Integer.parseInt(combatField.getText()));
					baseController.getPokedex().get(selected).setSpeed(Double.parseDouble(speedField.getText()));
				}
			}
		}
	}
}
