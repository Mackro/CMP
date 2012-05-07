package warborn.model;

public class PlayerData {

	private static final String[] RACE = new String[]{
			"Human",
			"Titan",
			"The Forgotten",
	}, BACKGROUND = new String[]{
			"Civitatis",
			"Insanus",
			"Falcitier",
	};
	
	public static int getNumberOfRaces(){
		return RACE.length;
	}
	
	public static int getNumberOfBackgrounds(){
		return BACKGROUND.length;
	}
	
	public static String getRaceName(int index){
		return RACE[index];
	}
	
	public static String getBackgroundName(int index){
		return BACKGROUND[index];
	}
	
}
