package warborn.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.view.OptionsMenuView;

public class OptionsMenuController implements ActionListener{

	private OptionsMenuView view;
	private Launcher launcher;
	private MainFrame mainFrame;
	
	public OptionsMenuController(OptionsMenuView view, Launcher launcher, MainFrame mainFrame){
		this.view = view;
		this.launcher = launcher;
		this.mainFrame = mainFrame;
		for(JButton button : view.getButtonArray()){
			button.addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton)(e.getSource());
		
		if(buttonPressed == view.getButtonArray()[0]){
			//Main Menu
			view.getFrame().dispose();
			launcher.reset();
		}else if(buttonPressed == view.getButtonArray()[1]){
			//Exit
			System.exit(0);
		}else if(buttonPressed == view.getButtonArray()[2]){
			//Resume
			view.getFrame().dispose();
			if(mainFrame != null){
				mainFrame.setEnabled(true);
				mainFrame.setFocusable(true);
				mainFrame.requestFocus();
			}
		}
	}
	
}
