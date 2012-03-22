package warborn.map;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GothenburgMapView extends JPanel { 	

	/**
	 * Create the panel.
	 */
	public GothenburgMapView() {
		setLayout(null);
		
		setSize(1366, 768);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(0, 0, 1366, 768);
		
		Image I = new ImageIcon("images/Gothenburg.jpg").getImage();
		I = I.getScaledInstance(TestGothenburg.getWidth(), (int) ((TestGothenburg.getHeight())*0.75), 0);
		
		lblNewLabel.setIcon(new ImageIcon(I));
		add(lblNewLabel);
		
	}
	
	public String toString(){
		return "Gothenburg";
	}
}
