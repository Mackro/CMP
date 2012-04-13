package warborn.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import warborn.model.Warborn;
import javax.swing.*;

import com.sun.xml.internal.bind.v2.model.impl.ModelBuilder;

public class HudView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JPanel phaseInfo;
	private JPanel playerPanel;
	private JPanel[] playerPanelsArray;
	private JLabel playerName;
	private JLabel territories;
	private JLabel troops;
	private JLabel mana;
	
	private JButton[] buttons;
	private JButton next, useCards;
	private JLabel currentPlayer, currentState;
	private JButton[] cardPanelbtns;
	//private JLabel[] PlayerStats;
	private JLabel reinforcements;
	private Warborn model;
	
	public HudView(Warborn model){
		
		this.model = model;
		playerPanelsArray = new JPanel[model.getNumberOfPlayers()];
		cardPanelbtns = new JButton[5];
		
		setLayout(null);
		setSize(1359,356);
		setLocation(0, 0);
		
		phaseInfo = new JPanel();
		phaseInfo.setBounds((int)(this.getWidth()*0.25),0,(int)(this.getWidth()/3.4),this.getHeight());
		phaseInfo.setLayout(null);
		add(phaseInfo);
		
		playerPanel = new JPanel();
		playerPanel.setLayout(new GridLayout(1, model.getNumberOfPlayers()));
		playerPanel.setBounds((int)((this.getWidth()*0.25)+((int)(this.getWidth()/3.4))), 0,
				(int)((this.getWidth()-(this.getWidth()*0.25)-(this.getWidth()/3.41)-(this.getWidth()/13.66))),this.getHeight());
		add(playerPanel);
		
		
		cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout());
		cardPanel.setBounds(0, 0, (int)(this.getWidth()*0.25),(int)(model.getHeight()/9.6));
		add(cardPanel);
		
		
		buttons = new JButton[2];
		
		for(int i = 0; i<cardPanelbtns.length; i++){
			cardPanelbtns[i] = new JButton();
			cardPanel.add(cardPanelbtns[i]);
		}
		
		next = new JButton("Next");
		next.setBounds((int)((this.getWidth())-this.getWidth()/13.66),
				(int)(this.getHeight()*0.25),
				(int)(this.getWidth()/13.66),
				(int)(this.getHeight()/11.8));
		add(next);
		buttons[0] = next;
		
		useCards = new JButton("Souls");
		useCards.setBounds((int)((this.getWidth()*0.125)-(this.getWidth()/(2*13.66))), 
				(int)(this.getHeight()*0.32),
				(int)(this.getWidth()/13.66),
				(int)(this.getHeight()/10));
		add(useCards);
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
			playerPanelsArray[i].setLayout(null);
			playerPanelsArray[i].setSize((int)(playerPanel.getWidth()/model.getNumberOfPlayers()),playerPanel.getHeight()  );
			
			playerName = new JLabel("1");
			playerName.setForeground(model.getPlayer(i).getColor());
			playerName.setLocation(0, 0);
			playerPanelsArray[i].add(playerName);
			
			territories = new JLabel("2");
			territories.setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.2));
			playerPanelsArray[i].add(territories);
			
			troops = new JLabel("3");
			troops.setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.4));
			playerPanelsArray[i].add(troops);
			
			
			mana = new JLabel("4");
			mana.setLocation(0, (int)(playerPanelsArray[i].getHeight()*0.6));
			playerPanelsArray[i].add(mana);
			
			playerPanel.add(playerPanelsArray[i]);
		}
		
		
		
		setVisible(true);
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
		reinforcements.setVisible(false);
		for (int i=0; i<cardPanelbtns.length; i++){
			if (model.getCurrentPlayer().getCards()[i]!=null){
				cardPanelbtns[i].setIcon(model.getCurrentPlayer().getCard(i).getImage());
			}
		}
		
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
			playerName.setText(model.getPlayer(i).getName());
			territories.setText("Number of Territories:  " + model.getPlayer(i).getNbrOfTerritories() + "");
			troops.setText("Number of Troups:  " + calculateNbrOfUnits(i) + "");
			mana.setText("Mana:  " + model.getPlayer(i).getMana());
		}
	
		
	}
}
