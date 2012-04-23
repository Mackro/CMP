package warborn.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.view.EndGameView;

public class EndGameController implements ActionListener{

	private EndGameView view;
	private Launcher launcher;
	
	public EndGameController(EndGameView view, Launcher launcher){
		this.view = view;
		this.launcher = launcher;
		
		JButton[] buttonArray = view.getButtonArray();
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == view.getButtonArray()[0]){
			//Reset
			view.getFrame().dispose();
			launcher.reset();
		}else if(evt.getSource() == view.getButtonArray()[1]){
			//Exit
			System.exit(0);
		}
	}
	
}
