package pokemon.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import pokemon.model.Pokemon;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import pokemon.controller.PokemonController;

public class PokemonPanel extends JPanel
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

	public PokemonPanel(PokemonController baseController)
	{
		super();
		this.baseController = baseController;
		this.Layout= new SpringLayout();
		this.pokemonIcon = new ImageIcon(new ImageIcon(getClass().getResource("/pokemon/view/images/pokeball.png")).getImage().getScaledInstance(40, 40, 0));
		this.updateButton = new JButton("Update stats!");
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
		this.setBackground(new Color(255,49,47));
		
		numberField.setEditable(false);
		advancedArea.setEditable(false);
		advancedArea.setWrapStyleWord(true);
		advancedArea.setLineWrap(true);
		
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
		pokemonLabel.setVerticalTextPosition(JLabel.BOTTOM);
		pokemonLabel.setHorizontalTextPosition(JLabel.CENTER);
		Layout.putConstraint(SpringLayout.NORTH, pokemonLabel, 0, SpringLayout.NORTH, advancedLabel);
		Layout.putConstraint(SpringLayout.WEST, pokemonLabel, 187, SpringLayout.WEST, this);
		Layout.putConstraint(SpringLayout.NORTH, updateButton, -5, SpringLayout.NORTH, healthLabel);
		Layout.putConstraint(SpringLayout.EAST, updateButton, -95, SpringLayout.WEST, healthLabel);
		Layout.putConstraint(SpringLayout.NORTH, healthField, 21, SpringLayout.SOUTH, combatField);
		Layout.putConstraint(SpringLayout.EAST, healthField, 0, SpringLayout.EAST, combatField);
		Layout.putConstraint(SpringLayout.SOUTH, speedField, -498, SpringLayout.SOUTH, this);
		Layout.putConstraint(SpringLayout.NORTH, combatField, 15, SpringLayout.SOUTH, speedField);
		Layout.putConstraint(SpringLayout.WEST, speedField, 0, SpringLayout.WEST, healthField);
		Layout.putConstraint(SpringLayout.NORTH, numberField, 28, SpringLayout.NORTH, this);
		Layout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, healthField);
		Layout.putConstraint(SpringLayout.EAST, advancedArea, -121, SpringLayout.EAST, this);
		Layout.putConstraint(SpringLayout.NORTH, updateButton, -1, SpringLayout.NORTH, pokedexSelector);
		Layout.putConstraint(SpringLayout.WEST, updateButton, 20, SpringLayout.EAST, pokedexSelector);
		Layout.putConstraint(SpringLayout.EAST, pokedexSelector, 301, SpringLayout.WEST, this);
		Layout.putConstraint(SpringLayout.WEST, pokedexSelector, 38, SpringLayout.WEST, this);
		Layout.putConstraint(SpringLayout.SOUTH, advancedLabel, -291, SpringLayout.SOUTH, this);
		Layout.putConstraint(SpringLayout.NORTH, advancedArea, 13, SpringLayout.SOUTH, advancedLabel);
		Layout.putConstraint(SpringLayout.EAST, advancedLabel, -282, SpringLayout.EAST, this);
		Layout.putConstraint(SpringLayout.NORTH, advancedLabel, 108, SpringLayout.SOUTH, combatLabel);
		Layout.putConstraint(SpringLayout.NORTH, combatLabel, 5, SpringLayout.NORTH, healthField);
		Layout.putConstraint(SpringLayout.WEST, combatLabel, 0, SpringLayout.WEST, advancedArea);
		Layout.putConstraint(SpringLayout.NORTH, pokedexSelector, -4, SpringLayout.NORTH, healthLabel);
		Layout.putConstraint(SpringLayout.NORTH, healthLabel, 5, SpringLayout.NORTH, numberField);
		Layout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, combatLabel);
		Layout.putConstraint(SpringLayout.WEST, combatField, 93, SpringLayout.EAST, speedLabel);
		Layout.putConstraint(SpringLayout.NORTH, speedLabel, 5, SpringLayout.NORTH, combatField);
		Layout.putConstraint(SpringLayout.WEST, speedLabel, 0, SpringLayout.WEST, combatLabel);
		Layout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, combatLabel);
		Layout.putConstraint(SpringLayout.SOUTH, numberLabel, -27, SpringLayout.NORTH, speedLabel);
		Layout.putConstraint(SpringLayout.EAST, pokemonLabel, 0, SpringLayout.EAST, pokedexSelector);
	}
	
	private void setupListeners()
	{
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValidInteger(healthField.getText())){
					int selected = pokedexSelector.getSelectedIndex();
					Pokemon pokemon = baseController.getPokedex().get(selected);
					baseController.updateSelected(selected, pokemon.getName(), pokemon.getAttackPoints(), pokemon.getSpeed(), pokemon.getHealthPoints());
					pokedexSelector.repaint();
					pokedexSelector.setModel(new DefaultComboBoxModel<>(baseController.buildPokedexText()));
					pokedexSelector.setSelectedIndex(selected);
				}
			}

			private boolean isValidInteger(String input){
				boolean valid = false;
				try{
					Integer.parseInt(input);
					valid = true;
				}catch(NumberFormatException e){
					valid = false;
				}
				return valid;
			}
		});

		pokedexSelector.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Pokemon pokemon = baseController.getPokedex().get(pokedexSelector.getSelectedIndex());
				numberField.setText(String.valueOf(pokemon.getPokedexID()));
				nameField.setText(pokemon.getName());
				healthField.setText(String.valueOf(pokemon.getHealthPoints()));
				combatField.setText(String.valueOf(pokemon.getAttackPoints()));
				
				setBackground(pokemon.getBackgroundColor());
				changeImageDisplay(pokemon.getName());
			}

			public void changeImageDisplay(String pokemonName){
				String path = "/pokemon/view/images/";
				String defaultName = "charizard";
				String extension = ".png";
				try{
					pokemonIcon = new ImageIcon(this.getClass().getResource(path + pokemonName.toLowerCase() + extension));
				}catch(NullPointerException missingFile){
					pokemonIcon = new ImageIcon(this.getClass().getResource(path + defaultName + extension));
				}
				pokemonLabel.setIcon(pokemonIcon);
				pokemonLabel.setText("My name is: " + pokemonName);
				repaint();
			}
		});
	}
}
