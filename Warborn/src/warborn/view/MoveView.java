package warborn.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import warborn.model.ButtonFactory;
import warborn.model.LabelFactory;
import warborn.model.Warborn;
import warborn.model.Move;
import warborn.model.Territory;

public class MoveView extends Observable implements ActionListener, Observer {
	
	public JButton btMove;
	public JButton btCancel;
	private JPanel moveView;
	public JSlider slider;
	private Territory t1, t2;
	public JFrame moveFrame;
	private JLabel lbT1Name, lbT2Name, lbT1Troops, lbT2Troops;
	private Warborn model;

	/**
	 * Create the panel.
	 */
	public MoveView(Warborn model){
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
		
		lbT1Name = new LabelFactory("");
		lbT1Name.setBounds(27, 63, 98, 14);
		moveView.add(lbT1Name);
		
		lbT2Name = new LabelFactory("");
		lbT2Name.setBounds(317, 63, 112, 14);
		moveView.add(lbT2Name);
		
		lbT1Troops = new LabelFactory("");
		lbT1Troops.setBounds(27, 100, 85, 14);
		moveView.add(lbT1Troops);
		
		lbT2Troops = new LabelFactory("");
		lbT2Troops.setBounds(346, 100, 83, 14);
		moveView.add(lbT2Troops);
		
		JLabel lbTop = new LabelFactory("Move");
		lbTop.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 40));
		lbTop.setBounds(167, 11, 124, 47);
		moveView.add(lbTop);
		
		btCancel = new ButtonFactory("Cancel");
		btCancel.setBounds(55, 139, 89, 23);
		btCancel.addActionListener(this);
		moveView.add(btCancel);
		
		btMove = new ButtonFactory("Move");
		btMove.setBounds(303, 139, 89, 23);
		btMove.addActionListener(this);
		moveView.add(btMove);
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		notifyObservers(e);
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		if(model.getState() == 3 && model.getPhase() == 1){
			Move move = model.getMove();
			t1 = move.getFirstTerritory();
			t2 = move.getSecondTerritory();
			lbT1Name.setText(t1.getName());
			lbT2Name.setText(t2.getName());
			slider.setMaximum(t1.getNbrOfUnits()+t2.getNbrOfUnits()-2);
			lbT1Troops.setText(t1.getNbrOfUnits() - slider.getValue() + "");
			lbT2Troops.setText(t2.getNbrOfUnits() + slider.getValue() + "");
		}
	}
}
