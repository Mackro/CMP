package warborn.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;

import warborn.map.IMap;

public class LaunchController {

	private JFrame frame;
	private String[] playerNames;
	private Color[] playerColors;
	private IMap[] maps;
	private int mapNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaunchController window = new LaunchController();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LaunchController() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initializeMaps();
	}

	private void initializeMaps() {
		maps = new IMap[1];
		maps[0] = new GothenburgMap();

	}
	
	public void createGame(){
		ModelFactory.createModel(playerNames, playerColors, maps[mapNumber].toString());
	}

}
