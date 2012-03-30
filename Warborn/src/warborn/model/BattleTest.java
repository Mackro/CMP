package warborn.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class BattleTest {

	@Test
	public void test() {
		Warborn model = new Warborn();
		Territory t1 = new Territory("first", 1);
		Territory t2 = new Territory("second", 2);
		Territory t3 = new Territory("third", 3);
		t1.setNbrOfUnits(10);
		t2.setNbrOfUnits(5);
		t3.setNbrOfUnits(3);
		Battle battle = new Battle(model);
		battle.add(t1);
		battle.add(t2);
		battle.add(t3);
		battle.fight();
		
		assertTrue(t1.getNbrOfUnits() != 0 && t2.getNbrOfUnits() != 0);
		
		System.out.println(battle.getSecondTerritory().getName());
		
		battle.add(t1);
		battle.add(t2);
		
		assertTrue(t1.getNbrOfUnits() != 0 && t2.getNbrOfUnits() != 0);
		System.out.println(battle.getSecondTerritory().getName());
	}

}
