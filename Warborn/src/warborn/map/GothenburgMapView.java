package warborn.map;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import warborn.model.Model;

public class GothenburgMapView extends JPanel implements IMap { 	

	/**
	 * Create the panel.
	 */
	public GothenburgMapView(Model model) {
		setLayout(null);
		
		setSize(1366, 768);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(0, 0, model.getWidth(), model.getHeight());
		
		Image I = new ImageIcon("images/Gothenburg.jpg").getImage();
		I = I.getScaledInstance(model.getWidth(), (int) ((model.getHeight())*0.75), 0);
		
		lblNewLabel.setIcon(new ImageIcon(I));
		add(lblNewLabel);
		
	}
	
	public String toString(){
		return "Gothenburg";
	}
}
