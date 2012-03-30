package warborn.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import warborn.model.Warborn;

public class Hud implements Observer {
	
	private JButton[] buttons;
	private JButton next, useCards;
	private JLabel troops;

	public Hud(){
		
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
