package warborn.view;

import java.awt.Font;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class EllipseButton extends JButton {
	
	public EllipseButton(){
		super();
		setLook();
	}

	public EllipseButton(String string) {
		super(string);
		setLook();
	}
	
	private void setLook(){
		this.setFont(new Font("WarbornFont", Font.BOLD | Font.ITALIC, 14));
		this.setContentAreaFilled(false);
		setBorder(new RoundedBorder(150));
	}
}
