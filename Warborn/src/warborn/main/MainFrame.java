package warborn.main;

import java.awt.*;

import javax.swing.JFrame;

import warborn.model.Warborn;

public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;

	/**
	 * Create the Mainframe.
	 */
	public MainFrame(Warborn model) {
		setBounds(0, 0, model.getWidth(), model.getHeight());
		setParameters();
	}
	
	public MainFrame(GraphicsConfiguration defaultConfiguration, Warborn model) {
		super(defaultConfiguration);
		setParameters();
	}
	
	public void setParameters(){
		this.setLayout(new GridBagLayout());
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	

}
