package warborn.main;

import java.awt.*;
import java.util.*;

import javax.swing.JFrame;

import warborn.model.Warborn;

public class MainFrame extends JFrame implements Observer{

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
	
	public MainFrame(GraphicsConfiguration defaultConfiguration, Warborn model) {
		super(defaultConfiguration);
		this.setLayout(new GridBagLayout());
		setBounds(0, 0, model.getWidth(), model.getHeight());
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	@Override
	public void update(Observable obs, Object arg1) {
		if(obs instanceof Warborn && ((Warborn)obs).getPhase() == 1){
			this.setEnabled(false);
			this.setFocusable(false);
		}else{
			this.setEnabled(true);
			this.setFocusable(true);
			this.requestFocus();
		}
		
	}
	

}
