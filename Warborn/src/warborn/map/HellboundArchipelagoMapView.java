package warborn.map;

import java.awt.Image;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import warborn.model.MapData;
import warborn.model.MapNotFoundException;
import warborn.model.Warborn;

public class HellboundArchipelagoMapView extends JPanel implements IMap {

	
	private Warborn model;
	private JButton[] buttons;
	private double[][] scalingConstants;
	/**
	 * Create the Map panel.
	 */
	
	public HellboundArchipelagoMapView(Warborn model){
		this.model = model;
		
		try{
			scalingConstants = MapData.getScalingConstants(getMapName());
		}catch(MapNotFoundException mnfe){
			mnfe.printStackTrace();
		}
		setLayout(null);
		setSize(model.getWidth(), model.getHeight());
		buttons = new JButton[model.getTerritories().length];
		
		JLabel maplbl = new JLabel("");
		maplbl.setVerticalAlignment(SwingConstants.TOP);
		maplbl.setBounds(0, 0, model.getWidth(), (int)(model.getHeight()*0.75));
		
		//Scaling the Map image to fit the screensize
		Image I = new ImageIcon("WarbornData/images/" + getMapName() + ".png").getImage();
		I = I.getScaledInstance(model.getWidth(), (int) ((model.getHeight())*0.75), 0);
		maplbl.setIcon(new ImageIcon(I));
		
	}
	
	@Override
	public JButton[] getButtons() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static String getMapName(){
		return "Archipelago";
	}
	
	public String toString(){
		return "Archipelago";
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}



}
