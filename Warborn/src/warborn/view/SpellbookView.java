package warborn.view;

import java.awt.GridLayout;

import javax.swing.*;

import warborn.model.Spellbook;

public class SpellbookView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private Spellbook spellbook;
	private GenericButton[] buttons;

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
		setOpaque(false);
		//this.setVisible(false);
		
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
		
		buttons = new GenericButton[spellbook.getNumberOfSpells()];
		
		page1.setOpaque(false);
		page2.setOpaque(false);
		
		for (int i = 0; i < this.spellbook.getNumberOfSpells(); i++){
			buttons[i] = new SpellView(spellbook.getSpell(i));
			if(i < 7){
				page1.add(buttons[i]);
			}
			else{
				page2.add(buttons[i]);
			}
		frame.getContentPane().add(this);
		frame.setResizable(false);
		}
	}
	
	public JFrame getFrame(){
		return this.frame;
	}
	
	public GenericButton[] getButtons(){
		return buttons;
	}
}
