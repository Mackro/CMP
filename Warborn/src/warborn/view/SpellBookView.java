package warborn.view;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class SpellBookView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SpellBookView() {
		setSize(800, 576);
		
		JPanel page2 = new JPanel();
		page2.setBounds(400, 0, 400, 576);
		add(page2);
		page2.setLayout(new GridLayout(3, 2));
		
		JPanel page1 = new JPanel();
		page1.setBounds(0, 0, 400, 576);
		add(page1);
		page1.setLayout(new GridLayout(2, 3));
		
		JLabel spellBooklbl = new JLabel();
		spellBooklbl.setIcon(new ImageIcon("C:\\Users\\WarBorn\\Desktop\\WBWS\\CMP\\Warborn\\WarbornData\\images\\SpellBook.jpg"));
		spellBooklbl.setBounds(0, 0, 890, 595);
		add(spellBooklbl);
		
		ImageIcon spellBook = new ImageIcon();
		setLayout(null);
		
	}
}
