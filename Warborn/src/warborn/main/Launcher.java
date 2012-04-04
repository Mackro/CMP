package warborn.main;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import warborn.SupportClasses.MapData;
import warborn.controller.*;
import warborn.map.IMap;
import warborn.model.Warborn;
import warborn.view.*;

public class Launcher implements Observer{

	private JFrame frame;
	private Warborn model;

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
		init();
		initialize();
		model.addObserver(this);
		model.startGame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame(model);
		//GothenburgMapView map = new GothenburgMapView(model);
		//new MapController(model, map);
		//model.addObserver(map);
		//frame.add(map);
	}
	
	/**
	 * Initialize all the views and controllers
	 */
	private void init(){
		MoveView move = new MoveView(/*model*/);
		new MoveController(model, move);
		BattleView battle = new BattleView(/*model*/);
		new BattleController(model, battle);
		
		model.addObserver(move);
		model.addObserver(battle);
	}

	
	public void createGame(int mapIndex){
		
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
		
		HudView hud = new HudView(model);
		new HudController(model, hud);
		model.addObserver(hud);
		c.ipady = (int) (model.getHeight()*0.25);
		c.gridy = 1;
		c.weighty = 0.2;
		frame.add((JPanel)hud, c);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(model.getState() == 1){
			model.deleteObserver(this);
			createGame(model.getMapIndex());
		}
	}

}
