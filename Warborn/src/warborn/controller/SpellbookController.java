package warborn.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import warborn.model.spells.SpellInvoker;
import warborn.view.SpellbookView;

public class SpellbookController implements ActionListener{
	private SpellInvoker invoker;
	private SpellbookView view;
	
	public SpellbookController(SpellInvoker invoker, SpellbookView view){
		this.invoker = invoker;
		this.view = view;
		for (int i=0; i<view.getButtons().length ;i++){
			view.getButtons()[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		System.out.println(evt.getSource().toString());
	}
}
