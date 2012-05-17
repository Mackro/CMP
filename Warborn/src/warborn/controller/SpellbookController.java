package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLayeredPane;

import warborn.model.spells.SpellInvoker;
import warborn.view.SpellbookView;

public class SpellbookController implements ActionListener{
	private SpellInvoker invoker;
	private SpellbookView view;
	
	public SpellbookController(SpellInvoker invoker, SpellbookView view){
		this.invoker = invoker;
		this.view = view;
		for (int i=0; i<view.getSpellViews().length ;i++){
			view.getSpellViews()[i].getButton().addActionListener(this);
		}
		view.getCloseButton().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		for (int i=0; i<view.getSpellbook().getNumberOfSpells(); i++){
			if (evt.getActionCommand().equalsIgnoreCase(view.getSpellbook().getSpell(i).getName())){
				invoker.setSelectedSpell(view.getSpellbook().getSpell(i));
			}
		}
		
		JLayeredPane parent = (JLayeredPane) view.getParent();
		parent.remove(view);
		parent.repaint();
	}
}
