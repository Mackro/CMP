package warborn.model.spells;

public final class SpellFactory {
	
	private SpellFactory(){
	}
	
	private static Spell[] spellList = {
		//Civitatis
		new HolyLight(3),
		new Protect(5),
		new TimeOfTruce(10),
		//Insanus
		new Confusion(1),
		new FireBall(2),
		new Armageddon(15),
		//Falciter
		new Purge(8),
	};
	
	public static Spell getSpell(int index){
		return spellList[index];
		/* TODO: remove comment when all spells exist! if the old way works as I think it does
		switch(index){
		
			case 0:
				//Civitatis
				return new HolyLight(3);
			case 1:
				return new Protect(5);
			case 2:
				return new TimeOfTruce(10);
			case 3:
				return null;
			case 4:
				//Insanus
				return new Confusion(1);
			case 5:
				return new FireBall(4);
			case 6:
				return PurpleRitual(5);
			case 7:
				return new Armageddon(15)
			case 8:
				//Falcitier
				 return new Beguile(1);
			case 9:
				 return new SilverTongue(4);
			case 10:
				return new Purge(8);
			case 11:
				return new MassCajole(15);
			default :
				//Something went wrong
				return null;
		}
		*/
	}

	public static int getNbrOfSpells() {
		return spellList.length;
	}
}
