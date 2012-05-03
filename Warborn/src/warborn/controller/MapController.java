package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.map.Map;
import warborn.model.Warborn;

public class MapController implements ActionListener {
	
	private Warborn model;
	
	public MapController(Warborn model, Map map){
		this.model = model;
		JButton buttons[] = map.getButtons();
		for (int i = 0; i < buttons.length; i++){
			buttons[i].addActionListener(this);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		model.setSelectedTerritory(Integer.parseInt(((JButton)e.getSource()).getActionCommand() + ""));
	
	}
}