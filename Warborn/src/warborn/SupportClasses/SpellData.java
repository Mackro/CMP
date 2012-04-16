package warborn.SupportClasses;

import java.util.ArrayList;

import warborn.model.spells.*;

public class SpellData {
	
	private static Spell[] spellList = {
		new Protect(5),
		new TimeOfTruce(10),
		new HolyLight(3),
	};
	
	public static Spell getSpell(int index){
		return spellList[index];
	}

	public static int getNbrOfSpells() {
		return spellList.length;
	}
}
