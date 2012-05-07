package warborn.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class GenericButton extends JButton {

	private static final long serialVersionUID = 1L;

	public GenericButton() {
		super();
		setLook();
	}
	public GenericButton(String s){
		super(s);
		setLook();
	}
	public GenericButton(ImageIcon i){
		super(i);
		setLook();
	}
	private void setLook(){
		this.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		this.setBorder(new RoundedBorder(5));
	}
}
