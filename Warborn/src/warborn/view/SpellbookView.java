package warborn.view;

import java.awt.GridLayout;

import javax.swing.*;

import warborn.model.spells.Spellbook;

public class SpellbookView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Spellbook spellbook;
	private SpellView[] spells;

	/**
	 * Create the panel.
	 */
	public SpellbookView(Spellbook spellbook, JFrame window) {
		this.spellbook = spellbook;
		
		setSize(800, 576);
		setLocation(2, 2);

		setLayout(null);
		setOpaque(false);
		
		JPanel page2 = new JPanel();
		page2.setBounds(400, 11, 358, 554);
		add(page2);
		page2.setLayout(new GridLayout(4, 3));
		
		JPanel page1 = new JPanel();
		page1.setBounds(55, 11, 345, 554);
		add(page1);
		page1.setLayout(new GridLayout(4, 3));
		
		JLabel spellbooklbl = new JLabel();
		spellbooklbl.setIcon(new ImageIcon("WarbornData/images/SpellBook.png"));
		spellbooklbl.setBounds(0, 0, 890, 595);
		add(spellbooklbl);
		
		spells = new SpellView[spellbook.getNumberOfSpells()];
		
		page1.setOpaque(false);
		page2.setOpaque(false);
		
		for (int i = 0; i < this.spellbook.getNumberOfSpells(); i++){
			spells[i] = new SpellView(this.spellbook.getSpell(i));
			if(i < 7){
				page1.add(spells[i]);
			}
			else{
				page2.add(spells[i]);
			}
		}
		window.getLayeredPane().add(this, JLayeredPane.MODAL_LAYER);
	}
	
	public SpellView[] getSpellViews(){
		return spells;
	}
}
