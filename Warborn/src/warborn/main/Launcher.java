package warborn.main;

import java.awt.DisplayMode;
import java.awt.EventQueue;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import warborn.map.IMap;
import warborn.model.Model;

public class Launcher implements Observer{

	private JFrame frame;
	private Model model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					DisplayMode[] modes = window.model.getDisplayModes();
					ScreenManager screen = window.model.getScreenManager();
					DisplayMode compatibleMode = screen.getFirstCompatibleDisplayMode(modes);
					screen.setFullScreen(compatibleMode, window.frame);
					Thread.sleep(5000);
					screen.restoreScreen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		initialize();
		model = new Model();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	public void createGame(IMap map){
		frame.add((JPanel)map);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(model.getState() == 1){
			model.deleteObserver(this);
			createGame(model.getMap());
		}
	}

}
