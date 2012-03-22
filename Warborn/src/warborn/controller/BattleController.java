package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import warborn.model.Battle;
import warborn.model.Model;
import warborn.view.BattleView;

public class BattleController implements Observer, ActionListener {
	private Model model;
	
	public BattleController(Model model){
		this.model = model;
	}

	@Override
	public void update(Observable observable, Object buttonPressed) {
		if((Integer)buttonPressed == 1){
			model.getBattle().fight();
			
		}
		if((Integer)buttonPressed == 2){
			while(model.getBattle().getFirstTerritory().getNbrOfUnits() != 0 && (model.getBattle().getSecondTerritory().getNbrOfUnits()) != 0){
				model.getBattle().fight();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btOneAttack){
			buttonPressed = 1;
		}
		if(e.getSource() == btAutoAttack){
			buttonPressed = 2;
		}
		if(e.getSource() == btRetreat){
			battleFrame.setVisible(false);
		}
	}
}
