package warborn.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import warborn.model.Warborn;

public class HudView extends JPanel {

	public HudView(Warborn model){
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 499, 230);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(499, 0, 450, 230);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(949, 0, 417, 230);
		add(panel_2);
		setSize(model.getWidth(), (int)(model.getHeight()*0.25));	
	}
	
	public JButton[] getButtons(){
		return buttons;
	}
	
	@Override
	public void update(Observable ml, Object e) {
		Warborn model = (Warborn)ml;
		
		if (model.getState() == 3){
			next.setText("End Turn");
		}else{
			next.setText("next");
		}
		if (model.getState()==1){
			if (model.getCurrentPlayer().canExchangeCards()){
				useCards.setEnabled(true);
			}
			troops.setText(model.getNbrOfReinforcements() + "");
			//TODO display "troops" in a fitting fashion
		}
		
	}
}
