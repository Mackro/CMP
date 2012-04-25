package warborn.view;

import java.util.Observable;
import java.util.Observer;

import warborn.model.Warborn;

public class StatePanelViewCreator implements Observer {

	@Override
	public void update(Observable observable, Object identifyer) {
		Warborn model = (Warborn)observable;
		if(identifyer!=null && identifyer.getClass()==Integer.class){
			switch(model.getState()){
			case 0:
				new Thread(new StatePanel(model, "Place Your Troops")).start();
				break;
			case 1:
				new Thread(new StatePanel(model, model.getCurrentPlayer().getName(), "Reinforce Your Troops")).start();
				break;
			case 2:
				new Thread(new StatePanel(model, "Battle Phase")).start();
				break;
			case 3:
				new Thread(new StatePanel(model, "Troop Movement")).start();
				break;
			}
		}
	}

}
