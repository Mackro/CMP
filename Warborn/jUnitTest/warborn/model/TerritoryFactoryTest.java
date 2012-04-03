package warborn.model;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.*;

public class TerritoryFactoryTest {
	Territory[] territories;
	
	@Before
	public void Before() throws IOException {
		territories = TerritoryFactory.getTerritories("Gothenburg");
	}
	@Test
	public void TestGetTerritories(){
		assertTrue(territories[1].hasConnection(territories[2]));
		assertTrue(territories[1].hasConnection(territories[4]));
		
		assertTrue(territories[2].hasConnection(territories[1]));
		assertTrue(territories[2].hasConnection(territories[11]));
		
		assertTrue(territories[5].hasConnection(territories[1]));
		assertTrue(territories[5].hasConnection(territories[4]));
		assertTrue(territories[5].hasConnection(territories[6]));
		
		assertTrue(territories[15].hasConnection(territories[14]));
		assertTrue(territories[15].hasConnection(territories[18]));
		assertTrue(territories[15].hasConnection(territories[20]));
		
		assertFalse(territories[15].hasConnection(territories[13]));
		assertFalse(territories[3].hasConnection(territories[4]));
		
	}
}