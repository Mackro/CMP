package warborn;

import static org.junit.Assert.*;

import org.junit.Test;

import warborn.model.DiceTest;
import warborn.model.MoveTest;
import warborn.model.PlayerTest;
import warborn.model.SoulTest;
import warborn.model.SoulTombTest;
import warborn.model.TerritoryFactoryTest;
import warborn.model.TerritoryTest;
import warborn.model.WarbornTest;
import warborn.model.spells.SpellInvokerTest;

public class TestStart {

	@Test
	public void test() {
		new DiceTest().testClass();
		new MoveTest().testClass();
		new PlayerTest().testClass();
		new SoulTest().testClass();
		new SoulTombTest().testClass();
		new TerritoryFactoryTest().testClass();
		new TerritoryTest().testClass();
		new WarbornTest().testClass();
		new SpellInvokerTest().testClass();
	}

}
