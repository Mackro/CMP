package warborn.model.spells;

import warborn.model.Warborn;

public abstract class Spell {
	
	private int manaCost;
	private int timer;
	
	public abstract boolean validTarget(Warborn model);
	public abstract String getName();
	public abstract String getDescription();
	public abstract void invoke (Warborn model);
	
	public void tick(Warborn model){
		//Do nothing else override it
	}
	
	public Spell(int mana){
		manaCost = mana;
	}
	
	public int getManaCost(){
		return manaCost;
	}
	
	public int getTimer(){
		return timer;
	}
	
	protected void setTimer(int newTime){
		timer = newTime;
	}
	
	protected void decrementTimer(){
		timer--;
	}
	
	public boolean isInstant(){
		return false;
	}
	
	public String toString() {
		return getName();
	}
	
}
