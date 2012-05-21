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

	//returns the DisplayMode with the highest width
	public DisplayMode getHighestResolutionDisplayMode(){
		DisplayMode[] videoCardModes = videoCard.getDisplayModes();
		int highest = 0;
		for(int k = 1; k < videoCardModes.length; k++){
			if(videoCardModes[highest].getWidth() < videoCardModes[k].getWidth()){
				highest = k;
			}else if(videoCardModes[highest].getWidth() == videoCardModes[k].getWidth()
					&& videoCardModes[highest].getHeight() < videoCardModes[k].getHeight()){
				highest = k;
			}else if(videoCardModes[highest].getWidth() == videoCardModes[k].getWidth()
					&& videoCardModes[highest].getHeight() == videoCardModes[k].getHeight()
					&& videoCardModes[highest].getBitDepth() < videoCardModes[k].getBitDepth()){
				highest = k;
			}
		}
		return videoCardModes[highest];
	}
	
	//Returns the default Graphics Configuration of this Graphics Device
	public GraphicsConfiguration getDefaultGraphicsConfiguration(){
		return videoCard.getDefaultConfiguration();
	}

	//Makes new frame fullScreen
	public void setFullScreen(){
		setFullScreen(new JFrame(videoCard.getDefaultConfiguration()));
	}

	//Makes frame fullScreen
	public void setFullScreen(JFrame frame){
		videoCard.setFullScreenWindow(frame);
		frame.validate();
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
