package warborn.model.spells;

import java.awt.Color;

public interface LandOwner{

	int getNbrOfTerritories();

	Color getColor();

	int getMana();

	String getName();

	void setAdditionalName(String string);

	void setColor(Color color);

	void addTerritory(Liveable selectedTerritory);

	void changeMana(int i);

}
