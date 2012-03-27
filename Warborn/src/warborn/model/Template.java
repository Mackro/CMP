package warborn.model;

public abstract class Template {
	private Territory t1;
	private Territory t2;
	
	public void add(Territory t){
		if(t1 == null){
			this.t1 = t;
		}
		else{
			this.t2 = t;
		}
	}
	public void resetTerritories (){
		t1 = null;
		t2 = null;
	}
	
	public Territory getFirstTerritory() {
		return t1;
	}

	public Territory getSecondTerritory() {
		return t2;
	}
}
