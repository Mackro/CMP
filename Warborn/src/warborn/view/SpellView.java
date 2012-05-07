package warborn.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import warborn.model.spells.Spell;

public class SpellView extends JPanel {

	private static final long serialVersionUID = 1L;
	private GenericButton button;

	/**
	 * Create the Panel.
	 */
	public SpellView(Spell spell) {
		setLayout(null);
		setOpaque(false);
		
		JLabel spellIconLbl = new JLabel(new ImageIcon(spell.getImage()));
		//spellIconLbl.setBounds(10, 5, 40, 40);
		//add(spellIconLbl);
		
		button = new GenericButton();
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBounds(20, 5, 40, 40);
		button.add(spellIconLbl);
		
		JLabel spellNameLbl = new JLabel(spell.getName());
		spellNameLbl.setBounds(80, 100, 150, 20);
		add(spellNameLbl);
		
		JLabel spellCostLbl = new JLabel(Integer.toString(spell.getManaCost()));
		spellCostLbl.setBounds(40, 100, 30, 20);
		add(spellCostLbl);

		this.setToolTipText(spell.getDescription());
		
	}
	
	public GenericButton getButton(){
		return button;
	}
}
