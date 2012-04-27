package warborn.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import warborn.model.spells.Spell;

public class SpellView extends GenericButton {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the button.
	 */
	public SpellView(Spell spell) {
		super();
		setLayout(null);
		this.setOpaque(false);
		
		JLabel spellIconLbl = new JLabel(new ImageIcon(spell.getImage()));
		spellIconLbl.setBounds(10, 23, 150, 150);
		add(spellIconLbl);
		
		JLabel spellNameLbl = new JLabel(spell.getName());
		spellNameLbl.setBounds(0, 0, 150, 14);
		add(spellNameLbl);
		
		JLabel spellCostLbl = new JLabel(Integer.toString(spell.getManaCost()));
		spellCostLbl.setBounds(40, 50, 30, 100);
		add(spellCostLbl);

		this.setToolTipText(spell.getDescription());
		
	}
}
