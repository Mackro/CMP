package warborn.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

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
		JButton[] buttonArray2 = view.getColorButtons();
		for(int i = 0; i < buttonArray2.length; i++){
			buttonArray2[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		JButton buttonPressed = (JButton)(evt.getSource());
		
		if(buttonPressed == this.view.getButtonArray()[0]){
			//NewGame
			view.openNewGameMenu();
		}else if(buttonPressed == this.view.getButtonArray()[1]){
			//Credits
		}else if(buttonPressed == this.view.getButtonArray()[2]){
			//Exit
			System.exit(0);
		}else if(buttonPressed == this.view.getButtonArray()[3]){
			//Q-Start
			model.startGame();
		}else if(buttonPressed == this.view.getButtonArray()[4]){
			//Start
			view.openSelectionMenu();
		}else if(buttonPressed == this.view.getButtonArray()[5]){
			//Back
			view.closeNewGameMenu();
		}else if(buttonPressed == this.view.getButtonArray()[6]){
			//Back2
			view.openNewGameMenu();
		}else if(buttonPressed == this.view.getButtonArray()[7]){
			//StartGame
			String[] names = view.getNames();
			Color[] colors = view.getColors();
			model.setPlayers(names, colors);
			model.setSelectedMap(view.getSelectedMapIndex());
			model.startGame();
		}else{
			for(JButton colorButton : this.view.getColorButtons()){
				if(buttonPressed == colorButton){
					colorButton.setBackground(JColorChooser.showDialog(view, "Choose your color", colorButton.getBackground()));
				}
			}
		}
	}
}
