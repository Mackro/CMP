package warborn.view;

import javax.swing.*;

import warborn.model.Warborn;

public class StatePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private int height, width;
	
	public StatePanel (Warborn model, String text) {
		GenericLabel message = new GenericLabel(text);
		this.add(message);
		initialise(model);
	}
	
	public StatePanel (Warborn model, String name, String text) {
		GenericLabel nameLabel = new GenericLabel(name);
		GenericLabel message = new GenericLabel(text);
		this.add(nameLabel);
		this.add(message);
		initialise(model);
	}
	
	public void initialise(Warborn model){
		height = (int)(model.getHeight()/8);
		width = (int)(model.getWidth()/8);
		frame = new JFrame();
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.add(this);
		frame.setLocation((int)(model.getWidth()/2-width/2), (int)(model.getHeight()/2-height/2));
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.setVisible(false);
		frame.dispose();
	}
}
