package warborn.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import warborn.model.Warborn;

public class MenuView extends JPanel {

	private JButton btNewGame, btCredits, btExit, btQuickStart, btStart, btBack;
	
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
		
		btQuickStart = new JButton("Quick Start");
		btQuickStart.setLocation(100, model.getHeight()-250);
		btQuickStart.setSize(150, 150);
		btQuickStart.setVisible(false);
		add(btQuickStart, 0);
		
		btStart = new JButton("Start Game");
		btStart.setLocation(300, model.getHeight()-250);
		btStart.setSize(150, 150);
		btStart.setVisible(false);
		add(btStart, 0);
		
		btBack = new JButton("Back");
		btBack.setLocation(500, model.getHeight()-250);
		btBack.setSize(150, 150);
		btBack.setVisible(false);
		add(btBack, 0);
		
	}
	
	public JButton[] getButtonArray(){
		return new JButton[]{
			btNewGame,
			btCredits,
			btExit,
		};
	}
	
	public void openNewGameMenu(){
		btQuickStart.setVisible(true);
		btStart.setVisible(true);
		btBack.setVisible(true);
		btNewGame.setEnabled(false);
		btCredits.setVisible(false);
		btExit.setVisible(false);
	}

}
