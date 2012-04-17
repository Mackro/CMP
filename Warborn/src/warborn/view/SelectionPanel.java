package warborn.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.*;

import warborn.SupportClasses.MapData;
import warborn.model.LabelFactory;
import warborn.model.Warborn;

public class SelectionPanel extends JPanel {

	private JButton btStartGame, btAddPlayer;
	private JComboBox cbMap;
	private JLabel lbMap;
	private JPanel pPlayer, pMap;
	private Warborn model;
	
	/**
	 * Create the panel.
	 */
	public SelectionPanel(Warborn model) {
		
		this.model = model;
		
		setLayout(null);
		setSize((int)(model.getWidth()*0.5), model.getHeight());
		setBackground(Color.DARK_GRAY);
		
		pPlayer = new JPanel();
		pPlayer.setLayout(new GridLayout(4, 1));
		pPlayer.setBounds(10, 10 + 40, (int)(this.getWidth()*0.5)-15, this.getHeight()-60);
		add(pPlayer);
		
		btAddPlayer = new JButton("Add a player");
		btAddPlayer.setSize(pPlayer.getWidth()/3, 40);
		btAddPlayer.setLocation(pPlayer.getWidth() - btAddPlayer.getWidth(), 5);
		this.add(btAddPlayer, 0);
		
		for(int i = 0; i < model.getNumberOfPlayers(); i++){
			pPlayer.add(new PlayerSelectionPanel(model, i+1));
		}

		pMap = new JPanel();
		pMap.setLayout(null);
		pMap.setBounds((int)(this.getWidth()*0.5)+10, 10, (int)(this.getWidth()*0.5)-15, this.getHeight()-20);
		add(pMap);
		
		cbMap = new JComboBox();
		cbMap.setSize(100, 40);
		cbMap.setBackground(Color.WHITE);
		cbMap.setModel(getMaps());
		pMap.add(cbMap);
		
		lbMap = new JLabel("");
		lbMap.setVerticalAlignment(SwingConstants.TOP);
		lbMap.setBounds(0, 0, pMap.getWidth(), pMap.getHeight());
		Image I = new ImageIcon("WarbornData/images/" + cbMap.getSelectedItem() + ".jpg").getImage();
		I = I.getScaledInstance(pMap.getWidth(), -1, 0);
		lbMap.setIcon(new ImageIcon(I));
		pMap.add(lbMap);

		cbMap.setLocation((pMap.getWidth()/2) - (cbMap.getWidth()/2), I.getHeight(null) + 30);
		
		btStartGame = new JButton("Start Game");
		btStartGame.setLocation(pMap.getWidth()-200, pMap.getHeight()-200);
		btStartGame.setSize(150, 150);
		pMap.add(btStartGame);
	}
	
	private ComboBoxModel getMaps() {
		DefaultComboBoxModel boxModel = new DefaultComboBoxModel();
		String[] mapNames = MapData.getMapNames();
		for(int i = 0; i < mapNames.length; i++){
			boxModel.addElement(mapNames[i]);
		}
		return boxModel;
	}

	public JButton getStartButton(){
		return btStartGame;
	}
	
	public JButton getAddPlayerButton(){
		return btAddPlayer;
	}
	
	public JComboBox getMapComboBox(){
		return cbMap;
	}
	
	public JButton[] getColorButtons(){
		JButton[] btColors = new JButton[pPlayer.getComponentCount()];
		for(int i = 0; i < pPlayer.getComponentCount(); i++){
			btColors[i] = ((PlayerSelectionPanel)(pPlayer.getComponent(i))).getColorButton();
		}
		return btColors;
	}

	public String[] getNames(){
		String[] names = new String[pPlayer.getComponentCount()];
		for(int i = 0; i < pPlayer.getComponentCount(); i++){
			names[i] = ((PlayerSelectionPanel)(pPlayer.getComponent(i))).getPlayerName();
		}
		return names;
	}
	
	public Color[] getColors(){
		Color[] colors = new Color[pPlayer.getComponentCount()];
		for(int i = 0; i < pPlayer.getComponentCount(); i++){
			colors[i] = ((PlayerSelectionPanel)(pPlayer.getComponent(i))).getPlayerColor();
		}
		return colors;
	}
	
	public int[] getRaces(){
		int[] races = new int[pPlayer.getComponentCount()];
		for(int i = 0; i < pPlayer.getComponentCount(); i++){
			races[i] = ((PlayerSelectionPanel)(pPlayer.getComponent(i))).getPlayerRace();
		}
		return races;
	}
	
	public int[] getBackgrounds(){
		int[] backgrounds = new int[pPlayer.getComponentCount()];
		for(int i = 0; i < pPlayer.getComponentCount(); i++){
			backgrounds[i] = ((PlayerSelectionPanel)(pPlayer.getComponent(i))).getPlayerBackground();
		}
		return backgrounds;
	}
	
	public int getSelectedMapIndex(){
		return cbMap.getSelectedIndex();
	}
	
	public void updateMap(){
		Image I = new ImageIcon("WarbornData/images/" + cbMap.getSelectedItem() + ".jpg").getImage();
		I = I.getScaledInstance(pMap.getWidth(), -1, 0);
		lbMap.setIcon(new ImageIcon(I));
		pMap.revalidate();
	}
	
	public void addPlayer(){
		if(pPlayer.getComponentCount() < 4){
			pPlayer.add(new PlayerSelectionPanel(model, pPlayer.getComponentCount()+1));
			pPlayer.revalidate();
		}
	}
	
}
