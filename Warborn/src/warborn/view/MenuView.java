package warborn.view;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

import warborn.model.Warborn;
import warborn.sound.Sound;

public class MenuView extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton btNewGame, btCredits, btExit, btQuickStart, btStart, btBack, btBack2;
	private SelectionPanel pSelection;
	private CreditsPanel pCredits;
	private Sound sounds;
	private String raceDescription, godDescription;
	private JTextArea tARaceDescription, tAGodDescription;
	private JLabel lTitle;
	private File text;
	private FileReader reader;
	
	/**
	 * Create the panel.
	 */
	public MenuView(Warborn model) {
		sounds = new Sound();
		model.addObserver(sounds);
		sounds.start();
		setLayout(null);
		setSize(model.getWidth(), model.getHeight());
		btNewGame = new GenericButton("New Game");
		btNewGame.setLocation(model.getWidth()-200, 50);
		btNewGame.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		add(btNewGame, 0);

		btCredits = new GenericButton("Credits");
		btCredits.setLocation(model.getWidth()-200, 250);
		btCredits.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		add(btCredits, 0);
		
		btExit = new GenericButton("Exit Game");
		btExit.setLocation(model.getWidth()-200, 450);
		btExit.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		add(btExit, 0);
		
		btQuickStart = new GenericButton("Quick Start");
		btQuickStart.setLocation(100, model.getHeight()-250);
		btQuickStart.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		btQuickStart.setVisible(false);
		add(btQuickStart, 0);
		
		btStart = new GenericButton("Start Game");
		btStart.setLocation(300, model.getHeight()-250);
		btStart.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		btStart.setVisible(false);
		add(btStart, 0);
		
		btBack = new GenericButton("Back");
		btBack.setLocation(500, model.getHeight()-250);
		btBack.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		btBack.setVisible(false);
		add(btBack, 0);
		
		btBack2 = new GenericButton("Back");
		btBack2.setLocation(100, model.getHeight()-250);
		btBack2.setSize((int)(model.getWidth()*0.117), (int)(model.getHeight()*0.2));
		btBack2.setVisible(false);
		add(btBack2, 0);

		pSelection = new SelectionPanel(model);
		pSelection.setLocation((int)(this.getWidth()*0.5), 0);
		pSelection.setVisible(false);
		add(pSelection);
		pSelection.updateMap();
		
		pCredits = new CreditsPanel();
		pCredits.setLocation((int)(this.getWidth()*0.25), (int)(this.getHeight()*0.10));
		pCredits.setVisible(false);
		add(pCredits);
		
		lTitle = new JLabel();
		lTitle.setSize((int)(model.getWidth()*0.4), (int)(model.getHeight()*0.15));
		lTitle.setText("Warborn");
		lTitle.setFont(new Font("Gabriola", 0, 130));
		lTitle.setForeground(Color.RED);
		lTitle.setVisible(true);
		lTitle.setLocation((int)(model.getWidth()*0.11), (int)(model.getHeight()*0.02));
		add(lTitle);
		
		tARaceDescription = new JTextArea();
		tARaceDescription.setSize((int)(model.getWidth()*0.4), (int)(model.getHeight()*0.2));
		tARaceDescription.setLocation((int)(model.getWidth()*0.05), (int)(model.getHeight()*0.2));
		tARaceDescription.setBackground(Color.getHSBColor(0.02f, 0.05f, 0.95f));
		tARaceDescription.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.getHSBColor(0.04f, 0.4f, 0.8f), Color.DARK_GRAY));
		tARaceDescription.setEditable(false);
		tARaceDescription.setLineWrap(true);
		tARaceDescription.setWrapStyleWord(true);
		tARaceDescription.setVisible(false);
		add(tARaceDescription, 0);
		updateRaceDescription("Human");
		
		tAGodDescription = new JTextArea();
		tAGodDescription.setSize((int)(model.getWidth()*0.4), (int)(model.getHeight()*0.2));
		tAGodDescription.setBackground(Color.getHSBColor(0.02f, 0.05f, 0.95f));
		tAGodDescription.setLocation((int)(model.getWidth()*0.05), (int)((tARaceDescription.getHeight()*1.2) + (model.getHeight()*0.2)));
		tAGodDescription.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.getHSBColor(0.04f, 0.4f, 0.8f), Color.DARK_GRAY));
		tAGodDescription.setEditable(false);
		tAGodDescription.setLineWrap(true);
		tAGodDescription.setWrapStyleWord(true);
		tAGodDescription.setVisible(false);
		add(tAGodDescription, 0);
		updateGodDescription("Civitatis");
		
	}
	
	public JButton[] getButtonArray(){
		return new JButton[]{
			btNewGame,
			btCredits,
			btExit,
			btQuickStart,
			btStart,
			btBack,
			btBack2,
			pSelection.getAddPlayerButton(),
			pSelection.getRemovePlayerButton(),
			pSelection.getStartButton(),
		};
	}
	
	public JButton[] getColorButtons(){
		return pSelection.getColorButtons();
	}
	
	public String[] getNames(){
		return pSelection.getNames();
	}
	
	public Color[] getColors(){
		return pSelection.getColors();
	}
	
	public int[] getRaces(){
		return pSelection.getRaces();
	}
	
	public int[] getBackgrounds(){
		return pSelection.getGods();
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox[] getComboBoxes(){
		return pSelection.getComboBoxes();
	}
	
	public int getSelectedMapIndex(){
		return pSelection.getSelectedMapIndex();
	}
	
	public void showCredits(){
		btBack.setVisible(true);
		btCredits.setVisible(true);
		pCredits.setVisible(true);
		
		btNewGame.setVisible(false);
		btCredits.setEnabled(false);
		btExit.setVisible(false);
	}
	
	public void openNewGameMenu(){
		btQuickStart.setVisible(true);
		btStart.setVisible(true);
		btBack.setVisible(true);
		btNewGame.setVisible(true);
		
		btNewGame.setEnabled(false);
		btCredits.setVisible(false);
		btExit.setVisible(false);
		btBack2.setVisible(false);
		pSelection.setVisible(false);
		tARaceDescription.setVisible(false);
		tAGodDescription.setVisible(false);
	}
	
	public void openSelectionMenu(){
		btQuickStart.setVisible(false);
		btStart.setVisible(false);
		btBack.setVisible(false);
		btNewGame.setVisible(false);
		btCredits.setVisible(false);
		btExit.setVisible(false);
		
		btBack2.setVisible(true);
		pSelection.setVisible(true);
		tARaceDescription.setVisible(true);
		tAGodDescription.setVisible(true);
	}
	
	public void closeNewGameMenu(){
		btQuickStart.setVisible(false);
		btStart.setVisible(false);
		btBack.setVisible(false);
		pCredits.setVisible(false);

		btNewGame.setEnabled(true);
		btNewGame.setVisible(true);
		btCredits.setEnabled(true);
		btCredits.setVisible(true);
		btExit.setVisible(true);
	}
	
	public void updateMap(){
		pSelection.updateMap();
	}
	
	public void addPlayer(){
		pSelection.addPlayer();
	}
	
	public void removePlayer(){
		pSelection.removePlayer();
	}
	
	@SuppressWarnings("deprecation")
	public void killMusic(){
		sounds.stop();
	}

	public void updateRaceDescription(String element) {
		text = new File("WarbornData/bios/"+element+"Bio.txt");
		try {
			reader = new FileReader(text);
		} catch (FileNotFoundException e) {
			System.out.println("RaceBioNotFound");
		}
		BufferedReader buffReader = new BufferedReader(reader);
		try {
			raceDescription = buffReader.readLine();
		} catch (IOException e) {
			System.out.println("Something wrong with raceBio reading");
		}
		tARaceDescription.setText(raceDescription);
		repaint();
	}

	public void updateGodDescription(String element) {
		text = new File("WarbornData/bios/"+element+"Bio.txt");
		try {
			reader = new FileReader(text);
		} catch (FileNotFoundException e) {
			System.out.println("GodBioNotFound");
		}
		BufferedReader buffReader = new BufferedReader(reader);
		try {
			godDescription = buffReader.readLine();
		} catch (IOException e) {
			System.out.println("Something wrong with godBio reading");
		}
		tAGodDescription.setText(godDescription);
		repaint();
	}

}
