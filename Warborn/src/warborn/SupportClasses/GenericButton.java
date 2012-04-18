package warborn.SupportClasses;

import java.awt.Font;

import javax.swing.JButton;

public class GenericButton extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericButton(String s){
		this.setText(s);
		this.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		this.setBorder(new RoundedBorder(5));
	}
}
