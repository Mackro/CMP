package warborn.model.spells;

import java.util.Observer;

public interface SpellTargetable{

	LandOwner[] getPlayers();

	LandOwner getPlayer(int i);

	LandOwner getCurrentPlayer();

	int getNumberOfPlayers();

	Liveable[] getTerritories();

	Liveable getSelectedTerritory();

	int getSelectedTerritoryIndex();

	int getNbrOfReinforcements();

	int getState();

	void setSpellLoaded(boolean b);

	void setNbrOfReinforcements(int i);

	boolean isSpellLoaded();

	void changed();

	void addObserver(Observer observer);

}