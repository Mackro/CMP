package warborn.sound;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.*;

import warborn.model.Warborn;
/**
 * 
 * @author  AnyExample 2010
 * 
 * modified by Rickard Hallberg
 *
 */
public class Sound extends Thread implements Observer{
	
	private String theme;
	private AudioInputStream audioInputStream;
	SourceDataLine auline;
	private final int EXTERNAL_BUFFER_SIZE = 524288, OFFSET = 0;
	private boolean startMenu = false, activeGame = false, battle = false, shallRun = false;
	

	public Sound(){
		theme = "WarbornData/sounds/introTheme.wav";
	}

	public void loadMusic(){
		while(true){
			while(shallRun){
				File soundFile = new File(theme);
				try {
					audioInputStream = AudioSystem.getAudioInputStream(soundFile);
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				AudioFormat format = audioInputStream.getFormat();
				DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

				try { 
					auline = (SourceDataLine)AudioSystem.getLine(info);
					auline.open(format);
					startMusic();
				} catch (LineUnavailableException e) { 
					e.printStackTrace();
					return;
				} catch (Exception e) { 
					e.printStackTrace();
					return;
				}
			}
		}
	}
	
	
	
	public void startMusic(){
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

		try { 
			while (nBytesRead != -1) { 
				nBytesRead = audioInputStream.read(abData, OFFSET, abData.length);
				if (nBytesRead >= 0) 
					auline.write(abData, OFFSET, nBytesRead);
			} 
		} catch (IOException e) { 
			e.printStackTrace();
			return;
		} finally { 
			auline.drain();
			auline.close();
		} 	
	}
	
	public void stopMusic(){
		shallRun = false;
		auline.stop();
	}
	
	public void run(){
		shallRun = true;
		loadMusic();
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Warborn){
			Warborn model = (Warborn)o;
			if(model.getState() == -1 && startMenu == false){
				startMenu = true;
				theme = "WarbornData/sounds/introTheme.wav";
				stopMusic();
				shallRun = true;
			}
			else if(model.getState() == 0 && activeGame == false){
				startMenu = false;
				activeGame = true;
				theme = "WarbornData/sounds/gameTheme.wav";
				stopMusic();
				shallRun = true;
			}
			else if(model.getState() == 2 && model.getPhase() == 0 && battle){
				battle = false;
				theme = "WarbornData/sounds/gameTheme.wav";
				stopMusic();
				shallRun = true;
			}
			else if(model.getState() == 2 && model.getPhase() == 1 && battle == false){
				battle = true;
				theme = "WarbornData/sounds/battleTheme.wav";
				stopMusic();
				shallRun = true;
			}
		}
		
	}
}


