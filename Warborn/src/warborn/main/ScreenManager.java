package warborn.main;

import java.awt.*;
import javax.swing.*;

public class ScreenManager {
	
	private GraphicsDevice videoCard;
	
	//Give videoCard access to monitor
	public ScreenManager(){
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		videoCard = env.getDefaultScreenDevice();
	}

	//Compare DisplayModes to see if find a matching pair
	public DisplayMode getFirstCompatibleDisplayMode(DisplayMode[] modes){
		DisplayMode[] videoCardModes = videoCard.getDisplayModes();
		for(int i = 0; i < modes.length; i++){
			for(int k = 0; k < videoCardModes.length; k++){
				if(displayModesMatch(modes[i], videoCardModes[k])){
					return modes[i];
				}
			}
		}
		return null;
	}

	//checks if two modes match each other
	private boolean displayModesMatch(DisplayMode mode, DisplayMode mode2) {
		if(mode.getWidth() != mode2.getWidth() || mode.getHeight() != mode2.getHeight()){
			return false;
		}else if(mode.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
				mode2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI &&
				mode.getBitDepth() != mode2.getBitDepth()){
			return false;
		}else if(mode.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN &&
				mode2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN &&
				mode.getRefreshRate() != mode2.getRefreshRate()){
			return false;
		}
		return true;
	}
	
	//Makes new frame fullScreen
	public void setFullScreen(DisplayMode mode){
		setFullScreen(mode, new JFrame());
	}
	
	//Makes frame fullScreen
	public void setFullScreen(DisplayMode mode, JFrame frame){
		//JPanel p = new JPanel();
		//p.setBackground(Color.BLUE);
		//frame.add(p);
		frame.setUndecorated(true);
		//frame.setIgnoreRepaint(true);
		frame.setResizable(false);
		videoCard.setFullScreenWindow(frame);
		
		if(mode != null && videoCard.isDisplayChangeSupported()){
			try{
				videoCard.setDisplayMode(mode);
			}catch(Exception e){}
		}
		frame.createBufferStrategy(2);
		
	}
	
	//Restore screen to normal i.e. Exit program
	public void restoreScreen(){
		Window window = videoCard.getFullScreenWindow();
		if(window != null){
			window.dispose();
		}
		videoCard.setFullScreenWindow(null);
	}
	
	public int getWidth(){
		Window window = videoCard.getFullScreenWindow();
		if(window != null){
			return window.getWidth();
		}
		return 0;
	}
	
	public int getHeight(){
		Window window = videoCard.getFullScreenWindow();
		if(window != null){
			return window.getHeight();
		}
		return 0;
	}
	
}
