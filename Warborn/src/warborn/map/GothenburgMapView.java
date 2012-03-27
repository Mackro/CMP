package warborn.map;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import warborn.model.Warborn;

public class GothenburgMapView extends Observable implements IMap, ActionListener { 	

	
	private JPanel mapPanel;
	private JButton thorsLandingBtn, kingsSlopeBtn, cabbageNestBtn;
	private Warborn model;
	
	/**
	 * Create the Map panel.
	 */
	public GothenburgMapView(Warborn model) {
		
		this.model = model;
		
		mapPanel = new JPanel();
		mapPanel.setLayout(null);
		
		mapPanel.setSize(model.getWidth(), model.getHeight());
		JLabel maplbl = new JLabel("");
		maplbl.setVerticalAlignment(SwingConstants.TOP);
		maplbl.setBounds(0, 0, model.getWidth(), model.getHeight());
		
		//Scaling the Map to fit the screensize
		Image I = new ImageIcon("images/Gothenburg.jpg").getImage();
		I = I.getScaledInstance(model.getWidth(), (int) ((model.getHeight())*0.75), 0);
		
		maplbl.setIcon(new ImageIcon(I));
		mapPanel.add(maplbl);
		
		kingsSlopeBtn = new JButton();
		kingsSlopeBtn.setBounds((int)(model.getWidth()*0.19), (int)(model.getHeight()*0.26), 45,45);
		kingsSlopeBtn.setText(model.getTerritory(21).getNbrOfUnits()+"");
		kingsSlopeBtn.addActionListener(this);
		kingsSlopeBtn.setActionCommand("21");
		
		cabbageNestBtn = new JButton();
		cabbageNestBtn.setBounds((int)(model.getWidth()*0.26), (int)(model.getHeight()*0.22), 45,45);
		cabbageNestBtn.setText(model.getTerritory(20).getNbrOfUnits()+"");
		cabbageNestBtn.addActionListener(this);
		cabbageNestBtn.setActionCommand("20");
		
		thorsLandingBtn = new JButton();
		thorsLandingBtn.setBounds((int)(model.getWidth()*0.76), (int)(model.getHeight()*0.16), 45,45);
		thorsLandingBtn.setText(model.getTerritory(0).getNbrOfUnits()+"");
		thorsLandingBtn.addActionListener(this);
		thorsLandingBtn.setActionCommand("0");
		
		mapPanel.add(kingsSlopeBtn);
		mapPanel.add(cabbageNestBtn);
		mapPanel.add(thorsLandingBtn);
		
	}
	
	public JPanel getMapPanel() {
		// TODO Auto-generated method stub
		return mapPanel;
	}
	
	public String toString(){
		return "Gothenburg";
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setChanged();
		notifyObservers(Integer.parseInt(((JButton) e.getSource()).getActionCommand()));
	System.out.println(Integer.parseInt(((JButton) e.getSource()).getActionCommand()) + "   actionPerformed");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		thorsLandingBtn.setText(model.getTerritory(Integer.parseInt(thorsLandingBtn.getActionCommand())).getNbrOfUnits() + "");
		kingsSlopeBtn.setText(model.getTerritory(Integer.parseInt(kingsSlopeBtn.getActionCommand())).getNbrOfUnits() + "");
		cabbageNestBtn.setText(model.getTerritory(Integer.parseInt(cabbageNestBtn.getActionCommand())).getNbrOfUnits() + "");
		
	}


}
