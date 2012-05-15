package warborn.main;

import java.awt.GridBagConstraints;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

import warborn.view.MediaPanel;

public class IntroMovie {
	
	private static long startTime;
	private static MediaPanel mediaPanel;

	public static void play(JFrame frame) {
		File intro = new File("WarbornData/images/CMP1920.avi");
		URL mediaUrl = null;
		try {
			mediaUrl = intro.toURL();
		} catch (MalformedURLException e) {
			System.err.println( "Could not create URL for the file" );
		}
		if(mediaUrl != null){
			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 1;
			c.ipady = (int) (frame.getHeight());
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx = 0;
			c.gridy = 0;
			c.weighty = 1;
			mediaPanel = new MediaPanel( mediaUrl );
			frame.add( mediaPanel, c, 0);

			frame.setVisible( true );
			startTime = System.currentTimeMillis();
			mediaPanel.startPlaying();
		}
		

	}

	public static boolean isPlaying() {
		
		return System.currentTimeMillis() - startTime >= 35000?false:true;
	}
	
	public static void stopPlaying(JFrame frame){
		mediaPanel.stopPlaying();
		//frame.remove(mediaPanel);
		frame.validate();
	}
}
