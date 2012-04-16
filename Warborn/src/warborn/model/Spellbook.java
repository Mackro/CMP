package warborn.model;

import java.io.*;
import java.util.ArrayList;

import warborn.SupportClasses.PlayerData;
import warborn.SupportClasses.SpellData;
import warborn.model.spells.Spell;

public class Spellbook {
	
	private ArrayList<Spell> spells;
	
	public Spellbook() {
		
	}
	
	public void fill(int background) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(new File("WarbornData/classes/" + PlayerData.getBackgroundName(background) + ".txt")));
		for(String line = in.readLine(); line != null; line = in.readLine()){
			for(int i = 0; i < SpellData.getNbrOfSpells(); i++){
				if(SpellData.getSpell(i).toString().equalsIgnoreCase(line)){
					addSpell(SpellData.getSpell(i));
				}
			}
		}
	}
	
	public void addSpell(Spell spell) {
		spells.add(spell);
	}
	public void removeSpell(String name) {
		spells.remove(name);
	}
}
