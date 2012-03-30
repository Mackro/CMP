package warborn.view;

import javax.swing.JPanel;

import warborn.model.Warborn;

public class HUDView extends JPanel {

	public HUDView(Warborn model){
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 499, 230);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(499, 0, 450, 230);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(949, 0, 417, 230);
		add(panel_2);
	//setSize(model.getWidth(), model.getHeight());	
	}
}
