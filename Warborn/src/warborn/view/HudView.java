package warborn.view;

import java.awt.*;
import java.util.*;
import warborn.model.Warborn;
import javax.swing.*;
import javax.swing.border.*;

public class HudView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JPanel phaseInfo;
	private JPanel playerPanel;
	private JPanel[] playerPanelsArray;
	private JLabel[] playerNameArray;
	private JLabel[] territoriesArray;
	private JLabel[] troopsArray;
	private JLabel[] manaArray;
	private JButton[] buttons;
	private JButton next, useCards;
	private JLabel currentPlayer, currentState;
	private JButton[] cardPanelbtns;
	private JLabel reinforcements;
	private Warborn model;
	
	public HudView(Warborn model){
		
		this.model = model;
		playerPanelsArray = new JPanel[model.getNumberOfPlayers()];
		playerNameArray = new JLabel[model.getNumberOfPlayers()];
		territoriesArray = new JLabel[model.getNumberOfPlayers()];
		troopsArray = new JLabel[model.getNumberOfPlayers()];
		manaArray = new JLabel[model.getNumberOfPlayers()];
		cardPanelbtns = new JButton[5];
		
		this.setLayout(null);
		this.setSize(model.getWidth(),model.getHeight()/4);
		this.setLocation(0, 0);
		
		phaseInfo = new JPanel();
		phaseInfo.setBounds((int)(this.getWidth()*0.25),0,(int)(this.getWidth()/7),this.getHeight());
		phaseInfo.setLayout(null);
		phaseInfo.setBorder(new BevelBorder(1));
		this.add(phaseInfo);
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(1, model.getNumberOfPlayers()));
		playerPanel.setBounds((int)((this.getWidth()*0.25)+((int)(this.getWidth()/7))), 0,
				(int)((this.getWidth()-(this.getWidth()*0.25)-(this.getWidth()/7)-(this.getWidth()/13.66))),
				this.getHeight());
		this.add(playerPanel);
		
		
		cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout());
		cardPanel.setBounds(0, 0, (int)(this.getWidth()*0.25),(int)(model.getHeight()/9.6));
		cardPanel.setBorder(new BevelBorder(1));
		this.add(cardPanel);
		
		
		buttons = new JButton[2];
		
		for(int i = 0; i < cardPanelbtns.length; i++){
			cardPanelbtns[i] = new JButton();
			cardPanel.add(cardPanelbtns[i]);
		}
		
		next = new JButton("Next");
		next.setBounds((int)((this.getWidth())-this.getWidth()/13.66),
				(int)(this.getHeight()*0.4),
				(int)(this.getWidth()/13.66),
				(int)(this.getHeight()/9));
		this.add(next);
		buttons[0] = next;
		
		useCards = new JButton("Souls");
		useCards.setBounds((int)((this.getWidth()*0.125)-(this.getWidth()/(2*13.66))), 
				(int)(this.getHeight()*0.5),
				(int)(this.getWidth()/13.66),
				(int)(this.getHeight()/10));
		this.add(useCards);
		buttons[1] = useCards;
		
		reinforcements = new JLabel("Reinforcements");
		reinforcements.setBounds((0), (int)(this.getHeight()*0.01), 400, 20);
		phaseInfo.add(reinforcements);
		
		currentPlayer = new JLabel();
		currentPlayer.setBounds(0, (int)(this.getHeight()*0.08), 400, 20);
		phaseInfo.add(currentPlayer);
		
		currentState = new JLabel();
		currentState.setBounds(0, (int)(this.getHeight()*0.15), 400, 20);
		phaseInfo.add(currentState);
		

		for(int i = 0; i <model.getNumberOfPlayers(); i++){
			
			playerPanelsArray[i] = new JPanel();
			playerPanelsArray[i].setLayout(new GridLayout(4, 1));
			playerPanelsArray[i].setSize((int)(playerPanel.getWidth()/model.getNumberOfPlayers()), playerPanel.getHeight());
			
			playerNameArray[i] = new JLabel();
			playerNameArray[i].setForeground(model.getPlayer(i).getColor());
			playerNameArray[i].setLocation(0, 0);
			playerPanelsArray[i].add(playerNameArray[i]);
			
			territoriesArray[i] = new JLabel();
			territoriesArray[i].setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.2));
			playerPanelsArray[i].add(territoriesArray[i]);
			
			troopsArray[i] = new JLabel();
			troopsArray[i].setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.4));
			playerPanelsArray[i].add(troopsArray[i]);
			
			manaArray[i] = new JLabel();
			manaArray[i].setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.6));
			playerPanelsArray[i].add(manaArray[i]);
			
			playerPanel.add(playerPanelsArray[i], i);
			playerPanel.validate();			
		}
		
		
		this.setVisible(true);
	}
	
	public JButton[] getButtons(){
		return buttons;
	}
	
	public int calculateNbrOfUnits(int playerIndex){
		int nbrOfUnits = 0;
		for(int i = 0; i < model.getTerritories().length; i++){
			if(model.getTerritory(i).getOwner() == model.getPlayer(playerIndex)){
				nbrOfUnits += model.getTerritory(i).getNbrOfUnits();
			}
		}
			
		return nbrOfUnits;
	}
	
	@Override
	public void update(Observable ml, Object e) {
		Warborn model = (Warborn)ml;
		
		currentPlayer.setText(model.getCurrentPlayer().getName());
		currentState.setText("Battle Phase");
		float[] hsbFloats = {0,0,0};
		Color.RGBtoHSB(model.getCurrentPlayer().getColor().brighter().getRed(),
				model.getCurrentPlayer().getColor().brighter().getGreen(),
				model.getCurrentPlayer().getColor().brighter().getBlue(), hsbFloats);
		this.setBackground(Color.getHSBColor(hsbFloats[0],hsbFloats[1]/4,hsbFloats[2]+((1-hsbFloats[2])/2)));
		reinforcements.setVisible(false);
		for (int i=0; i<cardPanelbtns.length; i++){
			if (model.getCurrentPlayer().getCards()[i]!=null){
				cardPanelbtns[i].setIcon(model.getCurrentPlayer().getCard(i).getImage());
			}
		}
		playerPanel.revalidate();
		
		if (model.getCurrentPlayer().canExchangeCards()){
			useCards.setEnabled(true);
		}else{
			useCards.setEnabled(false);
		}
		
		if (model.getState() == 3){
			next.setText("End Turn");
			currentState.setText("Troop Movement");
		}else{
			next.setText("Next Phase");
		}
		
		if (model.getState()==1){
			
			reinforcements.setText("Reinforcements: " + model.getNbrOfReinforcements());
			reinforcements.setVisible(true);
			currentState.setText("Reinforce your Troops");
		}
		
		if (model.getNbrOfReinforcements() != 0){
			next.setEnabled(false);
		}else{
			next.setEnabled(true);
		}
		
		for (int i = 0; i < model.getNumberOfPlayers(); i++){
			playerNameArray[i].setText(model.getPlayer(i).getName());
			territoriesArray[i].setText("Number of Territories:  " + model.getPlayer(i).getNbrOfTerritories());
			troopsArray[i].setText("Number of Troups:  " + calculateNbrOfUnits(i));
			manaArray[i].setText("Mana:  " + model.getPlayer(i).getMana());
		}
	
		
	}
}
