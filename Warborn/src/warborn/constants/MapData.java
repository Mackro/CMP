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
				{0.150, 0.180},//0
				{0.310, 0.150},
				{0.230, 0.200},
				{0.315, 0.232},
				{0.145, 0.270},
				{0.225, 0.280},//5
				{0.290, 0.295},
				{0.130, 0.400},
				{0.255, 0.410},
				{0.325, 0.405},
				{0.410, 0.100},//10
				{0.450, 0.180},
				{0.477, 0.110},
				{0.580, 0.050},
				{0.600, 0.175},
				{0.650, 0.125},//15
				{0.405, 0.300},
				{0.468, 0.260},
				{0.500, 0.302},
				{0.600, 0.305},
				{0.673, 0.365},//20
				{0.410, 0.400},
				{0.497, 0.420},
				{0.471, 0.550},
				{0.406, 0.427},
				{0.645, 0.405},//25
				{0.000, 0.000},
				{0.000, 0.000},
				{0.790, 0.090},
				{0.000, 0.000},
				{0.000, 0.000},//30
				{0.000, 0.000},
				{0.000, 0.000},
				{0.000, 0.000},
				{0.000, 0.000},
				{0.000, 0.000},//35
			};
		}
		throw new MapNotFoundException("No such Map");
	}
	
}
