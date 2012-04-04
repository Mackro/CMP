package warborn.main;

import java.awt.GridBagLayout;
import javax.swing.JFrame;
import warborn.model.Warborn;

public class MainFrame extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the Mainframe.
	 */
	public MainFrame(Warborn model) {
		this.setLayout(new GridBagLayout());
		setBounds(0, 0, model.getWidth(), model.getHeight());
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
