package com.mycompany.a3;

import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;
import com.codename1.ui.events.ActionEvent;
import com.sun.media.jfxmedia.AudioClip;

public class SoundClass implements Runnable{
	private static SoundClass sounds;
	private Media m;
	private AudioClip catCollision;
	
	public SoundClass(String file){
		File fileish;
		String soundFolder = "." + File.separator + "src" + File.separator + "Sounds" + File.separator;
		String filename, filePath;
		
		filename = "meow.wav";
		filePath = soundFolder + filename;
		
		try{
			fileish = new File(filePath);
			if(fileish.exists()){
				//catCollision = Applet.newAudioClip(new File(filePath);
			}else {
				throw new RuntimeException("Sound file not found" + filePath);
			}
			InputStream is = Display.getInstance().getResourceAsStream(getClass(), "/" + file);
			Media m = MediaManager.createMedia(is, "audio/wav");
			m.play();
		}
		catch(IOException e){
			e.printStackTrace();
		}
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

}
