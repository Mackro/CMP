package warborn.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import warborn.model.Warborn;

public class MenuView extends JPanel {

	private JButton btNewGame, btCredits, btExit;
	
	/**
	 * Create the panel.
	 */
	public MenuView(Warborn model) {
		setLayout(null);
		setSize(model.getWidth(), model.getHeight());
		btNewGame = new JButton("New Game");
		btNewGame.setLocation(model.getWidth()-200, 50);
		btNewGame.setSize(150, 150);
		add(btNewGame, 0);

		btCredits = new JButton("Credits");
		btCredits.setLocation(model.getWidth()-200, 250);
		btCredits.setSize(150, 150);
		add(btCredits, 0);
		
		btExit = new JButton("Exit Game");
		btExit.setLocation(model.getWidth()-200, 450);
		btExit.setSize(150, 150);
		add(btExit, 0);
		
	}

}
