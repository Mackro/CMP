package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import warborn.model.Warborn;
import warborn.view.HudView;
import warborn.view.PhasePanel;
import warborn.view.SpellbookView;

public class HudController implements ActionListener {
	private Warborn model;
	private HudView view;
	
	public HudController(Warborn model, HudView view){
		this.model = model;
		this.view = view;
		for(int i=0; i<view.getButtons().length; i++){
			view.getButtons()[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e).getSource() == view.getButtons()[0]){
			switch(model.getState()){
			case 0:
				new PhasePanel(model, "Place Your Troops");
				break;
			case 1:
				new PhasePanel(model, "Reinforce Your Troops");
				break;
			case 2:
				new PhasePanel(model, "Battle Phase");
				break;
			case 3:
				new PhasePanel(model, "Troop Movement");
				break;
			}
			model.nextState();
		}
		if((e).getSource() == view.getButtons()[1]){
			model.exchangeSouls();
		}
		if((e).getSource() == view.getButtons()[2]){
			SpellbookView spellbookView = new SpellbookView(model.getCurrentPlayer().getSpellbook());
			//add contråller
			spellbookView.getFrame().setVisible(true);
		}
	}
}
