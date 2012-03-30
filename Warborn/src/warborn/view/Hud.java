package warborn.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

import warborn.model.Warborn;

public class Hud implements Observer {
	
	private JButton next, useCards;
	private JLabel troops;

	public Hud(){
		
	}
	
	@Override
	public void update(Observable ml, Object e) {
		Warborn model = (Warborn)ml;
		
		if (model.getState() == 3){
			next.setText("End Turn");
		}
		
		if (model.getState()==1){
			if (model.getCurrentPlayer().)
				useCards.setEnabled(true);
			}
			next.setText("Done");
			troops.setText(model.getNbrOfReinforcements() + "");
			//TODO display "troops" in a fitting fashion
		}
		
	}

}
