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
		int[] races = {0, 0};
		int[] backgrounds = {0, 0};
		model.setPlayers(names, colors, races, backgrounds);
		Player[] players = model.getPlayers();
		assertTrue(players[1].getName().equals(names[1]));
		assertTrue(players[2].getName().equals(names[2]));
		assertTrue(players[1].getColor().equals(colors[1]));
		assertTrue(players[2].getColor().equals(colors[2]));
	}
	@Test
	public void TestSetSelectedMap() {
		model.setSelectedMap(3);
		assertTrue(model.getMapIndex()==3);
		assertFalse(model.getMapIndex()==0);
		assertFalse(model.getMapIndex()==1);
	}
	@Test
	public void TestSetSelectedTerritory() {
		model.setSelectedTerritory(4);
		
	}
	@Test
	public void TestAddPlayer() {
		fail("not implemented yet!");
	}
	@Test
	public void TestNextState() {
		fail("not implemented yet!");
	}
	@Test
	public void TestNextPhase() {
		fail("not implemented yet!");
	}
	@Test
	public void TestRemovePlayer() {
		fail("not implemented yet!");
	}
	@Test
	public void TestStartGame() {
		fail("not implemented yet!");
	}
	@Test
	public void TestAttackCompatible() {
		fail("not implemented yet!");
	}
	@Test
	public void TestMoveCompatible() {
		fail("not implemented yet!");
	}
}
