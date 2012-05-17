package warborn.view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import javax.media.*;
import javax.media.format.AudioFormat;
import javax.media.format.VideoFormat;
import javax.swing.JPanel;

/**
 * 
 * @author Deitel
 * @modifiedBy Markus Otterberg with help by Luca Bruno aka Lethalman
 *
 */
public class MediaPanel extends JPanel
{
	private Player mediaPlayer;
	private final int EXTERNAL_BUFFER_SIZE = 524288;
	
	public MediaPanel( URL mediaURL )
	{
		setLayout( new BorderLayout() ); // use a BorderLayout

		// Use lightweight components for Swing compatibility
		Manager.setHint( Manager.LIGHTWEIGHT_RENDERER, true );

		try
		{
			Format[] inFormats = { new VideoFormat ("DIVX") };
			Format[] inFormats2 = { new AudioFormat ("mpeglayer3") };

			PlugInManager.addPlugIn ("net.sourceforge.jffmpeg.VideoDecoder", inFormats, null, PlugInManager.CODEC);
			PlugInManager.addPlugIn ("net.sourceforge.jffmpeg.AudioDecoder", inFormats2, null, PlugInManager.CODEC);

			PlugInManager.commit ();
			
			// create a player to play the media specified in the URL
			mediaPlayer = Manager.createRealizedPlayer( mediaURL );

			// get the components for the video and the playback controls
			Component video = mediaPlayer.getVisualComponent();

			if ( video != null )
				add( video, BorderLayout.CENTER ); // add video component

		} // end try
		catch ( NoPlayerException noPlayerException )
		{
			System.err.println( "No media player found" );
		} // end catch
		catch ( CannotRealizeException cannotRealizeException )
		{
			System.err.println( "Could not realize media player" );
		} // end catch
		catch ( IOException iOException )
		{
			System.err.println( "Error reading from the source" );
		} // end catch
	} // end MediaPanel constructor

	public void startPlaying(){
		mediaPlayer.prefetch();
		mediaPlayer.start();int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];

		try { 
			while (nBytesRead != -1) { 
				nBytesRead = audioInputStream.read(abData, 0, abData.length);
				if (nBytesRead >= 0) 
					mediaPlayer.write(abData, 0, nBytesRead);
			} 
		} catch (IOException e) { 
			e.printStackTrace();
			return;
		} finally { 
			auline.drain();
			auline.close();
		} 	
	}
	
	public void stopPlaying(){

		mediaPlayer.stop();
		mediaPlayer.close();
	}

	
} // end class MediaPanel