package warborn.model;

import java.util.ArrayList;

import warborn.model.spells.Spell;

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
