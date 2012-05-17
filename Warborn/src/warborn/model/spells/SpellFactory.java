package warborn.model.spells;

public final class SpellFactory {
	
	private SpellFactory(){
	}
	
	private static int spellListLength = 15;
	
	public static Spell getSpell(int index){
		switch(index){
		
			case 0:
				//Civitatis
				return new Affection(1);
			case 1:
				return new HolyLight(3);
			case 2:
				return new Protect(5);
			case 3:
				return new TimeOfTruce(10);
			case 4:
				//Insanus
				return new Confusion(1);
			case 5:
				return new FireBall(4);
			case 6:
				return new PurpleRitual(5);
			case 7:
				return new Armageddon(15);
			case 8:
				//Falcitier
				return new Beguile(1);
			case 9:
				return new SilverTongue(4);
			case 10:
				return new Deception(8);
			case 11:
				return new MassCajole(15);
			case 12:
				//Human
				return new Conscription(2);
			case 13:
				//Titan
				return new RagingElements(3);
			case 14:
				//Forgotten
				return new AwakenTheLost(12);
			default :
				//Something went wrong
				return null;
		}
	}

	public static int getNbrOfSpells() {
		return spellListLength;
	}
}
