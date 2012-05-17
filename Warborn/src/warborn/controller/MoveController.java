package warborn.controller;

import java.awt.event.*;

import javax.swing.event.*;

import warborn.model.Warborn;
import warborn.view.MoveView;

public class MoveController implements ActionListener, ChangeListener {
	private Warborn model;
	private MoveView view;
	private final static int CANCELMOVE = 0, MOVE = 1, SLIDERMINUS = 2, SLIDERPLUS = 3;
	
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
		if((e).getSource() == view.getButtons()[CANCELMOVE]){
			view.setVisible(false);
			model.getMove().resetTerritories();
			model.nextPhase();
		}else if((e).getSource() == view.getButtons()[MOVE]){
			view.setVisible(false);
			model.getMove().moveUnits(view.getSlider().getValue());
			if(model.getBattle().shallMove()){
				model.getBattle().shallNotMove();
			}
			
		}else if((e).getSource() == view.getButtons()[SLIDERMINUS] && view.getSlider().getValue() > 1){
			view.getSlider().setValue(view.getSlider().getValue() - 1);
		}else if((e).getSource() == view.getButtons()[SLIDERPLUS] && view.getSlider().getValue() < view.getSlider().getMaximum()){
			view.getSlider().setValue(view.getSlider().getValue() + 1);
		}
	}
	
	public void stateChanged(ChangeEvent e) {
		view.getLbT1Troops().setText(model.getMove().getFirstTerritory().getNbrOfUnits() + model.getMove().getSecondTerritory().getNbrOfUnits() - view.getSlider().getValue() + "");
		view.getLbT2Troops().setText(view.getSlider().getValue() + "");
	}
}

