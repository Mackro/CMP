package warborn.view;

import java.util.Observable;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JButton;

import warborn.model.Territory;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoveView extends Observable implements ActionListener {
	
	private JButton btMove;
	private JButton btCancel;
	private JPanel moveView;
	private JSlider slider;
	private Territory t1, t2;

	/**
	 * Create the panel.
	 */
	public MoveView(Territory t1, Territory t2){
		moveView = new JPanel();
		moveView.setLayout(null);
		this.t1 = t1;
		this.t2 = t2;
		
		slider = new JSlider();
		slider.setMinimum(1);
		slider.setMaximum(t1.getNbrOfUnits()-1);
		slider.setBounds(122, 91, 200, 23);
		moveView.add(slider);
		
		JLabel lbT1Name = new JLabel(t1.getName());
		lbT1Name.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT1Name.setBounds(27, 63, 98, 14);
		moveView.add(lbT1Name);
		
		JLabel lbT2Name = new JLabel(t2.getName());
		lbT2Name.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT2Name.setBounds(317, 63, 112, 14);
		moveView.add(lbT2Name);
		
		JLabel lbT1Troops = new JLabel(t1.getNbrOfUnits() - slider.getValue() + "");
		lbT1Troops.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 16));
		lbT1Troops.setBounds(27, 100, 85, 14);
		moveView.add(lbT1Troops);
		
		JLabel lbT2Troops = new JLabel(t2.getNbrOfUnits() + slider.getValue() + "");
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
			
		}
		if(e.getSource() == btMove){
			t1.setNbrOfUnits(t1.getNbrOfUnits() - slider.getValue());
			t2.setNbrOfUnits(t2.getNbrOfUnits() + slider.getValue());
			notifyAll();
		}
	}
}
