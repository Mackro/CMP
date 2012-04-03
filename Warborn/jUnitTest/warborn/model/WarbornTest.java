package warborn.model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.*;

public class WarbornTest {
	Warborn model;
	
	@Before
	public void Before() {
		model = new Warborn();		
	}
	@Test
	public void TestSetPlayers() {
		String[] names = {"player1", "player2"};
		Color[] colors = {Color.red, Color.blue};
		model.setPlayers(names, colors);
		Player[] players = model.getPlayers();
		assertTrue(players[1].getName().equals(names[1]));
		assertTrue(players[2].getName().equals(names[2]));
		assertTrue(players[1].getColor().equals(colors[1]));
		assertTrue(players[2].getColor().equals(colors[2]));
	}
	@Test
	public void TestSetSelectedMap() {
		
	}
	
	
	/**
	 * setSelectedMap
	 * setSelectedTerritory
	 * addPlayer
	 * nextState
	 * nextPhase
	 * removePlayer()
	 * removePlayer(int)
	 * startGame
	 * attackCompatible
	 * moveCompatible
	 */
}
