package warborn.view;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import warborn.SupportClasses.GenericButton;
import warborn.model.Battle;
import warborn.model.LabelFactory;
import warborn.model.Warborn;
import warborn.model.Territory;

public class BattleView implements Observer {

	private JButton[] buttons;
	private JButton btOneAttack, btAutoAttack, btRetreat;
	private JFrame battleFrame;
	//private Warborn model;
	private Territory t1, t2;
	private JLabel lbAttacker, lbDefender, lbAtkTroops, lbDefTroops, lbBattle;
	private JTextArea taBattleLog;
	/**
	 * Create the panel.
	 */
	public BattleView(){	//Warborn model) {
	//	this.model = model;
	//	this.model.addObserver(this);
		
		battleFrame = new JFrame();
		battleFrame.setSize(535,331);
		JPanel battleView = new JPanel();
		battleView.setSize(451, 300);
		battleView.setLayout(null);
		battleFrame.getContentPane().add(battleView);
		battleFrame.setVisible(false);
		
		lbBattle = LabelFactory.makeLabel("Battle!");
		lbBattle.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 40));
		lbBattle.setBounds(132, 0, 242, 70);
		battleView.add(lbBattle);

		buttons = new JButton[3];
		
		btOneAttack = new GenericButton("One Attack");
		btOneAttack.setBounds(10, 219, 162, 70);
		battleView.add(btOneAttack);
		buttons[0] = btOneAttack;
		
		btAutoAttack = new GenericButton("Auto Attack");
		btAutoAttack.setBounds(179, 219, 162, 70);
		battleView.add(btAutoAttack);
		buttons[1] = btAutoAttack;
		
		btRetreat = new GenericButton("Retreat");
		btRetreat.setBounds(347, 219, 162, 70);
		battleView.add(btRetreat);
		buttons[2] = btRetreat;
		
		lbAttacker = LabelFactory.makeLabel("Attacker");
		lbAttacker.setBounds(10, 57, 242, 24);
		battleView.add(lbAttacker);
		
		lbDefender = LabelFactory.makeLabel("Defender");
		lbDefender.setBounds(262, 57, 247, 24);
		battleView.add(lbDefender);
		
		lbAtkTroops = LabelFactory.makeLabel("atkTroops");
		lbAtkTroops.setBounds(10, 92, 124, 24);
		battleView.add(lbAtkTroops);
		
		lbDefTroops = LabelFactory.makeLabel("defTroops");
		lbDefTroops.setBounds(385, 92, 124, 24);
		battleView.add(lbDefTroops);
		
		taBattleLog = new JTextArea();
		taBattleLog.setEditable(false);
		taBattleLog.setBounds(10, 127, 499, 81);
		battleView.add(taBattleLog);
		
		battleFrame.setUndecorated(true);

	}
	
	public JButton[] getButtons(){
		return buttons;
	}
	public JFrame getFrame(){
		return battleFrame;
	}
	
	@Override
	public void update(Observable ml, Object e) {
		Warborn model = (Warborn)ml;
		
		if(model.getState() == 2 && model.getPhase() == 1){
			battleFrame.setVisible(true);
			Battle battle = model.getBattle();
			t1 = battle.getFirstTerritory();
			t2 = battle.getSecondTerritory();
			lbBattle.setText("Battle!");
			btOneAttack.setVisible(true);
			btAutoAttack.setVisible(true);
			btRetreat.setText("Retreat");
			lbAttacker.setText(t1.getName());
			lbDefender.setText(t2.getName());
			lbAtkTroops.setText(t1.getNbrOfUnits() - 1 + "");
			lbDefTroops.setText(t2.getNbrOfUnits() + "");
			battleFrame.setLocation((int)((model.getWidth()/2) - (battleFrame.getWidth()/2)), (int)((model.getHeight()*0.7)/2) - (battleFrame.getHeight()/2));
			if(t1.getNbrOfUnits() == 0 || t2.getNbrOfUnits() == 0){
				btOneAttack.setVisible(false);
				btAutoAttack.setVisible(false);
				btRetreat.setText("Continue");
				if(t1.getNbrOfUnits() == 0){
					lbBattle.setText("Defeat!");
				}
				else{
					lbBattle.setText("Victory!");
				}
			}
		}
	}
}
