package warborn.view;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GenericButton extends JButton {

	private static final long serialVersionUID = 1L;

	public GenericButton() {
		super();
		setLook();
	}
	public GenericButton(int i) {
		super();
		setLook(i);
	}
	public GenericButton(String s){
		super(s);
		setLook();
	}
	public GenericButton(String s,int i){
		super(s);
		setLook(i);
	}
	public GenericButton(ImageIcon i){
		super(i);
		setLook();
	}
	public GenericButton(JLabel label) {
		super();
		this.add(label);
		setLook();
	}
	private void setLook(){
		this.setFont(new Font("WarbornFont", Font.BOLD | Font.ITALIC, 14));
		this.setBorder(new RoundedBorder(5));
	}
	private void setLook(int i){
		this.setFont(new Font("WarbornFont", Font.BOLD | Font.ITALIC, i));
		this.setBorder(new RoundedBorder(5));
	}
}
