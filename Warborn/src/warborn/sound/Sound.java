package warborn.sound;

import java.applet.*;
import java.io.File;
import java.net.MalformedURLException;

public class Sound extends Applet{
	
	private AudioClip intro;
	
	public Sound(){
		try {
			intro = getAudioClip(new File("Warborn/sounds/intro.wav").toURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void playIntro(){
		intro.loop();
	}
	
	public void stopIntro(){
		intro.stop();
	}
}
