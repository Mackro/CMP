package warborn.view;

import java.awt.GridLayout;

import javax.swing.*;

import warborn.model.spells.Spellbook;

public class SpellbookView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Spellbook spellbook;
	private SpellView[] spells;
	private GenericButton closeButton;

	/**
	 * Create the panel.
	 */
	public SpellbookView(Spellbook spellbook, JFrame window) {
		this.spellbook = spellbook;
		
		setSize(800, 576);
		setLocation(2, 2);

		setLayout(null);
		setOpaque(false);
		
		JPanel page1 = new JPanel();
		page1.setBounds(55, 11, 350, 554);
		page1.setBorder(new RoundedBorder(5));
		add(page1);
		page1.setLayout(new GridLayout(3, 1));
		
		JPanel page2 = new JPanel();
		page2.setBounds(410, 11, 350, 554);
		page2.setBorder(new RoundedBorder(5));
		add(page2);
		page2.setLayout(new GridLayout(4, 2));
		
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
		
		closeButton = new GenericButton("Close");
		closeButton.setContentAreaFilled(false);
		page2.add(closeButton);
		
		window.getLayeredPane().add(this, JLayeredPane.MODAL_LAYER);
	}
	
	public SpellView[] getSpellViews(){
		return spells;
	}

	public GenericButton getCancelButton() {
		return closeButton;
	}
}
