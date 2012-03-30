package warborn.map;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public interface IMap extends Observer{

	JButton[] getButtons();
	
}	
