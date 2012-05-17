package warborn.model.spells;

public interface Liveable{

	LandOwner getOwner();

	int getNbrOfUnits();

	void setNbrOfUnits(int i);

	void setProtected(boolean b);

	void incrementUnit();

	void incrementUnits(int i);

	void decrementUnit();

	void decrementUnits(int i);

}
