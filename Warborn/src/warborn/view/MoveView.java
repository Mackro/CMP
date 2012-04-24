package warborn.view;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import warborn.model.TerritoryInteractor;
import warborn.model.Warborn;
import warborn.model.Territory;

public class MoveView implements Observer {
	
	private JButton[] buttons;
	private JButton btCancel, btDecrease, btIncrease, btMove;
	private JPanel viewPanel;
	private JSlider slider;
	private Territory t1, t2;
	private JFrame moveFrame;
	private JLabel lbT1Name, lbT2Name;
	private JLabel lbT1Troops;
	private JLabel lbT2Troops;

	/**
	 * Create the panel.
	 */
	public MoveView(){
		
		moveFrame = new JFrame();
		moveFrame.setUndecorated(true);
		moveFrame.setVisible(false);
		moveFrame.setLocationRelativeTo(null);
		moveFrame.setSize(560, 229);
		
		viewPanel = new JPanel();
		viewPanel.setLayout(null);
		moveFrame.getContentPane().add(viewPanel);
		
		slider = new JSlider();
		slider.setMinimum(1);
		slider.setBounds(171, 91, 200, 23);
		viewPanel.add(slider);
		
		lbT1Name = new GenericLabel("");
		lbT1Name.setBounds(10, 54, 235, 23);
		viewPanel.add(lbT1Name);
		
		lbT2Name = new GenericLabel("");
		lbT2Name.setBounds(304, 54, 235, 23);
		viewPanel.add(lbT2Name);
		
		lbT1Troops = new GenericLabel("");
		lbT1Troops.setBounds(10, 100, 85, 14);
		viewPanel.add(lbT1Troops);
		
		lbT2Troops = new GenericLabel("");
		lbT2Troops.setBounds(451, 100, 83, 14);
		viewPanel.add(lbT2Troops);
		
		JLabel lbTop = new GenericLabel("Move");
		lbTop.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 40));
		lbTop.setBounds(217, 11, 124, 47);
		viewPanel.add(lbTop);
		
		buttons = new JButton[4];
		
		btCancel = new GenericButton("Cancel");
		btCancel.setBounds(55, 139, 89, 23);
		viewPanel.add(btCancel);
		buttons[0] = btCancel;
		
		btMove = new GenericButton("Move");
		btMove.setBounds(400, 139, 89, 23);
		viewPanel.add(btMove);
		buttons[1] = btMove;
		
		btDecrease = new GenericButton("-");
		btDecrease.setBounds(116, 91, 47, 23);
		viewPanel.add(btDecrease);
		buttons[2] = btDecrease;
		
		btIncrease = new GenericButton("+");
		btIncrease.setBounds(381, 91, 47, 23);
		viewPanel.add(btIncrease);
		buttons[3] = btIncrease;

	}
	
	public JSlider getSlider(){
		return slider;
	}
	
	public JButton[] getButtons(){
		return buttons;
	}
	public JFrame getFrame(){
		return moveFrame;
	}
	public JLabel getLbT1Troops(){
		return lbT1Troops;
	}
	public JLabel getLbT2Troops(){
		return lbT2Troops;
	}
	@Override
	public void update(Observable ml, Object arg1) {
		Warborn model = (Warborn)ml;
		if(model.getState() == 3 && model.getPhase() == 1){
			btCancel.setEnabled(true);
			fillInformation(model, model.getMove());
			slider.setMaximum(t1.getNbrOfUnits()+t2.getNbrOfUnits()-1);
		}else if(model.getBattle().shallMove()){
			btCancel.setEnabled(false);
			fillInformation(model, model.getBattle());
			slider.setMaximum(Math.min(t1.getNbrOfUnits()+t2.getNbrOfUnits()-1,3));
		}
	}
	
	private void fillInformation(Warborn model, TerritoryInteractor ti){
		t1 = ti.getFirstTerritory();
		t2 = ti.getSecondTerritory();
		lbT1Name.setText(t1.getName());
		lbT2Name.setText(t2.getName());
		slider.setValue(t2.getNbrOfUnits());
		lbT1Troops.setText(Integer.toString(t1.getNbrOfUnits()));
		lbT2Troops.setText(Integer.toString(t2.getNbrOfUnits()));
		moveFrame.setLocation((int)((model.getWidth()/2) - (moveFrame.getWidth()/2)), (int)((model.getHeight()*0.7)/2) - (moveFrame.getHeight()/2));
		moveFrame.setVisible(true);
	}
	
}
