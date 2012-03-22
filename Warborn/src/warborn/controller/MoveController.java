package warborn.controller;

import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

import warborn.model.Model;
import warborn.view.MoveView;

public class MoveController implements Observer {
	private Model model;
	
	public MoveController(Model model){
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

