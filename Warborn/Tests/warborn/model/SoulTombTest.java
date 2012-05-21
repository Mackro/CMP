package warborn.model;

import static org.junit.Assert.*;

import org.junit.Test;


public class SoulTombTest {
	
	@Test
	public void testDrawSoul() {
		SoulTomb deck = new SoulTomb();
		Soul card;
		for (int i=0; i<5; i++){
			card = deck.drawSoul();
			assertTrue(card.getIndex()==0 || card.getIndex()==1 || card.getIndex()==2);
			switch(card.getIndex()){
			case 0:
				assertTrue(card.getName().equals("Lesser Soul"));
				break;
			case 1:
				assertTrue(card.getName().equals("Common Soul"));
				break;
			case 2:
				assertTrue(card.getName().equals("Greater Soul"));
				break;
			default:
				fail();
			}
		}
	}
}