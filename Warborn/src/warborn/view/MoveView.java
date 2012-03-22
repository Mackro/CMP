package warborn.view;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import warborn.model.Model;
import warborn.model.Move;
import warborn.model.Territory;

public class MoveView implements ActionListener, Observer {
	
	private JButton btMove, btCancel;
	private JPanel moveView;
	private JSlider slider;
	private Territory t1, t2;
	private JFrame moveFrame;
	private JLabel lbT1Name, lbT2Name, lbT1Troops, lbT2Troops;
	private Model model;

	/**
	 * Create the panel.
	 */
	public MoveView(Model model){
		this.model = model;
		this.model.addObserver(this);
		
		moveFrame = new JFrame();
		moveFrame.setUndecorated(true);
		moveFrame.setVisible(false);
		
		moveView = new JPanel();
		moveView.setLayout(null);
		moveFrame.add(moveView);
		
		slider = new JSlider();
		slider.setMinimum(1);
		slider.setBounds(122, 91, 200, 23);
		moveView.add(slider);
		
		lbT1Name = new JLabel("");
		lbT1Name.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT1Name.setBounds(27, 63, 98, 14);
		moveView.add(lbT1Name);
		
		lbT2Name = new JLabel("");
		lbT2Name.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT2Name.setBounds(317, 63, 112, 14);
		moveView.add(lbT2Name);
		
		lbT1Troops = new JLabel("");
		lbT1Troops.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT1Troops.setBounds(27, 100, 85, 14);
		moveView.add(lbT1Troops);
		
		lbT2Troops = new JLabel("");
		lbT2Troops.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT2Troops.setBounds(346, 100, 83, 14);
		moveView.add(lbT2Troops);
		
		JLabel lbTop = new JLabel("Move");
		lbTop.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 40));
		lbTop.setBounds(167, 11, 124, 47);
		moveView.add(lbTop);
		
		btCancel = new JButton("Cancel");
		btCancel.setBounds(55, 139, 89, 23);
		btCancel.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		btCancel.addActionListener(this);
		moveView.add(btCancel);
		
		btMove = new JButton("Move");
		btMove.setBounds(303, 139, 89, 23);
		btMove.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 14));
		btMove.addActionListener(this);
		moveView.add(btMove);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCancel){
			moveFrame.setVisible(false);
		}
		if(e.getSource() == btMove){
			model.getMove().moveUnits(slider.getValue());
			moveFrame.setVisible(false);
		}
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if(model.getState() == 3 && model.getPhase() == 1){
			Move move = model.getMove();
			t1 = move.getFirstTerritory();
			t2 = move.getSecondTerritory();
			lbT1Name.setText(t1.getName());
			lbT2Name.setText(t2.getName());
			slider.setMaximum(t1.getNbrOfUnits()-1);
			lbT1Troops.setText(t1.getNbrOfUnits() - slider.getValue() + "");
			lbT2Troops.setText(t2.getNbrOfUnits() + slider.getValue() + "");
		}
	}
}
