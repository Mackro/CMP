package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import warborn.map.IMap;
import warborn.model.Warborn;

public class MapController implements ActionListener, KeyListener {
	
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

	@Override
	public void keyPressed(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		System.out.println("Char: "+evt.getKeyChar() + "  ,Code: " + evt.getKeyCode() + "  ,Location: " + evt.getKeyLocation());
		/*
		if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.out.println("Det funkar");
		} else {
			System.out.println("funkar inte");
		}*/
	}
}
