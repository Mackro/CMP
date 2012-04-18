package warborn.sound;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
/**
 * 
 * @author  AnyExample 2010
 * 
 * modified by Rickard Hallberg
 *
 */
public class Sound extends Thread{
	
	private String intro;
	private AudioInputStream audioInputStream;
	SourceDataLine auline;
	private final int EXTERNAL_BUFFER_SIZE = 524288;

	public Sound(){
		intro = "WarbornData/sounds/intro.wav";
		File soundFile = new File(intro);
		try {
			audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AudioFormat format = audioInputStream.getFormat();
		auline = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

		try { 
			auline = (SourceDataLine)AudioSystem.getLine(info);
			auline.open(format);
		} catch (LineUnavailableException e) { 
			e.printStackTrace();
			return;
		} catch (Exception e) { 
			e.printStackTrace();
			return;
		}
	}
	
	public void playIntro(){
		auline.start();
		int nBytesRead = 0;
        byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
 
        try { 
            while (nBytesRead != -1) { 
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead);
            } 
        } catch (IOException e) { 
            e.printStackTrace();
            return;
        } finally { 
            auline.drain();
            auline.close();
        } 
	}
	
	public void stopIntro(){
		auline.stop();
	}
	
	public void run(){
		playIntro();
		System.out.println("wiiiiiiiiiiii");
	}
}


