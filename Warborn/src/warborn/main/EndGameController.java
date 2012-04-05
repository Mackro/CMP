package warborn.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.model.Warborn;

public class EndGameController implements ActionListener{

	private Warborn model;
	private EndGameView view;
	
	public EndGameController(Warborn model, EndGameView view){
		this.model = model;
		this.view = view;
		
		JButton[] buttonArray = view.getButtonArray();
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == view.getButtonArray()[0]){
			//Reset
			Launcher.reset();
		}else if(evt.getSource() == view.getButtonArray()[1]){
			//Exit
			System.exit(0);
		}
	}
	
}
