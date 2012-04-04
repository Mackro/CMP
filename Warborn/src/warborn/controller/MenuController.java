package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.model.Warborn;
import warborn.view.MenuView;

public class MenuController implements ActionListener{
	
	private Warborn model;
	private MenuView view;
	
	public MenuController(Warborn model, MenuView view){
		this.model = model;
		this.view = view;
		JButton[] buttonArray = view.getButtonArray();
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		JButton buttonPressed = (JButton)(evt.getSource());
		//NewGame
		if(buttonPressed == this.view.getButtonArray()[0]){
			view.openNewGameMenu();
		}
	}
}
