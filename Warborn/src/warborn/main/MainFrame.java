package warborn.main;

import java.awt.*;
import java.util.*;

import javax.swing.JFrame;

import warborn.model.Warborn;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the Mainframe.
	 */
	public MainFrame(Warborn model) {
		this.setLayout(new GridBagLayout());
		setBounds(0, 0, model.getWidth(), model.getHeight());
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		
	}
	
	public MainFrame(GraphicsConfiguration defaultConfiguration, Warborn model) {
		super(defaultConfiguration);
		this.setLayout(new GridBagLayout());
		//setBounds(0, 0, model.getWidth(), model.getHeight());
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	

}
