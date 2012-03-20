package warborn.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class BattleView extends Observable implements ActionListener {
	private int buttonPressed;
	private JButton btOneAttack;
	private JButton btAutoAttack;
	private JButton btRetreat;
	/**
	 * Create the panel.
	 */
	public BattleView() {
		JPanel battleView = new JPanel();
		battleView.setSize(451, 300);
		battleView.setLayout(null);
		
		JLabel lbBattle = new JLabel("Battle!");
		lbBattle.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 40));
		lbBattle.setBounds(140, 11, 195, 70);
		battleView.add(lbBattle);
		
		btOneAttack = new JButton("One Attack");
		btOneAttack.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		btOneAttack.setBounds(10, 219, 142, 70);
		btOneAttack.addActionListener(this);
		battleView.add(btOneAttack);
		
		btAutoAttack = new JButton("Auto Attack");
		btAutoAttack.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		btAutoAttack.setBounds(154, 219, 142, 70);
		btAutoAttack.addActionListener(this);
		battleView.add(btAutoAttack);
		
		btRetreat = new JButton("Retreat");
		btRetreat.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		btRetreat.setBounds(298, 219, 142, 70);
		btRetreat.addActionListener(this);
		battleView.add(btRetreat);
		
		JLabel lbAttacker = new JLabel("Attacker");
		lbAttacker.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbAttacker.setBounds(10, 57, 95, 24);
		battleView.add(lbAttacker);
		
		JLabel lbDefender = new JLabel("Defender");
		lbDefender.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbDefender.setBounds(345, 57, 95, 24);
		battleView.add(lbDefender);
		
		JLabel lbatkTroops = new JLabel("atkTroops");
		lbatkTroops.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbatkTroops.setBounds(10, 92, 124, 24);
		battleView.add(lbatkTroops);
		
		JLabel lbdefTroops = new JLabel("defTroops");
		lbdefTroops.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbdefTroops.setBounds(316, 92, 124, 24);
		battleView.add(lbdefTroops);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 127, 430, 81);
		battleView.add(textArea);

	}
	public int getButtonPressed(){
		return buttonPressed;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btOneAttack){
			buttonPressed = 1;
		}
		if(e.getSource() == btAutoAttack){
			buttonPressed = 2;
		}
		if(e.getSource() == btRetreat){
			
		}
		notifyObservers(buttonPressed);
	}
}
