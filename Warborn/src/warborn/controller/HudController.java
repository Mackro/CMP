package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import warborn.model.Warborn;
import warborn.view.HudView;
import warborn.view.SpellbookView;

public class HudController implements ActionListener, KeyListener {
	private Warborn model;
	private HudView view;
	
	public HudController(Warborn model, HudView view){
		this.model = model;
		this.view = view;
		for(int i=0; i<view.getButtons().length; i++){
			view.getButtons()[i].addActionListener(this);
		}
		view.addKeyListener(this);
		view.setFocusable(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e).getSource() == view.getButtons()[0]){
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

	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent evt) {
		System.out.println("Char: "+evt.getKeyChar() + "  ,Code: " + evt.getKeyCode() + "  ,Location: " + evt.getKeyLocation());
		/*
		if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
			System.out.println("Det funkar");
		} else {
			System.out.println("funkar inte");
		}*/
	}

}
