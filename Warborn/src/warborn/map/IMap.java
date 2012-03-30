package warborn.map;

import java.util.Observer;
import javax.swing.JButton;

public interface IMap extends Observer{

	JButton[] getButtons();
	
}	
