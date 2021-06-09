package Framework.audio;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio
{
	
	private Clip clip = null ; 
	private FloatControl gainControl; //controls how loud the sound is 
	public Audio(String path) 
	{
		try
		{
			InputStream audioSource = Audio.class.getResourceAsStream(path); 
			InputStream buffered = new BufferedInputStream(audioSource); 
			AudioInputStream ais = AudioSystem.getAudioInputStream(buffered);
			
			AudioFormat baseFormat = ais.getFormat(); 
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 
																				baseFormat.getSampleRate(),16,
																				baseFormat.getChannels(),
																				baseFormat.getChannels()*2,
																				baseFormat.getSampleRate(),
																				false);
			
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais); 
			
			clip = AudioSystem.getClip(); 
			clip.open(dais);
			gainControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN); 
			
			
			
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public  void play()
	{
		if(clip== null)
		{
			return ; 
		}
		
		stop(); 
		
		clip.setFramePosition(0);
		while(!clip.isRunning())
		{
			clip.start();
		}
		
		
	}
	
	public void stop()
	{
		if(clip.isRunning())
		{
			clip.stop();
		}
	}
	
	public void close()
	{
		stop(); 
		clip.drain(); 
		clip.close(); 
		
	}
	
	public void loop()  // if you want a song to loop (like background music) 
	{
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
		play(); 
	}
	
	public void setVolume(float value)
	{
		gainControl.setValue(value);
	}
	
	public boolean isRunning()
	{
		return clip.isRunning(); 
	}
	
}
