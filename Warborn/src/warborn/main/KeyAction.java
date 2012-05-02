package warborn.main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import warborn.model.Warborn;
import warborn.view.OptionsMenuView;

public class KeyAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private Warborn model;
	private Launcher launcher;
	public MainFrame mainFrame;
	
	public KeyAction(Warborn model, Launcher launcher, MainFrame mainFrame){
		this.model = model;
		this.launcher = launcher;
		this.mainFrame = mainFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getID() == 1001){
			//Open Options Menu
			OptionsMenuView view = new OptionsMenuView(model, mainFrame);
			new OptionsMenuController(view, launcher, mainFrame);
		}
	}
	
	public void addMainFrame(MainFrame main){
		mainFrame = main;
	}

}
