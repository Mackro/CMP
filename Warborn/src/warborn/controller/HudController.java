package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import warborn.model.Warborn;
import warborn.view.Hud;

public class HudController implements ActionListener {
	private Warborn model;
	private Hud view;
	
	public HudController(Warborn model, Hud view){
		this.model = model;
		this.view = view;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
