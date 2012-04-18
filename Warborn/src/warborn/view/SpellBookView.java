package warborn.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import warborn.model.spells.Spell;

public class SpellbookView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SpellbookView(Spell spell) {
		setSize(800, 576);
		
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
		
		ImageIcon spellbook = new ImageIcon();
		setLayout(null);
		
		for (int i = 0; i < 13; i++){
			if(i < 7){
				page1.add(new SpellView(spell.getSpell(i)));
			}
			else{
				page2.add(new SpellView(spell.getSpell()));
			}
		}
		
	}
}
