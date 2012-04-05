package warborn.main;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import warborn.model.LabelFactory;
import warborn.model.Player;
import warborn.model.Warborn;
import java.awt.Font;

public class EndGameView extends JPanel implements Observer{
	
	private long startTime;
	private Warborn model;
	private JLabel lbTime;
	private JFrame frame;
	private JButton btRestart, btExit;
	
	public EndGameView(Warborn model, long startTime){
		if(startTime < System.currentTimeMillis()){
			this.startTime = startTime;
		}else{
			this.startTime = System.currentTimeMillis();
		}
		this.model = model;
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setVisible(false);
		frame.setSize(800, 600);
		frame.setLocation((int)((model.getWidth()/2) - (frame.getWidth()/2)), (int)((model.getHeight()*0.7)/2) - (frame.getHeight()/2));
		frame.getContentPane().add(this);
		
		setLayout(null);
		setSize(model.getWidth(), model.getHeight());
		
		JLabel lbHead = LabelFactory.makeLabel("Game Over!");
		lbHead.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 50));
		lbHead.setSize(345, 200);
		lbHead.setLocation(196, 30);
		add(lbHead);
		
		lbTime = LabelFactory.makeLabel("Victory after 00:50:15");
		lbTime.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 50));
		lbTime.setSize(782, 150);
		lbTime.setLocation(28, 190);
		add(lbTime);
		
		btExit = new JButton("Exit Game");
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btExit.setBounds(584, 422, 150, 150);
		add(btExit);
		
		btRestart = new JButton("Restart");
		btRestart.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btRestart.setBounds(93, 422, 150, 150);
		add(btRestart);

	}
	
	public JButton[] getButtonArray(){
		return new JButton[]{
			btRestart,
			btExit,
		};
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		
		Player owner = model.getTerritory(0).getOwner();
		for(int i = 1; i < model.getTerritories().length; i++){
			if(owner != model.getTerritory(i).getOwner()){
				return;
			}
		}
		long stopTime = System.currentTimeMillis();
		long runTime = stopTime - startTime;
		long seconds = runTime/1000;
		long minutes = seconds/60;
		seconds %= 60;
		long hours = minutes/60;
		minutes %= 60;
		
		lbTime.setText("Victory after " + hours + ":" + minutes + ":" + seconds);
		
		frame.setVisible(true);
	}
}
