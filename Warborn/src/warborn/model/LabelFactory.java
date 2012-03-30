package warborn.model;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelFactory {
	
	public static JLabel makeLabel(String s){
		JLabel label = new JLabel();
		label.setText(s);
		label.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		return label;
	}
}
