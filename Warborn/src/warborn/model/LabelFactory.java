package warborn.model;

import java.awt.Font;

import javax.swing.JLabel;

public class LabelFactory extends JLabel {
	
	public LabelFactory(String s){
		this.setText(s);
		this.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
	}
}
