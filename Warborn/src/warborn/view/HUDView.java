package warborn.view;

import java.util.Observable;
import java.util.Observer;
import warborn.model.Warborn;
import javax.swing.*;

public class HudView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JButton[] buttons;
	private JButton next, useCards;
	//private JLabel territoryData;
	//private JLabel[] PlayerStats;
	private JLabel reinforcements;
	
	public HudView(Warborn model){

		this.setLayout(null);
		this.setSize(model.getWidth(), (int)(model.getHeight()*0.25));
		this.setLocation(0, (int)(model.getHeight()*0.75));
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 499, 230);
		this.add(panel);
		
		buttons = new JButton[2];
		
		next = new JButton();
		next.setBounds((int)(panel.getWidth()*0.8), (int)(panel.getHeight()*0.25), 
				(int)(panel.getWidth()*0.1), (int)(panel.getHeight()*0.5));
		panel.add(next);
		next.setVisible(true);
		buttons[0] = next;
		
		useCards = new JButton();
		useCards.setBounds((int)(panel.getWidth()*0.1), (int)(panel.getHeight()*0.25), 
				(int)(panel.getWidth()*0.1), (int)(panel.getHeight()*0.5));
		panel.add(useCards);
		useCards.setVisible(true);
		buttons[1] = useCards;
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
			reinforcements.setText(model.getNbrOfReinforcements() + "");
			//TODO display "troops" in a fitting fashion
		}
		
	}
}
