package warborn.SupportClasses;

import java.util.ArrayList;

import warborn.model.spells.*;

public class SpellData {
	
	private static Spell[] spellList = {
		//Churchguard
		new Protect(5),
		new TimeOfTruce(10),
		new HolyLight(3),
		
		new Confusion(1),
	};
	
	public static Spell getSpell(int index){
		return spellList[index];
	}

	public static int getNbrOfSpells() {
		return spellList.length;
	}
}
