package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import warborn.model.Battle;
import warborn.model.Warborn;
import warborn.view.BattleView;

public class BattleController implements Observer{
	private Warborn model;
	
	
	public BattleController(Warborn model){
		this.model = model;
	}

	@Override
	public void update(Observable battleView, Object e) {
		if(((ActionEvent)e).getSource() == ((BattleView)battleView).btOneAttack){
			model.getBattle().fight();
		}
		if(((ActionEvent)e).getSource() == ((BattleView)battleView).btAutoAttack){
			while(model.getBattle().getFirstTerritory().getNbrOfUnits() != 0 && (model.getBattle().getSecondTerritory().getNbrOfUnits()) != 0){
				model.getBattle().fight();
			}
		}
		if(((ActionEvent)e).getSource() == ((BattleView)battleView).btRetreat){
			((BattleView)battleView).battleFrame.setVisible(false);
		}
	}
}