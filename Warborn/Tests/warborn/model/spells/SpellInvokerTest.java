package warborn.model.spells;

import static org.junit.Assert.*;
import org.junit.*;

import warborn.model.Warborn;

public class SpellInvokerTest {
	SpellInvoker spellInvoker;
	Deception deception;
	Protect protect;
	FireBall fireBall;
	HolyLight holyLight;
	
	@Before
	public void before(){
		spellInvoker = new SpellInvoker(new Warborn());
		deception = new Deception(1);
		protect = new Protect(2);
		fireBall = new FireBall(3);
		holyLight = new HolyLight(4);
	}

	@Test
	public void testSetSelectedSpell(){
		spellInvoker.setSelectedSpell(deception);
		assertTrue(spellInvoker.getSelectedSpell()==deception);

		spellInvoker.setSelectedSpell(protect);
		assertTrue(spellInvoker.getSelectedSpell()==protect);
		assertFalse(spellInvoker.getSelectedSpell()==deception);

		spellInvoker.setSelectedSpell(fireBall);
		assertTrue(spellInvoker.getSelectedSpell()==fireBall);

		spellInvoker.setSelectedSpell(holyLight);
		assertTrue(spellInvoker.getSelectedSpell()==holyLight);
		assertFalse(spellInvoker.getSelectedSpell()==deception);
	}
	
	//tested through usertesting
	//public void testInvoke();
}
