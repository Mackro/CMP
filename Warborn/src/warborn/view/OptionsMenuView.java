package warborn.view;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import warborn.model.Warborn;

public class OptionsMenuView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btMainMenu, btExit, btResume;
	private JFrame frame;
	
	/**
	 * Create the panel.
	 */
	public OptionsMenuView(Warborn model){
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(400, 600);
		frame.setLocation((int)((model.getWidth()/2) - (frame.getWidth()/2)), 60);
		frame.getContentPane().add(this);
		frame.setVisible(true);
		setLayout(null);
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 5, true),
				"Options", TitledBorder.CENTER , TitledBorder.TOP, new Font(Font.SERIF, Font.ITALIC, 40)));
		
		btMainMenu = new GenericButton("Main Menu");
		btMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btMainMenu.setBounds(140, 400, 113, 31);
		add(btMainMenu);
		
		btExit = new GenericButton("Exit Game");
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btExit.setBounds(140, 500, 113, 31);
		add(btExit);
		
		frame.getContentPane().add(this);
		
		btResume = new GenericButton("Resume");
		btResume.setFont(new Font("Tahoma", Font.PLAIN, 15));
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

	public JFrame getFrame() {
		return frame;
	}
}
