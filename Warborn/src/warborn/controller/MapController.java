package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.map.IMap;
import warborn.model.Warborn;

public class MapController implements ActionListener {
	
	private Warborn model;
	//private IMap map;
	
	public MapController(Warborn model, IMap map){
		this.model = model;
		//this.map = map;
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