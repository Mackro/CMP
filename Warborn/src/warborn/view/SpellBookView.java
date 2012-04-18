package warborn.view;

import java.awt.GridLayout;

import javax.swing.*;

import warborn.model.Spellbook;

public class SpellbookView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Spellbook spellbook;

	/**
	 * Create the panel.
	 */
	public SpellbookView(Spellbook spellbook) {
		this.spellbook = spellbook;
		frame = new JFrame();
		frame.setLocationRelativeTo(null);
		frame.setUndecorated(true);
		frame.setSize(800, 576);
		frame.setLocation(2, 2);
		setLayout(null);
		
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
		
		page1.setOpaque(false);
		page2.setOpaque(false);
		
		for (int i = 0; i < spellbook.getNumberOfSpells(); i++){
			if(i < 7){
				page1.add(new SpellView(spellbook.getSpell(i)));
			}
			else{
				page2.add(new SpellView(spellbook.getSpell(i)));
			}
		frame.getContentPane().add(this);
		frame.setResizable(false);
		}
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
}
