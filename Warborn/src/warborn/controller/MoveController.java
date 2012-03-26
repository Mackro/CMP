package warborn.controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import warborn.model.Warborn;
import warborn.view.MoveView;

public class MoveController implements Observer {
	private Warborn model;
	
	public MoveController(Warborn model){
		this.model = model;
	}

	@Override
	public void update(Observable moveView, Object e) {
		if(((ActionEvent)e).getSource() == ((MoveView)moveView).btMove){
			model.getMove().moveUnits(((MoveView)moveView).slider.getValue());
			((MoveView)moveView).moveFrame.setVisible(false);
		}
		if(((ActionEvent)e).getSource() == ((MoveView)moveView).btCancel){
			((MoveView)moveView).moveFrame.setVisible(false);
		}
	}

}

