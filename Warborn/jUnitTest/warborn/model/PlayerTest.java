package warborn.model;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.ImageIcon;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testPlayer() {
		Color c = Color.BLACK;
		String name = "name";
		int i = 5;
		Player test = new Player(name, i, c, 0, 0);
		c = Color.YELLOW;
		name = "wrong";
		i = 7;
		assertTrue(test.getColor().equals(Color.BLACK));
		assertTrue(test.getID() == 5);
		assertTrue(test.getName().equalsIgnoreCase("name"));
		
	}

	@Test
	public void testGetNbrOfTerritories() {
		Player test = new Player("name", 7, Color.BLUE, 0, 0);
		test.addTerritory(new Territory("Tname", 1));
		test.addTerritory(new Territory("Tname", 2));
		test.addTerritory(new Territory("Tname", 3));
		test.addTerritory(new Territory("Tname", 4));
		test.addTerritory(new Territory("Tname", 5));
		assertTrue(test.getNbrOfTerritories() == 5);
		test.removeTerritory();
		test.removeTerritory();
		assertTrue(test.getNbrOfTerritories() == 3);
	}

	@Test
	public void testAddCard() {
		Player test = new Player("name", 8, Color.CYAN, 0, 0);
		CardDeck deck = new CardDeck();
		test.addCard(deck.drawCard());
		test.addCard(deck.drawCard());
		test.addCard(deck.drawCard());
		test.addCard(deck.drawCard());
		Card c = deck.drawCard();
		test.addCard(c);
		assertTrue(test.getCard(4) == c);
	}

	@Test
	public void testRemoveCard() {
		Player test = new Player("name", 4, Color.DARK_GRAY, 0, 0);
		CardDeck deck = new CardDeck();
		test.addCard(deck.drawCard());
		Card c = deck.drawCard();
		test.addCard(c);
		Card c2 = deck.drawCard();
		test.addCard(c2);
		test.addCard(deck.drawCard());
		
		test.removeCard(c.getIndex());
		
		assertTrue(test.getCard(1) == c2);
		
	}

	@Test
	public void testCanExchangeCards() {
		Player test = new Player("name", 3, Color.GRAY, 0, 0);
		CardDeck deck = new CardDeck();
		Card c = deck.drawCard();
		test.addCard(c);
		test.addCard(c);
		assertTrue(!test.canExchangeCards());
		test.addCard(c);
		assertTrue(test.canExchangeCards());
		test.removeCard(c.getIndex());
		test.removeCard(c.getIndex());
		test.removeCard(c.getIndex());

		Card c2 = new Card("test", new ImageIcon("test"), 0);
		Card c3 = new Card("test", new ImageIcon("test"), 1);
		Card c4 = new Card("test", new ImageIcon("test"), 2);
		Card c5 = new Card("test", new ImageIcon("test"), 1);
		Card c6 = new Card("test", new ImageIcon("test"), 1);
		test.addCard(c2);
		test.addCard(c3);
		test.addCard(c5);
		test.addCard(c2);
		assertTrue(!test.canExchangeCards());
		test.addCard(c4);
		assertTrue(test.canExchangeCards());
		test.removeCard(c4.getIndex());
		test.addCard(c6);
		assertTrue(test.canExchangeCards());
		
	}

}
