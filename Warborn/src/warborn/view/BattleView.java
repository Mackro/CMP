package warborn.view;

import java.awt.Font;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import warborn.model.Battle;
import warborn.model.Warborn;
import warborn.model.Territory;

public class BattleView extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	private JButton[] buttons;
	private JButton btOneAttack, btAutoAttack, btRetreat;
	private Territory t1, t2;
	private JFrame frame;
	private JLabel lbAttacker, lbDefender, lbAtkTroops, lbDefTroops, lbBattle;
	private JTextArea taBattleLog;
	/**
	 * Create the panel.
	 */
	public BattleView(JFrame frame){
		
		this.frame = frame;
		
		//setSize(535,331);
		setSize(451, 300);
		setLayout(null);
		
		lbBattle = new GenericLabel("Battle!");
		lbBattle.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 40));
		lbBattle.setBounds(132, 0, 242, 70);
		add(lbBattle);

		buttons = new JButton[3];
		
		btOneAttack = new GenericButton("One Attack");
		btOneAttack.setBounds(10, 219, 162, 70);
		add(btOneAttack);
		buttons[0] = btOneAttack;
		
		btAutoAttack = new GenericButton("Auto Attack");
		btAutoAttack.setBounds(179, 219, 162, 70);
		add(btAutoAttack);
		buttons[1] = btAutoAttack;
		
		btRetreat = new GenericButton("Retreat");
		btRetreat.setBounds(347, 219, 162, 70);
		add(btRetreat);
		buttons[2] = btRetreat;
		
		lbAttacker = new GenericLabel("Attacker");
		lbAttacker.setBounds(10, 57, 242, 24);
		add(lbAttacker);
		
		lbDefender = new GenericLabel("Defender");
		lbDefender.setBounds(262, 57, 247, 24);
		add(lbDefender);
		
		lbAtkTroops = new GenericLabel("atkTroops");
		lbAtkTroops.setBounds(10, 92, 124, 24);
		add(lbAtkTroops);
		
		lbDefTroops = new GenericLabel("defTroops");
		lbDefTroops.setBounds(385, 92, 124, 24);
		add(lbDefTroops);
		
		taBattleLog = new JTextArea();
		taBattleLog.setEditable(false);
		taBattleLog.setBounds(10, 127, 499, 81);
		add(taBattleLog);
	}
	
	public JButton[] getButtons(){
		return buttons;
	}
	
	public String getHeaderText(){
		return lbBattle.getText();
	}
	
	public void logClean(){
		taBattleLog.setText(null);
	}
	
	public void logUpdate(Point p){
		if(taBattleLog.getText().equals("")){
			taBattleLog.setText(t1.getOwner().getName() + " loses " + (int)p.getX() + " troops and " + t2.getOwner().getName() + " loses " + (int)p.getY() + " troops");
		}
		else{
			taBattleLog.setText(taBattleLog.getText() + "\n" + t1.getOwner().getName() + " loses " + (int)p.getX() + " troops and " + t2.getOwner().getName() + " loses " + (int)p.getY() + " troops");
		}
	}
	
	@Override
	public void update(Observable ml, Object e) {
		Warborn model = (Warborn)ml;
		
		if(model.getState() == 2 && model.getPhase() == 1){
			frame.getLayeredPane().add(this, JLayeredPane.MODAL_LAYER);
			//frame.repaint();
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
			this.setLocation((int)((model.getWidth()/2) - (this.getWidth()/2)), (int)((model.getHeight()*0.7)/2) - (this.getHeight()/2));
			if(t1.getNbrOfUnits() == 1 || t2.getNbrOfUnits() == 0){
				btOneAttack.setVisible(false);
				btAutoAttack.setVisible(false);
				btRetreat.setText("Continue");
				if(t1.getNbrOfUnits() == 1){
					lbBattle.setText("Defeat!");
				}
				else{
					lbBattle.setText("Victory!");
				}
			}
		}
	}
}
