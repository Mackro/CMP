package warborn.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import warborn.model.Warborn;

public class StatePanelViewCreator implements Observer {
	private JFrame frame;
	private final static int STARTPHASE = 0, REINFORCEPHASE = 1, BATTLEPHASE = 2, MOVEPHASE = 3;
	
	
	public StatePanelViewCreator(JFrame frame){
		this.frame = frame;
	}

	@Override
	public void update(Observable observable, Object identifyer) {
		Warborn model = (Warborn)observable;
		if(identifyer!=null && identifyer.getClass()==Integer.class && (Integer)(identifyer)==1){
			switch(model.getState()){
			case STARTPHASE:
				new Thread(new StatePanel(model, frame, "Place Your Troops")).start();
				break;
			case REINFORCEPHASE:
				new Thread(new StatePanel(model, frame, model.getCurrentPlayer().getName(), "Reinforce Your Troops")).start();
				break;
			case BATTLEPHASE:
				new Thread(new StatePanel(model, frame, "Battle Phase")).start();
				break;
			case MOVEPHASE:
				new Thread(new StatePanel(model, frame, "Troop Movement")).start();
				break;
			}
		}
	}

}
