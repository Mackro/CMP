package warborn.model.spells;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import warborn.model.Warborn;

//TestDriv skiten!!!!
public class SpellInvoker implements Observer{
	private Warborn model;
	private Spell selectedSpell;
	private ArrayList<Spell> activeSpells;

	public SpellInvoker(Warborn model) {
		this.activeSpells = new ArrayList<Spell>();
		this.model = model;
		model.addObserver(this);
		// TODO Auto-generated constructor stub
	}
	
	public Spell getSelectedSpell(){
		return selectedSpell;
	}
	
	public void setSelectedSpell(Spell spell){
		selectedSpell = spell;
		if(spell.isInstant()){
			invokeSpell(spell);
		}
	}
	
	public void invokeSpell(Spell spell){
		if(spell.validTarget(model) && model.getCurrentPlayer().getMana() >= spell.getManaCost()){
			spell.invoke(model);
			if(spell.getTimer() > 0){
				activeSpells.add(spell);
			}
		}
		model.resetSelectedTerritory();
		selectedSpell = null;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o.getClass()==Warborn.class && arg!=null && (int)(arg)==1){
			for(int i = 0; i < activeSpells.size(); i++){
				activeSpells.get(i).tick(model);
				if(activeSpells.get(i).getTimer() <= 0){
					activeSpells.remove(i);
				}
			}
		}
	}
}
