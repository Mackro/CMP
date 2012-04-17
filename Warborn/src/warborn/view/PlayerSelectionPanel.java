package warborn.view;

import java.awt.Color;

import javax.swing.*;

import warborn.SupportClasses.PlayerData;
import warborn.model.Warborn;

public class PlayerSelectionPanel extends JPanel {

	public JTextField tfPlayerName;
	public JButton btColor;
	public JComboBox cbRace, cbBackground;
	//will use when implementing race/class
	private Warborn model;
	
	/**
	 * Create the panel.
	 */
	public PlayerSelectionPanel(Warborn model, int number) {
		
		this.model = model;
		
		setLayout(null);
		
		Color color = Color.BLACK;
		switch(number){
		case 1:
			color = Color.CYAN;
			break;
		case 2:
			color = Color.YELLOW;
			break;
		case 3:
			color = Color.GREEN;
			break;
		case 4:
			color = Color.MAGENTA;
			break;
		}
		
		btColor = new JButton();
		btColor.setLocation(20, 20);
		btColor.setSize(50, 50);
		btColor.setBackground(color);
		add(btColor);
		
		tfPlayerName = new JTextField("Player " + number);
		tfPlayerName.setLocation(20, 80);
		tfPlayerName.setSize(100, 30);
		add(tfPlayerName);
		
		JLabel lbRace = new JLabel("Race:");
		lbRace.setLocation(162, 20);
		lbRace.setSize(50, 30);
		add(lbRace);
		
		JLabel lbBackground = new JLabel("Background:");
		lbBackground.setLocation(130, 61);
		lbBackground.setSize(100, 30);
		add(lbBackground);

		cbRace = new JComboBox();
		cbRace.setLocation(212, 20);
		cbRace.setSize(100, 30);
		cbRace.setBackground(Color.WHITE);
		cbRace.setModel(getRaces());
		add(cbRace);
		
		cbBackground = new JComboBox();
		cbBackground.setLocation(212, 61);
		cbBackground.setSize(100, 30);
		cbBackground.setBackground(Color.WHITE);
		cbBackground.setModel(getBackgrounds());
		add(cbBackground);
		
	}

	private ComboBoxModel getBackgrounds() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		for(int i = 0; i < PlayerData.getNumberOfBackgrounds(); i++){
			boxModel.addElement(PlayerData.getBackgroundName(i));
		}
		return boxModel;
	}

	private ComboBoxModel getRaces() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		for(int i = 0; i < PlayerData.getNumberOfRaces(); i++){
			boxModel.addElement(PlayerData.getRaceName(i));
		}
		return boxModel;
	}
	
	public String getPlayerName(){
		return tfPlayerName.getText();
	}
	
	public Color getPlayerColor(){
		return btColor.getBackground();
	}
	
	public int getPlayerRace(){
		return cbRace.getSelectedIndex();
	}
	
	public int getPlayerBackground(){
		return cbBackground.getSelectedIndex();
	}
	
	public JButton getColorButton(){
		return btColor;
	}

}
