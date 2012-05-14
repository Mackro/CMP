package warborn.constants;


public final class MapData {
	
	private static String[] mapNames = {
		"Asgauter",
		"Archipelago"
	};
	
	public static String[] getMapNames(){
		return mapNames;
	}
	
	public static String getMapName(int index){
		return mapNames[index];
	}
	
	public static double[][] getScalingConstants(String map) throws MapNotFoundException{
		if(map.equalsIgnoreCase("Asgauter")){
			return new double[][]{
				{0.760, 0.160},
				{0.590, 0.065},
				{0.400, 0.064},
				{0.675, 0.180},
				{0.800, 0.270},
				{0.700, 0.380},
				{0.850, 0.430},
				{0.760, 0.520},
				{0.600, 0.515},
				{0.620, 0.410},
				{0.590, 0.300},
				{0.630, 0.280},
				{0.520, 0.120},
				{0.520, 0.410},
				{0.450, 0.410},
				{0.510, 0.330},
				{0.450, 0.140},
				{0.440, 0.290},
				{0.360, 0.210},
				{0.340, 0.305},
				{0.260, 0.220},
				{0.190, 0.260},
			};
		}else if(map.equalsIgnoreCase("Archipelago")){
			return new double[][]{
				{0.15, 0.18},//0
				{0.31, 0.15},
				{0.23, 0.20},
				{0.315, 0.232},
				{0.145, 0.27},
				{0.225, 0.28},//5
				{0.29, 0.295},
				{0.13, 0.4},
				{0.255, 0.41},
				{0.325, 0.405},
				{0.41, 0.1},//10
				{0.45, 0.18},
				{0.477, 0.11},
				{0.58, 0.05},
				{0.6, 0.175},
				{0.65, 0.125},//15
				{0.405, 0.3},
				{0.461, 0.26},
				{0.5, 0.28},
				{0.6, 0.305},
				{0.0, 0.0},//20
				{0.0, 0.0},
				{0.0, 0.0},
				{0.0, 0.0},
				{0.0, 0.0},
				{0.0, 0.0},//25
				{0.0, 0.0},
				{0.0, 0.0},
				{0.79, 0.09},
				{0.0, 0.0},
				{0.0, 0.0},//30
				{0.0, 0.0},
				{0.0, 0.0},
				{0.0, 0.0},
				{0.0, 0.0},
				{0.0, 0.0},//35
			};
		}
		throw new MapNotFoundException("No such Map");
	}
	
}
