package warborn.SupportClasses;

public class PlayerData {

	private static final String[] race = new String[]{
			"Human",
	}, background = new String[]{
			"Churchguard",
	};
	
	public static int getNumberOfRaces(){
		return race.length;
	}
	
	public static int getNumberOfBackgrounds(){
		return background.length;
	}
	
	public static String getRaceName(int index){
		return race[index];
	}
	
	public static String getBackgroundName(int index){
		return background[index];
	}
	
}
