package spells;

import java.util.ArrayList;

public class Spellbook {
	
	private ArrayList<Spell> spells;
	
	public Spellbook() {
		
	}
	
	public void addSpell(Spell spell) {
		spells.add(spell);
	}
	public void removeSpell(String name) {
		spells.remove(name);
	}
}
