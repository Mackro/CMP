package warborn.main;


import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import warborn.controller.*;
import warborn.map.GothenburgMapView;
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
		//model.addObserver(this);
		model.nextState();
		model.nextState();
		model.nextState();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new MainFrame();
		frame.setBounds(0, 0, model.getWidth(), model.getHeight());
		//frame.setUndecorated(true);
		frame.setResizable(false);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GothenburgMapView map = new GothenburgMapView(model);
		map.addObserver(new MapController(model));
		model.addObserver(map);
		frame.add(map.getMapPanel());
	}
	
	/**
	 * Initialize all the views and controllers
	 */
	private void init(){
		MoveView move = new MoveView(model);
		MoveController moveC = new MoveController(model);
		BattleView battle = new BattleView(model);
		BattleController battleC = new BattleController(model);
		
		model.addObserver(move);
		model.addObserver(battle);
		battle.addObserver(battleC);
		move.addObserver(moveC);
	}

	
	public void createGame(IMap map){
		map.addObserver(new MapController(model));
		model.addObserver(map);
		frame.add(map.getMapPanel());
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		if(model.getState() == 1){
			model.deleteObserver(this);
			createGame(model.getMap());
			System.out.println("Hej");
		}
	}

}
