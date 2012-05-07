package warborn.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import warborn.model.spells.Spell;

public class SpellView extends JPanel {

	private static final long serialVersionUID = 1L;
	private GenericButton button;
	private String description, flavour;

	/**
	 * Create the Panel.
	 */
	public SpellView(Spell spell) {
		setLayout(null);
		setOpaque(false);
		setBorder(new RoundedBorder(100));
		
		description = new String(spell.getDescription().split("\"")[0].trim());
		flavour = new String(spell.getDescription().split("\"")[1].trim());
		
		button = new GenericButton(spell.getName());
		button.setContentAreaFilled(false);
		button.setBounds(60, 10, 100, 100);
		button.setIcon(new ImageIcon(spell.getImage()));
		button.setToolTipText(description);
		add(button);
		
		GenericLabel spellFlavourLbl = new GenericLabel(flavour);
		spellFlavourLbl.setBounds(60, 110, 400, 50);
		add(spellFlavourLbl);
		
		GenericLabel spellNameLbl = new GenericLabel(spell.getName());
		spellNameLbl.setBounds(40, 150, 150, 20);
		add(spellNameLbl);
		
		GenericLabel spellCostLbl = new GenericLabel("Mana: " + Integer.toString(spell.getManaCost()));
		spellCostLbl.setForeground(Color.BLUE);
		spellCostLbl.setBounds(150, 150, 150, 20);
		add(spellCostLbl);
		
		this.setToolTipText(description);
		
	}
	
	public GenericButton getButton(){
		return button;
	}
}
