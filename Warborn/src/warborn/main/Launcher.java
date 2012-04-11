package warborn.main;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import warborn.SupportClasses.MapData;
import warborn.controller.*;
import warborn.map.IMap;
import warborn.model.Warborn;
import warborn.view.*;

public class Launcher implements Observer{

	private MainFrame frame;
	private Warborn model;
	private KeyAction keyAction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Launcher l = new Launcher();
		l.run();
	}
	
	public void run() {
		frame.setVisible(true);
	}
	
	/**
	 * Create the application.
	 */
	public Launcher() {
		model = new Warborn();
		keyAction = new KeyAction(model, this);
		init();
		initialize();
		model.addObserver(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame(model);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1;
		c.ipady = (int) (model.getHeight());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 1;
		MenuView view = new MenuView(model);
		new MenuController(model, view);
		frame.add(view, c);
	}
	
	/**
	 * Initialize all the views and controllers
	 */
	private void init(){
		MoveView move = new MoveView(/*model*/);
		new MoveController(model, move);
		BattleView battle = new BattleView(/*model*/);
		new BattleController(model, battle);
		EndGameView end = new EndGameView(model, System.currentTimeMillis());
		new EndGameController(model, end, this);
		
		model.addObserver(end);
		model.addObserver(move);
		model.addObserver(battle);
	}

	
	public void createGame(int mapIndex){
		
		frame.dispose();
		frame = new MainFrame(model);
		frame.setVisible(true);
		model.addObserver(frame);
		
		GridBagConstraints c = new GridBagConstraints();
		
		IMap[] mapList = MapData.getMapList(model);
		new MapController(model, mapList[mapIndex]);
		model.addObserver(mapList[mapIndex]);
		c.weightx = 1;
		c.ipady = (int) (model.getHeight()*0.8);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.75;
		frame.add((JPanel)mapList[mapIndex], c);
		((JPanel)(mapList[mapIndex])).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "options");
		((JPanel)(mapList[mapIndex])).getActionMap().put("options", keyAction);
		
		
		HudView hud = new HudView(model);
		new HudController(model, hud);
		model.addObserver(hud);
		c.ipady = (int) (model.getHeight()*0.25);
		c.gridy = 1;
		c.weighty = 0.2;
		frame.add((JPanel)hud, c);
		hud.update(model, null);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(model.getState() == 1){
			model.deleteObserver(this);
			createGame(model.getMapIndex());
		}
	}
	
	public void reset(){
		frame.dispose();
		frame = null;
		System.gc();
		model = new Warborn();
		init();
		initialize();
		model.addObserver(this);
		run();
		
	}

}
