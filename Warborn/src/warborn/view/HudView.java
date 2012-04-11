package warborn.view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import warborn.model.Warborn;
import javax.swing.*;

public class HudView extends JPanel implements Observer{
	
	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private JButton[] buttons;
	private JButton next, useCards;
	private JLabel currentPlayer, territoryData, currentState;
	private JButton[] cardPanelbtns;
	//private JLabel[] PlayerStats;
	private JLabel reinforcements;
	
	public HudView(Warborn model){

		setLayout(null);
		setSize(model.getWidth(),(int)(model.getWidth()*0.25));
		setLocation(0, 0);
		
		buttons = new JButton[2];
		
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
		reinforcements.setBounds((int)(this.getWidth()*0.45), (int)(this.getHeight()*0.1), 400, 20);
		add(reinforcements);
		
		currentPlayer = new JLabel();
		currentPlayer.setBounds((int)(this.getWidth()*0.45), (int)(this.getHeight()*0.2), 400, 20);
		add(currentPlayer);
		
		currentState = new JLabel();
		currentState.setBounds((int)(this.getWidth()*0.45), (int)(this.getHeight()*0.3), 400, 20);
		add(currentState);
		
		cardPanel = new JPanel();
		cardPanel.setLayout(new GridLayout());
		cardPanel.setBounds(0, 0, (int)(this.getWidth()*0.25),(int)(model.getHeight()/9.6));
		add(cardPanel);
		
		cardPanelbtns = new JButton[5];
		for (int i=0; i<cardPanelbtns.length; i++){
			cardPanelbtns[i] = new JButton();
			cardPanel.add(cardPanelbtns[i]);
		}
		territoryData = new JLabel();
		
		
		setVisible(true);
	}
	
	public JButton[] getButtons(){
		return buttons;
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
		useCards.setEnabled(false);
		if (model.getState() == 3){
			next.setText("End Turn");
			currentState.setText("Troop Movement");
		}else{
			next.setText("next");
		}
		if (model.getState()==1){
			if (model.getCurrentPlayer().canExchangeCards()){
				useCards.setEnabled(true);
			}
			reinforcements.setText("Reinforcements: " + model.getNbrOfReinforcements());
			reinforcements.setVisible(true);
			currentState.setText("Reinforce your Troops");
			//TODO display "troops" in a fitting fashion
		}
		if (model.getNbrOfReinforcements() != 0){
			next.setEnabled(false);
		}
		else{
			next.setEnabled(true);
		}
	
		
	}
}
