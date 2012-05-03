package warborn.model.spells;

import warborn.model.spells.*;

public final class SpellFactory {
	
	private SpellFactory(){
	}
	
	private static Spell[] spellList = {
		//Churchguard
		new Protect(5),
		new TimeOfTruce(10),
		new HolyLight(3),
		new Purge(8),
		///Jester/Trickster/Voodoo
		new Confusion(1),
		//Elementalist/Magician/Smith
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
