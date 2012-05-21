package warborn.model;

import static org.junit.Assert.*;
import org.junit.*;

import warborn.model.Move;
import warborn.model.Territory;
import warborn.model.Warborn;

public class MoveTest {

	private String name1 = "name1", name2 = "name2";
	private int one=1, two=2;
	private Move move;
	
	@Before
	public void before() {
		Warborn model = new Warborn();
		move = new Move(model);
	}
	
	@Test
	public void testMove() {
	}
	
	@Test
	public void testAdd() {
		Territory t1 = new Territory(name1, one);
		Territory t2 = new Territory(name2, two);
		move.add(t1);
		assertTrue(move.getFirstTerritory()==t1);
		assertTrue(!(move.getFirstTerritory()==t2));
		move.add(t2);
		assertTrue(!(move.getSecondTerritory()==t1));
		assertTrue(move.getSecondTerritory()==t2);
	}

	@Test
	public void testMoveUnits() {
		Territory t1 = new Territory(name1, one);
		Territory t2 = new Territory(name2, two);
		t1.setNbrOfUnits(7);
		t2.setNbrOfUnits(4);
		move.add(t1);
		move.add(t2);
		move.moveUnits(5);
		assertTrue(t1.getNbrOfUnits() == 6);
		assertTrue(t2.getNbrOfUnits() == 5);
		assertTrue(move.getFirstTerritory()==null);
		assertTrue(move.getSecondTerritory()==null);
	}
	
	@Test
	public void testResetTerritories() {
		Territory t1 = new Territory(name1, one);
		Territory t2 = new Territory(name2, two);
		move.add(t1);
		move.add(t2);
		move.resetTerritories();
		assertTrue(move.getFirstTerritory()==null && move.getSecondTerritory()==null);		
	}	
}
