package warborn.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;

import warborn.model.LabelFactory;
import warborn.model.Warborn;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Observable;
import java.util.Observer;

public class OptionsMenuView extends JPanel {

	private Warborn model;
	private JButton btMainMenu, btExit, btResume;
	private JFrame frame;
	
	/**
	 * Create the panel.
	 */
	public OptionsMenuView(Warborn model){
		
		this.model = model;
		
		
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(400, 600);
		frame.setLocation((int)((model.getWidth()/2) - (frame.getWidth()/2)), 60);
		frame.getContentPane().add(this);
		frame.setVisible(true);
		setLayout(null);
		
		JLabel lblOptions = LabelFactory.makeLabel("Options");
		lblOptions.setFont(new Font("Rod", Font.BOLD | Font.ITALIC, 25));
		lblOptions.setBounds(140, 11, 113, 31);
		add(lblOptions);
		
		btMainMenu = new JButton("Main Menu");
		btMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btMainMenu.setBounds(140, 486, 113, 31);
		add(btMainMenu);
		
		btExit = new JButton("Exit Game");
		btExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btExit.setBounds(140, 558, 113, 31);
		add(btExit);
		
		frame.getContentPane().add(this);
		
		btResume = new JButton("Resume");
		btResume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btResume.setBounds(140, 113, 113, 31);
		add(btResume);
	}

	public JButton[] getButtonArray() {
		return new JButton[]{
				btMainMenu,
				btExit,
				btResume,
		};
		
	}

	public JFrame getFrame() {
		return frame;
	}
}
