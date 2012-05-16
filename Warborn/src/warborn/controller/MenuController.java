package warborn.controller;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Container.*;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import warborn.model.Warborn;
import warborn.view.MenuView;

public class MenuController implements ActionListener, ItemListener{
	
	private Warborn model;
	private JFrame frame;
	private MenuView view;
	
	public MenuController(Warborn model, JFrame frame, MenuView view){
		this.model = model;
		this.frame = frame;
		this.view = view;
		JButton[] buttonArray = view.getButtonArray();
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i].addActionListener(this);
		}
		JButton[] buttonArray2 = view.getColorButtons();
		for(int i = 0; i < buttonArray2.length; i++){
			buttonArray2[i].addActionListener(this);
		}
		for (int i=0; i<view.getComboBoxes().length; i++){
			view.getComboBoxes()[i].addItemListener(this);
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
			view.showCredits();
		}else if(buttonPressed == this.view.getButtonArray()[2]){
			//Exit
			System.exit(0);
		}else if(buttonPressed == this.view.getButtonArray()[3]){
			//Q-Start
			model.quickStart();
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
			//AddPlayer
			view.addPlayer();
		}else if(buttonPressed == this.view.getButtonArray()[8]){
			//RemovePlayer
			view.removePlayer();
		}else if(buttonPressed == this.view.getButtonArray()[9]){
			//StartGame
			String[] names = view.getNames();
			Color[] colors = view.getColors();
			int[] races = view.getRaces();
			int[] backgrounds = view.getBackgrounds();
			model.setPlayers(names, colors, races, backgrounds);
			model.setSelectedMap(view.getSelectedMapIndex());
			model.startGame();
		}else{
			//Color choosing
			for(JButton colorButton : this.view.getColorButtons()){
				if(buttonPressed == colorButton){
					//Dialog chooser = JColorChooser.createDialog(view, "Choose your color", true, new JColorChooser(), null, null);
					//JColorChooser.createDialog(c, title, modal, , okListener, cancelListener)
					JColorChooser chooser = new JColorChooser(colorButton.getBackground());
					chooser.setLocation(model.getWidth()/2, model.getHeight()/2);
					frame.getLayeredPane().add(chooser, JLayeredPane.MODAL_LAYER);
					//colorButton.setBackground(JColorChooser.showDialog(frame, "Choose your color", colorButton.getBackground()));
				}
			}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent iEvt) {
		String[] paramElements = iEvt.paramString().split("=");
		if(paramElements.length==3 && paramElements[2].equalsIgnoreCase("SELECTED")){
			String element = paramElements[1].split(",")[0];
			if(element.equalsIgnoreCase("Human")||element.equalsIgnoreCase("Titan")||
					element.equalsIgnoreCase("Forgotten")||element.equalsIgnoreCase("Random Race")){
				view.updateRaceDescription(element);
			}else if(element.equalsIgnoreCase("Civitatis")||element.equalsIgnoreCase("Falcitier")||
					element.equalsIgnoreCase("Insanus")||element.equalsIgnoreCase("Random God")){
				view.updateGodDescription(element);
			}else{
				view.updateMap();
			}
		}
	}
}
