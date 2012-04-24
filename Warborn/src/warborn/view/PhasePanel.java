package warborn.view;

import javax.swing.*;

import warborn.model.Warborn;

public class PhasePanel extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private GenericLabel label;
	private JFrame frame;
	
	public PhasePanel (Warborn model, String text) {
		int height = (int)(model.getHeight()/10);
		int width = (int)(model.getWidth()/9);
		
		frame = new JFrame();
		label = new GenericLabel(text);
		this.add(label);
		frame.setSize(width, height);
		frame.add(this);
		frame.setLocation((int)(model.getWidth()/2-width/2), (int)(model.getHeight()/2-height/2));
		frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		run();
	}

	@Override
	public void run() {
		try {
			frame.wait(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		frame.removeAll();
		frame.dispose();
		
	}
}
