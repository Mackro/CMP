package warborn.controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.event.ChangeEvent;

import warborn.model.Warborn;
import warborn.view.MoveView;

public class MoveController implements Observer {
	private Warborn model;
	
	public MoveController(Warborn model){
		this.model = model;
	}

	@Override
	public void update(Observable mv, Object e) {
		MoveView moveView = (MoveView)mv;
		if(e instanceof ActionEvent){
			if(((ActionEvent)e).getSource() == moveView.btMove){
				model.getMove().moveUnits(moveView.slider.getValue());
				moveView.moveFrame.setVisible(false);
			}
			if(((ActionEvent)e).getSource() == moveView.btCancel){
				model.getMove().resetTerritories();
				model.nextPhase();
				moveView.moveFrame.setVisible(false);
			}
			if(((ActionEvent)e).getSource() == moveView.btDecrease && moveView.slider.getValue() > 1){
				moveView.slider.setValue(moveView.slider.getValue() - 1);
			}
			if(((ActionEvent)e).getSource() == moveView.btIncrease && moveView.slider.getValue() < moveView.slider.getMaximum()){
				moveView.slider.setValue(moveView.slider.getValue() + 1);
			}
		}
		if(e instanceof ChangeEvent){
			if(((ChangeEvent)e).getSource() == moveView.slider){
				moveView.lbT1Troops.setText(moveView.slider.getMaximum() - moveView.slider.getValue() + 1 + "");
				moveView.lbT2Troops.setText(moveView.slider.getValue() + "");
			}
		}
	}

}

