package warborn.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import warborn.view.EndGameView;

public class EndGameController implements ActionListener{

	private EndGameView view;
	private Launcher launcher;
	private JFrame frame;
	
	public EndGameController(EndGameView view, JFrame frame, Launcher launcher){
		this.view = view;
		this.frame = frame;
		this.launcher = launcher;
		
		JButton[] buttonArray = view.getButtonArray();
		for(int i = 0; i < buttonArray.length; i++){
			buttonArray[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource() == view.getButtonArray()[0]){
			//Reset
			frame.getLayeredPane().remove(view);
			frame.repaint();
			launcher.reset();
		}else if(evt.getSource() == view.getButtonArray()[1]){
			//Exit
			launcher.exit();
		}
	}
	
}
