package warborn.model.spells;

import java.awt.Image;

import javax.swing.ImageIcon;

import warborn.model.ISpell;
import warborn.model.Warborn;

public abstract class Spell implements ISpell{
	
	private int manaCost;
	private int timer = 0;
	
	public abstract boolean validTarget(Warborn model);
	public abstract String getName();
	public abstract String getDescription();
	public abstract void invoke (Warborn model);
	
	public Spell(int mana){
		manaCost = mana;
	}
	
	public Image getImage(){
		return new ImageIcon("WarbornData/images/spells/" + getName().replaceAll(" ", "") + ".png").getImage();
	}
	
	public void tick(Warborn model){
		;//Does nothing by default. Is overrided if necessary.
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
