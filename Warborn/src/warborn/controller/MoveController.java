package warborn.controller;

import java.awt.event.*;

import javax.swing.event.*;

import warborn.model.Warborn;
import warborn.view.MoveView;

public class MoveController implements ActionListener, ChangeListener {
	private Warborn model;
	private MoveView view;
	
	public MoveController(Warborn model, MoveView view){
		this.model = model;
		this.view = view;
		for(int i=0; i<view.getButtons().length; i++){
			view.getButtons()[i].addActionListener(this);
		}
		view.getSlider().addChangeListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if((e).getSource() == view.getButtons()[0]){
			model.getMove().resetTerritories();
			model.nextPhase();
			view.getFrame().setVisible(false);
		}
		if((e).getSource() == view.getButtons()[1]){
			if(model.getBattle().shallMove()){
				model.getBattle().shallNotMove();
			}
			model.getMove().moveUnits(view.getSlider().getValue());
			view.getFrame().setVisible(false);
		}
		if((e).getSource() == view.getButtons()[2] && view.getSlider().getValue() > 1){
			view.getSlider().setValue(view.getSlider().getValue() - 1);
		}
		if((e).getSource() == view.getButtons()[3] && view.getSlider().getValue() < view.getSlider().getMaximum()){
			view.getSlider().setValue(view.getSlider().getValue() + 1);
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		view.getLbT1Troops().setText(view.getSlider().getMaximum() - view.getSlider().getValue() + 1 + "");
		view.getLbT2Troops().setText(view.getSlider().getValue() + "");
	}
}

