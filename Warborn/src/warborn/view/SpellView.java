package warborn.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import warborn.model.spells.Spell;

public class SpellView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the Panel.
	 */
	public SpellView(Spell spell) {
		//super();
		setLayout(null);
		setOpaque(false);
		
		JLabel spellIconLbl = new JLabel(new ImageIcon(spell.getImage()));
		spellIconLbl.setBounds(10, 5, 40, 40);
		add(spellIconLbl);
		
		JLabel spellNameLbl = new JLabel(spell.getName());
		spellNameLbl.setBounds(20, 50, 150, 20);
		add(spellNameLbl);
		
		JLabel spellCostLbl = new JLabel(Integer.toString(spell.getManaCost()));
		spellCostLbl.setBounds(40, 50, 30, 20);
		add(spellCostLbl);

		this.setToolTipText(spell.getDescription());
		
	}
}
