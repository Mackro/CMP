package warborn.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiceTest {

	@Test
	public void TestD6roll() {
		int d;
		for (int i=0; i<20; i++){
			d = Dice.d6Roll();
			assertTrue(d>0 && d<7);
		}
	}

}
