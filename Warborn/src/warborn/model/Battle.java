package warborn.model;

import java.awt.Point;
import java.util.Arrays;

public class Battle extends TerritoryInteractor {
	
	private Warborn model;
	private int[] a = new int[3], d = new int[2];
	private int unitsAttacker, unitsDefender;
	private boolean shallMove = false;
	
	public Battle(Warborn model){
		this.model = model;
	}
	public Point fight(){
		int aLost = 0;
		int dLost = 0;
		
		d[0]=0;
		d[1]=0;
		a[0]=0;
		a[1]=0;
		a[2]=0;
		
		unitsAttacker = getFirstTerritory().getNbrOfUnits() - 1;
		unitsDefender = getSecondTerritory().getNbrOfUnits();
		
		for(int i = 0; i < unitsAttacker && i < 3; i++){
			a[i] = Dice.d6Roll();
		}
		Arrays.sort(a);
		int i = 1;
		do{
			d[i-1] = Dice.d6Roll();
			i++;
			System.out.println(i);
		}while(i < unitsDefender && i < 3);
		
		if(a[2] <= Math.max(d[0], d[1])){
			getFirstTerritory().setNbrOfUnits(unitsAttacker);
			aLost++;
		}
		else{
			getSecondTerritory().setNbrOfUnits(unitsDefender - 1);
			dLost++;
		}
			if(a[1] != 0 && a[1] <= Math.min(d[0], d[1]) ){
				getFirstTerritory().setNbrOfUnits(getFirstTerritory().getNbrOfUnits() - 1);
				aLost++;
			}	
		else if(Math.min(d[0], d[1]) != 0 && Math.min(d[0], d[1]) < a[1]){
			getSecondTerritory().setNbrOfUnits(getSecondTerritory().getNbrOfUnits() -1);
			dLost++;
		}
		model.changed();
		Point losses = new Point(aLost, dLost);
		return losses;
	}
	
	public void move(){
		getSecondTerritory().getOwner().removeTerritory();
		getFirstTerritory().getOwner().addTerritory(getSecondTerritory());
		getFirstTerritory().getOwner().conquered(true);
		getFirstTerritory().setNbrOfUnits(getFirstTerritory().getNbrOfUnits() - 1);
		getSecondTerritory().setNbrOfUnits(getSecondTerritory().getNbrOfUnits() +1);
		model.getMove().resetTerritories();
		model.getMove().add(getFirstTerritory());
		model.getMove().add(getSecondTerritory());
		shallMove = true;
		model.changed();
	}
	
	public boolean shallMove(){
		return shallMove;
	}
	
	public void shallNotMove(){
		shallMove = false;
		resetTerritories();
	}
	
}
