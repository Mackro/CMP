package warborn.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

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
		setBorder(new RoundedBorder(80));
		
		description = new String(spell.getDescription().split("\"")[0].trim());
		flavour = new String(spell.getDescription().split("\"")[1].trim());
		
		
		GenericLabel spellNameLbl = new GenericLabel(spell.getName());
		spellNameLbl.setBounds(40, 10, 150, 20);
		add(spellNameLbl);
		
		GenericLabel spellCostLbl = new GenericLabel("Mana: " + Integer.toString(spell.getManaCost()));
		spellCostLbl.setForeground(Color.BLUE);
		spellCostLbl.setBounds(150, 10, 150, 20);
		add(spellCostLbl);
		
		button = new GenericButton();
		button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED),
				BorderFactory.createBevelBorder(BevelBorder.LOWERED)));
		button.setContentAreaFilled(false);
		button.setBounds(60, 50, 64, 64);
		button.setIcon(new ImageIcon(spell.getImage()));
		button.setActionCommand(spell.getName());
		button.setToolTipText(description);
		add(button);
		
		JTextArea textArea = new JTextArea(description);
		textArea.setBounds(140, 50, 170, 90);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("fonting", Font.PLAIN, 12));
		textArea.setEditable(false);
		textArea.setOpaque(false);
		add(textArea);
		
		GenericLabel spellFlavourLbl = new GenericLabel(flavour);
		spellFlavourLbl.setBounds(40, 130, 400, 50);
		add(spellFlavourLbl);
		
	}
	
	public GenericButton getButton(){
		return button;
	}
}
