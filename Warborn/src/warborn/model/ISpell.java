package warborn.model;

public interface ISpell {

	boolean isInstant();
	boolean validTarget(Warborn model);
	void invoke(Warborn model);
	int getTimer();
	int getManaCost();
	void tick(Warborn model);

}
