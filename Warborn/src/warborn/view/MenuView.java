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
		setBounds(0, 0, model.getHeight(), model.getWidth());
		btNewGame = new JButton("New Game");
		btNewGame.setLocation(model.getWidth()-200, 50);
		btNewGame.setSize(150, 150);
		add(btNewGame);

		btCredits = new JButton("Credits");
		btCredits.setLocation(model.getWidth()-200, 250);
		btCredits.setSize(150, 150);
		add(btCredits);
		
		btExit = new JButton("Exit Game");
		btExit.setLocation(model.getWidth()-200, 250);
		btExit.setSize(150, 150);
		add(btExit);
		
	}

}
