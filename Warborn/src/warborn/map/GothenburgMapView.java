package warborn.map;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import warborn.model.Model;

public class GothenburgMapView extends JPanel implements IMap { 	

	/**
	 * Create the Map panel.
	 */
	public GothenburgMapView(Model model) {
		setLayout(null);
		
		setSize(model.getWidth(), model.getHeight());
		JLabel maplbl = new JLabel("");
		maplbl.setVerticalAlignment(SwingConstants.TOP);
		maplbl.setBounds(0, 0, model.getWidth(), model.getHeight());
		
		//Scaling the Map to fit the screensize
		Image I = new ImageIcon("images/Gothenburg.jpg").getImage();
		I = I.getScaledInstance(model.getWidth(), (int) ((model.getHeight())*0.75), 0);
		
		maplbl.setIcon(new ImageIcon(I));
		add(maplbl);
		
		JButton kingsslopebtn = new JButton();
		kingsslopebtn.setBounds((int)(model.getWidth()*0.20), (int)(model.getHeight()*0.28), 40,40);
		kingsslopebtn.setText(model.getTerritory(21).getNbrOfUnits()+"");
		
		JButton cabbageNestbtn = new JButton();
		cabbageNestbtn.setBounds((int)(model.getWidth()*0.24), (int)(model.getHeight()*0.25), 40,40);
		cabbageNestbtn.setLabel(model.getTerritory(20).getNbrOfUnits()+"");
		
		System.out.println(model.getTerritory(20).getNbrOfUnits()+"");
		
		add(kingsslopebtn);
		add(cabbageNestbtn);
		
	}
	
	public String toString(){
		return "Gothenburg";
	}
}
