package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import warborn.model.Warborn;
import warborn.view.HudView;

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
			model.nextState();
		}
		if((e).getSource() == view.getButtons()[1]){
			model.exchangeSouls();
		}
	}

}
