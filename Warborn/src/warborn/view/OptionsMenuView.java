package warborn.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.TitledBorder;

import warborn.model.Warborn;

public class OptionsMenuView extends JPanel {

	private static final long serialVersionUID = 1L;
	private GenericButton btMainMenu, btExit, btResume;
	
	/**
	 * Create the panel.
	 */
	public OptionsMenuView(Warborn model, JFrame fullScreenWindow){
		
		
		fullScreenWindow.getLayeredPane().add(this, JLayeredPane.MODAL_LAYER);
		setSize(400, 600);
		setLocation((int)((model.getWidth()/2)-200), 60);
		setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 5, true),
				"Options", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.SERIF, Font.ITALIC, 40)));
		
		btMainMenu = new GenericButton("Main Menu");
		btMainMenu.setBounds(140, 400, 113, 31);
		add(btMainMenu);
		
		btExit = new GenericButton("Exit Game");
		btExit.setBounds(140, 500, 113, 31);
		add(btExit);
		
		
		btResume = new GenericButton("Resume");
		btResume.setBounds(140, 113, 113, 31);
		add(btResume);
	}

	public JButton[] getButtonArray() {
		return new JButton[]{
				btMainMenu,
				btExit,
				btResume,
		};
		
	}

}
