package warborn.main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import warborn.controller.OptionsMenuController;
import warborn.model.Warborn;
import warborn.view.OptionsMenuView;

public class KeyAction extends AbstractAction{

	private Warborn model;
	private Launcher launcher;
	public MainFrame mainFrame;
	
	public KeyAction(Warborn model, Launcher launcher){
		this.model = model;
		this.launcher = launcher;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getID() == 1001){
			//Open Options Menu
			OptionsMenuView view = new OptionsMenuView(model);
			new OptionsMenuController(model, view, launcher, mainFrame);
			if(mainFrame != null){
				mainFrame.setEnabled(false);
				mainFrame.setFocusable(false);
			}
		}
	}
	
	public void addMainFrame(MainFrame main){
		mainFrame = main;
	}

}
