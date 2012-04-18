package warborn.main;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;
import javax.swing.*;

import javax.swing.JFrame;

import sun.audio.*;
import warborn.model.Warborn;
import warborn.sound.Sound;

public class MainFrame extends JFrame implements Observer{

	public Sound sounds = new Sound();

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
		sounds.start();
		
	}
	
	@Override
	public void update(Observable obs, Object arg1) {
		if(obs instanceof Warborn && ((Warborn)obs).getState() == 0){
			sounds.playIntro();
			System.out.println("WAAAAAAAAAAAAAAGH!");
		}
		else{
			sounds.stopIntro();
		}
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
