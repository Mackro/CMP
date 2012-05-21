package warborn.model.spells;

import java.io.*;
import java.util.ArrayList;

import warborn.constants.PlayerData;

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
	
	public void fill(int god, int race) throws IOException{
		//Adding God spells
		BufferedReader in = new BufferedReader(new FileReader(new File("WarbornData/gods/" + PlayerData.getGodName(god) + ".txt")));
		for(String line = in.readLine(); line != null; line = in.readLine()){
			for(int i = 0; i < SpellFactory.getNbrOfSpells(); i++){
				if(SpellFactory.getSpell(i).toString().equalsIgnoreCase(line)){
					addSpell(SpellFactory.getSpell(i));
				}
			}
		}
		in.close();
		
		//Adding Race Spells
		BufferedReader Racein = new BufferedReader(new FileReader(new File("WarbornData/races/" + PlayerData.getRaceName(race) + ".txt")));
		for(String line = Racein.readLine(); line != null; line = Racein.readLine()){
			for(int i = 0; i < SpellFactory.getNbrOfSpells(); i++){
				if(SpellFactory.getSpell(i).toString().equalsIgnoreCase(line)){
					addSpell(SpellFactory.getSpell(i));
				}
			}
		}
		Racein.close();
	}
	
	public void addSpell(Spell spell) {
		spells.add(spell);
	}
	
	public void removeSpell(Spell name) {
		spells.remove(name);
	}
}
