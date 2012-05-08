package warborn.constants;

public class PlayerData {

	private static final String[] RACE = new String[]{
			"Human",
			"Titan",
			"Forgotten",
	}, GODS = new String[]{
			"Civitatis",
			"Insanus",
			"Falcitier",
	};
	
	public static int getNumberOfRaces(){
		return RACE.length;
	}
	
	public static int getNumberOfGods(){
		return GODS.length;
	}
	
	public static String getRaceName(int index){
		return RACE[index];
	}
	
	public static String getGodName(int index){
		return GODS[index];
	}
	
}
