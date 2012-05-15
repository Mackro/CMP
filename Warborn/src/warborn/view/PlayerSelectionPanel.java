package warborn.view;

import java.awt.Color;

import javax.swing.*;

import warborn.constants.PlayerData;

public class PlayerSelectionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public JTextField tfPlayerName;
	public JButton btColor;
	@SuppressWarnings("rawtypes")
	public JComboBox cbRace, cbBackground;
	
	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PlayerSelectionPanel(int number) {
		
		
		setLayout(null);
		
		Color color = Color.BLACK;
		String name = "Player 1";
		switch(number){
		case 1:
			color = new Color(0, 0, 200);
			name = "Erez";
			break;
		case 2:
			color = Color.RED;
			name = "Metho";
			break;
		case 3:
			color = Color.GREEN;
			name = "Rirouu";
			break;
		case 4:
			color = Color.MAGENTA;
			name = "Inaria";
			break;
		}
		
		btColor = new JButton();
		btColor.setLocation(20, 20);
		btColor.setSize(50, 50);
		btColor.setBackground(color);
		add(btColor);
		
		tfPlayerName = new JTextField(name);
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

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ComboBoxModel getBackgrounds() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		for(int i = 0; i < PlayerData.getNumberOfGods(); i++){
			boxModel.addElement(PlayerData.getGodName(i));
		}
		boxModel.addElement("Random");
		return boxModel;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ComboBoxModel getRaces() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		for(int i = 0; i < PlayerData.getNumberOfRaces(); i++){
			boxModel.addElement(PlayerData.getRaceName(i));
		}
		boxModel.addElement("Random");
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
