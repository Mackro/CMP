package warborn.view;

import java.awt.Color;

import javax.swing.ImageIcon;
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
		setBorder(new RoundedBorder(5));
		
		button = new GenericButton();
		button.setContentAreaFilled(false);
		button.setBounds(60, 10, 140, 140);
		button.setText(spell.getName());
		button.setIcon(new ImageIcon(spell.getImage()));
		add(button);
		
		GenericLabel spellNameLbl = new GenericLabel(spell.getName());
		spellNameLbl.setBounds(40, 150, 150, 20);
		add(spellNameLbl);
		
		GenericLabel spellCostLbl = new GenericLabel("Mana: " + Integer.toString(spell.getManaCost()));
		spellCostLbl.setForeground(Color.BLUE);
		spellCostLbl.setBounds(150, 150, 150, 20);
		add(spellCostLbl);

		this.setToolTipText(spell.getDescription().split("\"")[0]);
		
	}
	
	public GenericButton getButton(){
		return button;
	}
}
