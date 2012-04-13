package warborn.model;

import static org.junit.Assert.*;
import java.awt.Color;
import org.junit.*;

public class TerritoryTest {
	Territory t1;
	Territory t2;
	Territory t3;
	Territory t4;

	@Before
	public void Before(){
		t1 = new Territory("Terr1", 1);
		t2 = new Territory("Terr2", 2);
		t3 = new Territory("Terr3", 3);
		t4 = new Territory("Terr4", 4);
	}
	@Test
	public void TestTerritory() {
		assertTrue(t1.getName().equalsIgnoreCase("Terr1"));
		assertTrue(t1.getOwner()==null);
		assertTrue(t1.getNbrOfUnits()==0);
		assertTrue(t1.getId()==1);
	}
	@Test
	public void TestSetOwner() {
		Player player = new Player("player", 1, Color.RED, 0, 0);
		t1.setOwner(player);
		assertTrue(t1.getOwner()==player);
		Player player2 = new Player("player", 2, Color.BLUE, 0, 0);
		t1.setOwner(player2);
		assertTrue(t1.getOwner()==player2);
	}
	@Test
	public void TestSetNbrOfUnits() {
		t1.setNbrOfUnits(4);
		assertTrue(t1.getNbrOfUnits()==4);
		t2.setNbrOfUnits(8);
		assertTrue(t2.getNbrOfUnits()==8);
		t3.setNbrOfUnits(0);
		assertTrue(t3.getNbrOfUnits()==0);
		t1.setNbrOfUnits(99);
		assertTrue(t1.getNbrOfUnits()==99);
	}
	@Test
	public void TestIncrementUnit() {
		t1.incrementUnit();
		assertTrue(t1.getNbrOfUnits()==1);
		t1.setNbrOfUnits(4);
		for(int i=0; i<5; i++){
			t1.incrementUnit();
		}
		assertTrue(t1.getNbrOfUnits()==9);
	}
	@Test
	public void TestHasConnectionAddConnection() {
		t1.addConnection(t2);
		t1.addConnection(t3);
		assertTrue(t1.hasConnection(t2));
		assertTrue(t1.hasConnection(t3));
		assertTrue(!(t1.hasConnection(t4)));
		t4.addConnection(t2);
		assertTrue(t4.hasConnection(t2));
		assertTrue(!(t4.hasConnection(t1)));
		assertTrue(!(t4.hasConnection(t3)));
	}
	@Test
	public void TestEquals() {
		assertFalse(t1.equals(t2));
		assertTrue(t1.equals(t1));
		assertFalse(t1.equals(t4));
		Card card = new Card("lesser", null, 1);
		assertFalse(t3.equals(card));
	}
}
