package warborn.map;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class GothenburgMap extends JPanel implements IMap {
	

	/**
	 * Create the panel.
	 */
	public GothenburgMap() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 644, 444);
		
		Image I = new ImageIcon("images/Map_background.jpg").getImage();
		I = I.getScaledInstance(model.getWidth(), model.getHeight(), 0);
		
		lblNewLabel.setIcon(new ImageIcon(I));
		add(lblNewLabel);
		
	}

	@Override
	public String[] getTerritories() {
		return null;
	}
	
	public String toString(){
		return null;
	}
}
