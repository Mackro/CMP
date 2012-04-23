package warborn.model;

import java.io.*;
import java.util.ArrayList;

import warborn.model.spells.Spell;

public class Spellbook {
	
	private ArrayList<Spell> spells;
	
	public Spellbook() {
		spells = new ArrayList<Spell>();
	}
	
	public Spell getSpell(int index){
		return spells.get(index);
	}
	
	public int getNumberOfSpells(){
		return spells.size();
	}
	
	public void fill(int background) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(new File("WarbornData/classes/" + PlayerData.getBackgroundName(background) + ".txt")));
		for(String line = in.readLine(); line != null; line = in.readLine()){
			for(int i = 0; i < SpellFactory.getNbrOfSpells(); i++){
				if(SpellFactory.getSpell(i).toString().equalsIgnoreCase(line)){
					addSpell(SpellFactory.getSpell(i));
				}
			}
		}
		in.close();
	}
	
	public void addSpell(Spell spell) {
		spells.add(spell);
	}
	
	public void removeSpell(Spell name) {
		spells.remove(name);
	}
}
