package com.mycompany.a3;

import java.io.IOException;
import java.io.InputStream;

import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;

public class SoundClass implements Runnable{
	private static SoundClass sounds;
	private Media m;
	
	public void playSound(String file){
		try{
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), file);
			Media m = MediaManager.createMedia(is, "audio/wav");
			m.play();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void someOtherSound() {
		playSound("signal.wav");
	}
	public void play() {
		m.play();
	}
	public void pause() {
		m.pause();
	}
	public void run() {
		m.setTime(0);
		m.play();
	}
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
	}

}
