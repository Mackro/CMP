package warborn.map;

import java.awt.Image;
import java.util.Observable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import warborn.SupportClasses.MapData;
import warborn.SupportClasses.RoundedBorder;
import warborn.model.Warborn;

public class GothenburgMapView extends JPanel implements IMap { 	

	
	private Warborn model;
	private JButton[] buttons;
	private double[][] scalingConstants; 
	/**
	 * Create the Map panel.
	 */
	public GothenburgMapView(Warborn model) {
		
		this.model = model;
		scalingConstants = MapData.getScalingConstants(this);
		
		setLayout(null);
		setSize(model.getWidth(), model.getHeight());
		buttons = new JButton[model.getTerritories().length];
		
		JLabel maplbl = new JLabel("");
		maplbl.setVerticalAlignment(SwingConstants.TOP);
		maplbl.setBounds(0, 0, model.getWidth(), model.getHeight());
		
		//Scaling the Map image to fit the screensize
		Image I = new ImageIcon("images/Gothenburg.jpg").getImage();
		I = I.getScaledInstance(model.getWidth(), (int) ((model.getHeight())*0.75), 0);
		
		maplbl.setIcon(new ImageIcon(I));
		
		
		for (int i = 0; i < model.getTerritories().length; i++){
			buttons[i] = new JButton();
			buttons[i].setText(model.getTerritory(i).getNbrOfUnits()+"");
			buttons[i].setActionCommand(i + "");
			buttons[i].setBackground(model.getTerritory(i).getOwner().getColor());
			buttons[i].setBounds((int)(model.getWidth()*scalingConstants[i][0]),(int)(model.getHeight()*scalingConstants[i][1]), 45, 45);
			//buttons[i].setOpaque(false);
			//buttons[i].setFocusPainted(false);
			//buttons[i].setBorderPainted(false);
			//buttons[i].setContentAreaFilled(false);
			//buttons[i].setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
			//buttons[i].setBorder(new RoundedBorder(22));
			//buttons[i].setForeground(model.getTerritory(i).getOwner().getColor());
		}
		
		/**
		// Thors landing
		buttons[0].setBounds((int)(model.getWidth()*0.76), (int)(model.getHeight()*0.16), 45,45);
		// Hen Island
		buttons[1].setBounds((int)(model.getWidth()*0.59), (int)(model.getHeight()*0.065), 45,45);
		// Scorched Isle's
		buttons[2].setBounds((int)(model.getWidth()*0.4), (int)(model.getHeight()*0.064), 45,45);
		// Bishops Garden
		buttons[3].setBounds((int)(model.getWidth()*0.675), (int)(model.getHeight()*0.18), 45,45);
		// Kings River
		buttons[4].setBounds((int)(model.getWidth()*0.8), (int)(model.getHeight()*0.27), 45,45);
		// Northern Angredia
		buttons[5].setBounds((int)(model.getWidth()*0.7), (int)(model.getHeight()*0.38), 45,45);
		// Mt Lake
		buttons[6].setBounds((int)(model.getWidth()*0.85), (int)(model.getHeight()*0.43), 45,45);
		// Southern Angredia
		buttons[7].setBounds((int)(model.getWidth()*0.76), (int)(model.getHeight()*0.52), 45,45);
		// Land of the gnomes
		buttons[8].setBounds((int)(model.getWidth()*0.6), (int)(model.getHeight()*0.515), 45,45);
		// Easterns Necropolis
		buttons[9].setBounds((int)(model.getWidth()*0.62), (int)(model.getHeight()*0.41), 45,45);
		// The Northern City
		buttons[10].setBounds((int)(model.getWidth()*0.59), (int)(model.getHeight()*0.30), 45,45);
		// Winding Islet
		buttons[11].setBounds((int)(model.getWidth()*0.63), (int)(model.getHeight()*0.28), 45,45);
		// Majornia
		buttons[12].setBounds((int)(model.getWidth()*0.52), (int)(model.getHeight()*0.12), 45,45);
		// plain of the Lepprechauns
		buttons[13].setBounds((int)(model.getWidth()*0.52), (int)(model.getHeight()*0.41), 45,45);
		// Meadow of the sun
		buttons[14].setBounds((int)(model.getWidth()*0.45), (int)(model.getHeight()*0.41), 45,45);
		// Forest of Kings
		buttons[15].setBounds((int)(model.getWidth()*0.51), (int)(model.getHeight()*0.33), 45,45);
		// High Nest
		buttons[16].setBounds((int)(model.getWidth()*0.45), (int)(model.getHeight()*0.14), 45,45);
		// Meadow of seeds
		buttons[17].setBounds((int)(model.getWidth()*0.44), (int)(model.getHeight()*0.29), 45,45);
		// Land of the Elves
		buttons[18].setBounds((int)(model.getWidth()*0.36), (int)(model.getHeight()*0.21), 45,45);
		// Millers valley
		buttons[19].setBounds((int)(model.getWidth()*0.34), (int)(model.getHeight()*0.305), 45,45);
		// Cabbage Nest
		buttons[20].setBounds((int)(model.getWidth()*0.26), (int)(model.getHeight()*0.22), 45,45);
		// Kings Slope
		buttons[21].setBounds((int)(model.getWidth()*0.19), (int)(model.getHeight()*0.26), 45,45);
		*/
		
		add(maplbl, 0);
		for (int i=0; i<22; i++){
			add(buttons[i], 0);
		}		
	}
	
	public JButton[] getButtons() {
		return buttons;
	}
	

	public static String toString(int i){
		return "Gothenburg";
	}
	
	public String toString(){
		return "Gothenburg";
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
		for(int i = 0; i < buttons.length; i++){
			buttons[i].setText(model.getTerritory(Integer.parseInt(buttons[i].getActionCommand())).getNbrOfUnits() + "");
		}
	}
}
