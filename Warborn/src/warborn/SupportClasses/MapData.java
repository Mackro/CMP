package warborn.SupportClasses;

import warborn.map.GothenburgMapView;
import warborn.map.IMap;
import warborn.model.Warborn;

public final class MapData {

	public static IMap[] getMapList(Warborn model){
		return new IMap[] {
				new GothenburgMapView(model),
		};
	}
	
	public static String[] getMapNames(){
		return new String[] {
			GothenburgMapView.toString(0),	
		};
	}
	
	public static double[][] getScalingConstants(IMap map){
		if(map instanceof GothenburgMapView){
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
		}
		return null;
	}
	
}
