package warborn.main;


import javax.swing.JFrame;

import warborn.model.Warborn;

public class MainFrame extends JFrame {



	/**
	 * Create the Mainframe.
	 */
	public MainFrame(Warborn model) {
		setBounds(0, 0, model.getWidth(), model.getHeight());
		//setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
