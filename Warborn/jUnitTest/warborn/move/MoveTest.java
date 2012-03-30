package warborn.move;

import static org.junit.Assert.*;
import org.junit.*;
import warborn.model.Move;
import warborn.model.Territory;
import warborn.model.Warborn;

public class MoveTest {

	private String name1 = "name1", name2 = "name2";
	private int one=1, two=2;
	Move move;
	
	@BeforeClass
	public void before() {
		Warborn model = new Warborn();
		move = new Move(model);
	}
	
	@Test
	public void testMove() {
	}

	@Test
	public void testMoveUnits() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAdd() {
		Territory t1 = new Territory(name1, one);
		Territory t2 = new Territory(name1, two);
		move.add(t1);
		assertTrue(move.getFirstTerritory()==t1);
		assertTrue(!(move.getFirstTerritory()==t2));
		move.add(t2);
		assertTrue(!(move.getSecondTerritory()==t1));
		assertTrue(move.getSecondTerritory()==t2);
	}
	
	@Test
	public void testResetTerritories() {
		
	}
	
	@Test
	public void testGetFirstTerritory() {
		
	}
	
	@Test
	public void testGetSecondTerritories() {
		
	}

}
