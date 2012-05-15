package warborn.view;

import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

import warborn.model.Warborn;

public class StatePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private int height, width;
	
	public StatePanel (Warborn model, JFrame frame, String text) {
		GenericLabel message = new GenericLabel(text);
		this.add(message);
		initialise(model, frame);
	}
	
	public StatePanel (Warborn model, JFrame frame, String name, String text) {
		GenericLabel nameLabel = new GenericLabel(name);
		GenericLabel message = new GenericLabel(text);
		this.add(nameLabel);
		this.add(message);
		initialise(model, frame);
	}
	
	private void initialise(Warborn model, JFrame frame){
		frame.getLayeredPane().add(this, JLayeredPane.MODAL_LAYER);
		this.mainFrame = frame;
		height = (int)(model.getHeight()/8);
		width = (int)(model.getWidth()/8);
		setSize(width, height);
		setLocation((int)(model.getWidth()/2-width/2), (int)(model.getHeight()/2-height/2));
		setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED, Color.lightGray, Color.black));
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mainFrame.getLayeredPane().remove(this);
		mainFrame.repaint();
	}
}
