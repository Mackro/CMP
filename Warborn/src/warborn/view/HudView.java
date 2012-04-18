package warborn.view;

import java.awt.*;
import java.util.*;

import warborn.SupportClasses.*;
import warborn.model.Warborn;

import javax.swing.*;
import javax.swing.border.*;

public class HudView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JPanel phaseInfo;
	private JPanel playersPanel;
	private JPanel[] playerPanelsArray;
	private GenericLabel[] playerNameArray;
	private GenericLabel[] territoriesArray;
	private GenericLabel[] troopsArray;
	private GenericLabel[] manaArray;
	private JButton[] buttons;
	private JButton next, useCards, spellbookButton;
	private GenericLabel currentPlayer, currentState;
	private JButton[] cardPanelbtns;
	private GenericLabel reinforcements;
	private Warborn model;
	private Border innerBorder, border;
	
	public HudView(Warborn model){
		
		this.model = model;
		playerPanelsArray = new JPanel[model.getNumberOfPlayers()];
		playerNameArray = new GenericLabel[model.getNumberOfPlayers()];
		territoriesArray = new GenericLabel[model.getNumberOfPlayers()];
		troopsArray = new GenericLabel[model.getNumberOfPlayers()];
		manaArray = new GenericLabel[model.getNumberOfPlayers()];
		cardPanelbtns = new JButton[5];
		border = new RoundedBorder(3);
		innerBorder = new LineBorder(Color.gray);
		
		this.setLayout(null);
		this.setSize(model.getWidth(),model.getHeight()/4);
		this.setLocation(0, 0);
		
		phaseInfo = new JPanel();
		phaseInfo.setBounds((int)(this.getWidth()*0.25),(int)(this.getHeight()*0.03),
				(int)(this.getWidth()/7),(int)(this.getHeight()*0.9));
		phaseInfo.setLayout(null);
		phaseInfo.setBorder(border);
		this.add(phaseInfo);
		
		playersPanel = new JPanel();
		playersPanel.setLayout(new GridLayout(1, model.getNumberOfPlayers()));
		playersPanel.setBounds((int)((this.getWidth()*0.25)+((int)(this.getWidth()/7))), 
				(int)(this.getHeight()*0.03),
				(int)((this.getWidth()-(this.getWidth()*0.25)-(this.getWidth()/7)-(this.getWidth()/14))),
				(int)(this.getHeight()*0.9));
		playersPanel.setBorder(border);
		this.add(playersPanel);
		
		
		cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout());
		cardPanel.setBounds(0, (int)(this.getHeight()*0.03), (int)(this.getWidth()*0.25),(int)(this.getHeight()*0.45));
		cardPanel.setBorder(border);
		this.add(cardPanel);
		
		
		buttons = new JButton[3];
		
		for(int i = 0; i < cardPanelbtns.length; i++){
			cardPanelbtns[i] = new JButton();
			cardPanel.add(cardPanelbtns[i]);
		}
		
		next = new JButton("Next");
		next.setBounds((int)((this.getWidth())-this.getWidth()/14),
				(int)(this.getHeight()*0.4),
				(int)(this.getWidth()/14),
				(int)(this.getHeight()/5));
		this.add(next);
		buttons[0] = next;
		
		useCards = new JButton("Souls");
		useCards.setBounds((int)((this.getWidth()*0.125)-(this.getWidth()/(2*13))), 
				(int)(this.getHeight()*0.5),
				(int)(this.getWidth()/13),
				(int)(this.getHeight()/10));
		this.add(useCards);
		buttons[1] = useCards;
		
		spellbookButton = new JButton("Spellbook");
		spellbookButton.setBounds((int)((this.getWidth()*0.125)-(this.getWidth()/(2*10))), 
				(int)(this.getHeight()*0.7),
				(int)(this.getWidth()/10),
				(int)(this.getHeight()/10));
		this.add(spellbookButton);
		buttons[2] = spellbookButton;
		
		for (int i=0; i<buttons.length; i++){
			buttons[i].setBorder(border);
		}
		
		currentPlayer = new GenericLabel();
		currentPlayer.setBounds(0, (int)(this.getHeight()*0.2), 400, 20);
		phaseInfo.add(currentPlayer);
		
		currentState = new GenericLabel();
		currentState.setBounds(0, (int)(this.getHeight()*0.4), 400, 20);
		phaseInfo.add(currentState);
		
		reinforcements = new GenericLabel("Reinforcements");
		reinforcements.setBounds((0), (int)(this.getHeight()*0.6), 400, 20);
		phaseInfo.add(reinforcements);
		

		for(int i = 0; i <model.getNumberOfPlayers(); i++){
			
			playerPanelsArray[i] = new JPanel();
			playerPanelsArray[i].setLayout(new GridLayout(4, 1));
			playerPanelsArray[i].setSize((int)(playersPanel.getWidth()/model.getNumberOfPlayers()), playersPanel.getHeight());
			playerPanelsArray[i].setBorder(innerBorder);
					
			playerNameArray[i] = new GenericLabel();
			playerNameArray[i].setForeground(model.getPlayer(i).getColor());
			playerNameArray[i].setLocation(0, 0);
			playerPanelsArray[i].add(playerNameArray[i]);
			
			territoriesArray[i] = new GenericLabel();
			territoriesArray[i].setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.2));
			playerPanelsArray[i].add(territoriesArray[i]);
			
			troopsArray[i] = new GenericLabel();
			troopsArray[i].setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.4));
			playerPanelsArray[i].add(troopsArray[i]);
			
			manaArray[i] = new GenericLabel();
			manaArray[i].setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.6));
			playerPanelsArray[i].add(manaArray[i]);
			
			playersPanel.add(playerPanelsArray[i], i);
			playersPanel.validate();			
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
		
		currentPlayer.setText(" "+model.getCurrentPlayer().getName());
		currentState.setText(" Battle Phase");
		float[] hsbFloats = {0,0,0};
		Color.RGBtoHSB(model.getCurrentPlayer().getColor().brighter().getRed(),
				model.getCurrentPlayer().getColor().brighter().getGreen(),
				model.getCurrentPlayer().getColor().brighter().getBlue(), hsbFloats);
		this.setBackground(Color.getHSBColor(hsbFloats[0],hsbFloats[1]/3,hsbFloats[2]+((1-hsbFloats[2])/2)));
		reinforcements.setVisible(false);
		for (int i=0; i<cardPanelbtns.length; i++){
			if (model.getCurrentPlayer().getCards()[i]!=null){
				cardPanelbtns[i].setIcon(model.getCurrentPlayer().getCard(i).getImage());
			}
		}
		playersPanel.revalidate();
		
		if (model.getCurrentPlayer().canExchangeCards()){
			useCards.setEnabled(true);
		}else{
			useCards.setEnabled(false);
		}
		
		if (model.getState() == 3){
			next.setText("End Turn");
			currentState.setText(" Troop Movement");
		}else{
			next.setText("Next Phase");
		}
		
		if (model.getState()==1){
			
			reinforcements.setText(" Reinforcements: " + model.getNbrOfReinforcements());
			reinforcements.setVisible(true);
			currentState.setText(" Reinforce your Troops");
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
