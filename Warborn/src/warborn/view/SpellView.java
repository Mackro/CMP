package warborn.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import warborn.model.spells.Spell;

public class SpellView extends JPanel {

	/**
	 * Create the panel.
	 */
	public SpellView(Spell spell) {
		setLayout(null);
		
		JLabel spellIconLbl = new JLabel("");
		spellIconLbl.setBounds(10, 23, 280, 150);
		spellIconLbl.setIcon(spell.getIcon());
		add(spellIconLbl);
		
		JLabel descriptionLbl = new JLabel("");
		descriptionLbl.setBounds(10, 174, 280, 115);
		descriptionLbl.setText(spell.getDescription());
		add(descriptionLbl);
		
		JLabel spellNameLbl = new JLabel("");
		spellNameLbl.setBounds(0, 0, 150, 14);
		spellNameLbl.setText(spell.getName());
		add(spellNameLbl);
		
		JLabel spellCostLbl = new JLabel("");
		spellCostLbl.setBounds(150, 0, 150, 14);
		spellCostLbl.setText(spell.getManaCost() + "");
		add(spellCostLbl);

	}
}
