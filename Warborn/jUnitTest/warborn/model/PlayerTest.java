package warborn.model;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Color c = Color.BLACK;
		String name = "name";
		int i = 5;
		Player test = new Player(name, i, c);
		c = Color.YELLOW;
		name = "wrong";
		i = 7;
		assertTrue(test.getColor().equals(Color.BLACK));
		assertTrue(test.getID() == 5);
		assertTrue(test.getName().equalsIgnoreCase("name"));
		
	}

	@Test
	public void testGetNbrOfTerritories() {
		Player test = new Player("name", 7, Color.BLUE);
		test.addTerritory(new Territory("Tname", 1, ))
	}

	@Test
	public void testGetColor() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddTerritory() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveTerritory() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testAddCard() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testRemoveCard() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testCanExchangeCards() {
		fail("Not yet implemented"); // TODO
	}

}
