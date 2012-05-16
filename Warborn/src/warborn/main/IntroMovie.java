package warborn.main;

import java.awt.GridBagConstraints;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import warborn.view.MediaPanel;

public class IntroMovie {
	
	private static long startTime;
	private static MediaPanel mediaPanel;
	private static boolean forceStopPlay = false;

	@SuppressWarnings("deprecation")
	public static void play(JFrame frame, KeyAction keyAction) {
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

			mediaPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "skip");
			mediaPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "skip");
			mediaPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "skip");
			mediaPanel.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "skip");
			mediaPanel.getActionMap().put("skip", keyAction);
			
			frame.setVisible( true );
			startTime = System.currentTimeMillis();
			mediaPanel.startPlaying();
		}
		

	}

	public static boolean isPlaying() {
		
		return System.currentTimeMillis() - startTime >= 35000?false:(!forceStopPlay);
	}
	
	public static void stopPlaying(JFrame frame){
		if(isPlaying()){
			mediaPanel.stopPlaying();
			forceStopPlay = true;
			frame.remove(mediaPanel);
			frame.validate();
			frame.repaint();
			frame.revalidate();
		}
	}
}
