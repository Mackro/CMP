package warborn.model;

import java.io.IOException;

public interface ISpellbook {
	
	public abstract void fill(int background) throws IOException;

	public abstract int getNumberOfSpells();
}
