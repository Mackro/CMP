package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import warborn.model.Warborn;
import warborn.model.spells.SpellInvoker;
import warborn.view.HudView;
import warborn.view.SpellbookView;

public class HudController implements ActionListener {
	private Warborn model;
	private HudView view;
	private JFrame window;
	private final static int NEXTSTATE = 0, ABSORBSOULS = 1, SPELLBOOK = 2;
	
	public HudController(Warborn model, JFrame window, HudView view){
		this.model = model;
		this.window = window;
		this.view = view;
		for(int i=0; i<view.getButtons().length; i++){
			view.getButtons()[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if((e).getSource() == view.getButtons()[NEXTSTATE]){
			model.nextState();
		}
		if((e).getSource() == view.getButtons()[ABSORBSOULS]){
			model.exchangeSouls();
		}
		if((e).getSource() == view.getButtons()[SPELLBOOK]){
			SpellbookView spellbookView = new SpellbookView(model.getCurrentPlayer().getSpellbook(), window);
			SpellInvoker spellInvoker = new SpellInvoker(model);
			new SpellbookController(spellInvoker, spellbookView);
			window.repaint();
		}
	}
}
