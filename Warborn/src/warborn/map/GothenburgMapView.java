package warborn.map;

import java.awt.DisplayMode;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GothenburgMapView extends JPanel implements IMap { 	

	/**
	 * Create the panel.
	 */
	public GothenburgMapView() {
		setLayout(null);
		
		setSize(1366, 768);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1366, 768);
		
		Image I = new ImageIcon("images/Map_background.jpg").getImage();
		I = I.getScaledInstance(TestGothenburg.getWidth(), (int) ((TestGothenburg.getHeight())), 0);
		
		lblNewLabel.setIcon(new ImageIcon(I));
		add(lblNewLabel);
		
	}
	
	public String toString(){
		return "Gothenburg";
	}
}
