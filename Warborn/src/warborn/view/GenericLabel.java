package warborn.view;

import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JLabel;

public class GenericLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	
	public GenericLabel(){
		super();
		this.setFont(new Font("WarbornFont", Font.ITALIC, 14));
	}
	
	public GenericLabel(String text){
		super(text);
		this.setFont(new Font("WarbornFont", Font.ITALIC, 14));
	}
	
	public GenericLabel(Icon icon){
		super(icon);
	}

}
