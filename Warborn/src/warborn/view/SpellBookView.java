package warborn.view;

import java.awt.GridLayout;

import javax.swing.*;

import warborn.model.Spellbook;
import warborn.model.spells.Spell;

public class SpellbookView extends JPanel {
	
	Spellbook spellbook;

	/**
	 * Create the panel.
	 */
	public SpellbookView(Spellbook spellbook) {
		this.spellbook = spellbook;
		
		setSize(800, 576);
		setLocation(283, 0);
		
		JPanel page2 = new JPanel();
		page2.setBounds(400, 0, 400, 576);
		add(page2);
		page2.setLayout(new GridLayout(3, 2));
		
		JPanel page1 = new JPanel();
		page1.setBounds(0, 0, 400, 576);
		add(page1);
		page1.setLayout(new GridLayout(2, 3));
		
		JLabel spellbooklbl = new JLabel();
		spellbooklbl.setIcon(new ImageIcon("C:\\Users\\WarBorn\\Desktop\\WBWS\\CMP\\Warborn\\WarbornData\\images\\SpellBook.jpg"));
		spellbooklbl.setBounds(0, 0, 890, 595);
		add(spellbooklbl);
		
		setLayout(null);
		page1.setOpaque(false);
		page2.setOpaque(false);
		
		for (int i = 0; i < 13; i++){
			if(i < 7){
				page1.add(new SpellView(spellbook.getSpell(i)));
			}
			else{
				page2.add(new SpellView(spellbook.getSpell(i)));
			}
		}
		
	}
}
