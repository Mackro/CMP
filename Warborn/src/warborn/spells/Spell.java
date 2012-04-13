package warborn.spells;

import warborn.model.Warborn;

public abstract class Spell {
	
	private int manaCost;
	
	public Spell(int mana){
		manaCost = mana;
	}
	
	public abstract void invoke (Warborn model);
	
	public int getManaCost(){
		return manaCost;
	}
	
	public String toString() {
		return this.getClass().getName();
	}
}
