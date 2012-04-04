package warborn.view;

import java.awt.Color;

import javax.swing.*;

import warborn.model.Warborn;

public class PlayerSelectionPanel extends JPanel {

	public JTextField tfPlayerName;
	public JButton btColor;
	public JComboBox cbRace, cbClass;
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
			color = Color.BLUE;
			break;
		}
		
		btColor = new JButton();
		btColor.setLocation(20, 20);
		btColor.setSize(50, 50);
		btColor.setBackground(color);
		btColor.setEnabled(false);
		add(btColor);
		
		tfPlayerName = new JTextField("Player " + number);
		tfPlayerName.setLocation(20, 80);
		tfPlayerName.setSize(100, 30);
		add(tfPlayerName);
		
		JLabel lbRace = new JLabel("Race:");
		lbRace.setLocation(150, 20);
		lbRace.setSize(100, 30);
		add(lbRace);
		
		JLabel lbClass = new JLabel("Class:");
		lbClass.setLocation(150, 60);
		lbClass.setSize(100, 30);
		add(lbClass);

		cbRace = new JComboBox();
		cbRace.setLocation(200, 20);
		cbRace.setSize(100, 30);
		cbRace.setBackground(Color.WHITE);
		cbRace.setModel(getRaces());
		add(cbRace);
		
		cbClass = new JComboBox();
		cbClass.setLocation(200, 60);
		cbClass.setSize(100, 30);
		cbClass.setBackground(Color.WHITE);
		cbClass.setModel(getClasses());
		add(cbClass);
		
	}

	private ComboBoxModel getClasses() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		boxModel.addElement("None");
		return boxModel;
	}

	private ComboBoxModel getRaces() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		boxModel.addElement("Human");
		return boxModel;
	}
	
	public String getPlayerName(){
		return tfPlayerName.getText();
	}
	
	public Color getPlayerColor(){
		return btColor.getBackground();
	}

}
