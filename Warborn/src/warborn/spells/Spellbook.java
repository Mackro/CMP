package warborn.spells;

import java.util.ArrayList;

public class Spellbook {
	
	private ArrayList<Spell> spells;
	
	public Spellbook() {
		
	}
	
	public void fill(int bg){
		
	}
	
	public void addSpell(Spell spell) {
		spells.add(spell);
	}
	public void removeSpell(String name) {
		spells.remove(name);
	}
}
