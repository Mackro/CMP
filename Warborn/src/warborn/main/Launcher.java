package warborn.main;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import warborn.controller.*;
import warborn.map.GothenburgMapView;
import warborn.map.IMap;
import warborn.model.Warborn;
import warborn.view.*;

public class Launcher implements Observer{

	private MainFrame frame;
	private Warborn model;
	private KeyAction keyAction;
	private MenuView menu;

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
		menu = new MenuView(model);
		new MenuController(model, menu);
		frame.add(menu, c);
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
		new EndGameController(end, this);
		
		model.addObserver(new StatePanelViewCreator());
		
		model.addObserver(end);
		model.addObserver(move);
		model.addObserver(battle);
	}

	
	public void createGame(int mapIndex){
		
		frame.remove(menu);
		model.addObserver(frame);
		
		GridBagConstraints c = new GridBagConstraints();
		
		IMap[] mapList = getMapList();
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
		((JPanel)(mapList[mapIndex])).getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "options");
		((JPanel)(mapList[mapIndex])).getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "options");
		((JPanel)(mapList[mapIndex])).getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0), "options");
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
		if(model.getState() == 0){
			model.deleteObserver(this);
			createGame(model.getMapIndex());
		}
	}
	
	public void reset(){
		frame.dispose();
		frame = null;
		model = new Warborn();
		init();
		initialize();
		model.addObserver(this);
		run();
		
	}
	
	public IMap[] getMapList(){
		return new IMap[] {
				new GothenburgMapView(model),
		};
	}

}
