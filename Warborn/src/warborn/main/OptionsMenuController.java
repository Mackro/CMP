package warborn.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import warborn.view.OptionsMenuView;

public class OptionsMenuController implements ActionListener{

	private static final int MAINMENU = 0, EXITGAME = 1, RESUME = 2;
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
		
		if(buttonPressed == view.getButtonArray()[MAINMENU]){
			//Main Menu
			mainFrame.getLayeredPane().remove(view);
			mainFrame.repaint();
			launcher.reset();
		}else if(buttonPressed == view.getButtonArray()[EXITGAME]){
			//Exit
			launcher.exit();
		}else if(buttonPressed == view.getButtonArray()[RESUME]){
			//Resume
			mainFrame.getLayeredPane().remove(view);
			mainFrame.repaint();
			if(mainFrame != null){
				mainFrame.setEnabled(true);
				mainFrame.setFocusable(true);
				mainFrame.requestFocus();
			}
		}
	}
	
}
