package warborn.SupportClasses;

import warborn.model.spells.*;

public class SpellData {
	
	private static Spell[] spellList = {
		//Churchguard
		new Protect(5),
		new TimeOfTruce(10),
		new HolyLight(3),
		//Mindfucker/Jester/Trickster/Voodoo
		new Confusion(1),
		//Elementalist/Magician/...
		new FireBall(2),
		new Armageddon(15),
	};
	
	public static Spell getSpell(int index){
		return spellList[index];
	}

	public static int getNbrOfSpells() {
		return spellList.length;
	}
}
