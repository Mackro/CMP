package warborn.model.spells;

import static org.junit.Assert.*;
import org.junit.*;

import warborn.model.Warborn;

public class SpellInvokerTest {
	SpellInvoker spellInvoker;
	Armageddon armageddon;
	Protect protect;
	FireBall fireBall;
	HolyLight holyLight;
	
	@Before
	public void before(){
		spellInvoker = new SpellInvoker(new Warborn());
		armageddon = new Armageddon(1);
		protect = new Protect(2);
		fireBall = new FireBall(3);
		holyLight = new HolyLight(4);
	}
	
	public void testClass(){
		testSetSelectedSpell();
	}
	
	@Test
	public void testSetSelectedSpell(){
		spellInvoker.setSelectedSpell(armageddon);
		assertTrue(spellInvoker.getSelectedSpell()==armageddon);

		spellInvoker.setSelectedSpell(protect);
		assertTrue(spellInvoker.getSelectedSpell()==protect);
		assertFalse(spellInvoker.getSelectedSpell()==armageddon);

		spellInvoker.setSelectedSpell(fireBall);
		assertTrue(spellInvoker.getSelectedSpell()==fireBall);

		spellInvoker.setSelectedSpell(holyLight);
		assertTrue(spellInvoker.getSelectedSpell()==holyLight);
		assertFalse(spellInvoker.getSelectedSpell()==armageddon);
	}
	
	//tested through usertesting
	//public void testInvoke();
}
