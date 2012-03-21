package warborn.map;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class TestGothenburg {

	
	static Toolkit tk = Toolkit.getDefaultToolkit();
    static Dimension d = tk.getScreenSize();
    
	public static void main (String [] args){
		JFrame jf = new JFrame();
		jf.setSize(getWidth(), getHeight());
		GothenburgMapView gmv = new GothenburgMapView();
		jf.add(gmv);
		jf.setVisible(true);
	}
	
	public static int getWidth(){
		return (int) d.getWidth();
	}
	public static int getHeight(){
		return (int) d.getHeight();
	}


}
