package warborn.model;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonFactory extends JButton {
	
	public ButtonFactory(String s){
		this.setText(s);
		this.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
	}
}
