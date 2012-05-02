package warborn.view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import warborn.model.Warborn;

public class StatePanelViewCreator implements Observer {
	private JFrame frame;
	
	public StatePanelViewCreator(JFrame frame){
		this.frame = frame;
	}

	@Override
	public void update(Observable observable, Object identifyer) {
		Warborn model = (Warborn)observable;
		if(identifyer!=null && identifyer.getClass()==Integer.class && (Integer)(identifyer)==1){
			switch(model.getState()){
			case 0:
				new Thread(new StatePanel(model, frame, "Place Your Troops")).start();
				break;
			case 1:
				new Thread(new StatePanel(model, frame, model.getCurrentPlayer().getName(), "Reinforce Your Troops")).start();
				break;
			case 2:
				new Thread(new StatePanel(model, frame, "Battle Phase")).start();
				break;
			case 3:
				new Thread(new StatePanel(model, frame, "Troop Movement")).start();
				break;
			}
		}
	}

}
