package warborn.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardDeckTest {

	@Test
	public void testDrawCard() {
	/**	ImageIcon infImg = new ImageIcon("images/infantry.jpg");
		ImageIcon cavImg = new ImageIcon("images/cavalry.jpg");
		ImageIcon artImg = new ImageIcon("images/artillery.jpg");*/
		CardDeck deck = new CardDeck();
		Card card;
		for (int i=0; i<5; i++){
			card = deck.drawCard();
			assertTrue(card.getIndex()==0 || card.getIndex()==1 || card.getIndex()==2);
			switch(card.getIndex()){
			case 0:
				assertTrue(card.getName().equals("Infantry"));
				break;
			case 1:
				assertTrue(card.getName().equals("Cavalry"));
				break;
			case 2:
				assertTrue(card.getName().equals("Artillery"));
				break;
			default:
				fail();
			}
		}
	}
}