package pokemon.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import pokemon.controller.PokemonController;

public class pokemonPanel extends JPanel
{
	private JButton updateButton;
	private PokemonController baseController;
	private SpringLayout Layout;
	private ImageIcon pokemonIcon;
	private JTextField nameField;
	private JTextField combatField;
	private JTextField healthField;
	private JTextField speedField;
	private JTextField numberField;
	private JLabel advancedLabel;
	private JTextArea advancedArea;
	private JComboBox pokedexSelector;
	private JLabel combatLabel;
	private JLabel healthLabel;
	private JLabel speedLabel;
	private JLabel numberLabel;
	private JLabel nameLabel;
	private JLabel pokemonLabel;
	
	public void PokemonPanel(PokemonController baseController)
	{
		this.baseController = baseController;
		this.Layout= new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball.jpg"));
		this.updateButton = new JButton("Udate stats!");
		this.nameField = new JTextField(25);
		this.combatField = new JTextField(5);
		this.healthField = new JTextField(5);
		this.speedField = new JTextField(5);
		this.numberField = new JTextField(5);
		this.advancedArea = new JTextArea(10, 25);
		this.pokedexSelector = new JComboBox(baseController.buildPokedexText());
		this.advancedLabel = new JLabel("Advanced information");
		this.combatLabel = new JLabel("Combat Points: ");
		this.healthLabel = new JLabel("Health Points: ");
		this.speedLabel = new JLabel("The Pokemon's speed is ");
		this.numberLabel = new JLabel("The Pokemon's number is ");
		this.nameLabel = new JLabel("The Pokemon's name is ");
		this.pokemonLabel = new JLabel("The Current pokemon", pokemonIcon,JLabel.CENTER);
		

		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(Layout);
		this.setPreferredSize(new Dimension(970,600));
		this.setBackground(Color.DARK_GRAY);
		
		numberField.setEditable(false);
		advancedArea.setEditable(false);
		advancedArea.setWrapStyleWord(true);
		advancedArea.setLineWrap(true);
		
		pokemonLabel.setVerticalTextPosition(JLabel.BOTTOM);
		pokemonLabel.setHorizontalTextPosition(JLabel.CENTER);
		
		this.add(pokedexSelector);
		this.add(healthField);
		this.add(healthLabel);
		this.add(combatField);
		this.add(combatLabel);
		this.add(speedField);
		this.add(speedLabel);
		this.add(numberField);
		this.add(numberLabel);
		this.add(advancedArea);
		this.add(advancedLabel);
		this.add(pokemonLabel);
		this.add(updateButton);
	}
	
	private void setupLayout()
	{
		
	}
	
	private void setupDropdown()
	{
		
	}
	
	private void setupListeners()
	{
		/*
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
			});
		}
		*/
	}
}
