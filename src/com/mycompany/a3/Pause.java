package com.mycompany.a3;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Pause extends Command{
	private static Game game;
	private SoundClass bgSound;
	private Pause pause;
	private boolean pauseSound = false;
	
	Pause(Game myGame) {
		super("Pause/Play");
//		Button pButton = new Button("Pause/Play");
//		pButton.addActionListener(this);
//		bgSound = new SoundClass("alert.wav");
//		bgSound.play();
		Pause.game = myGame;
		
	}
	public static void setTarget(Game gw){
		if(game == null) {
			game = gw;
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e){
		System.out.print("Game has paused!");
		if(game.isPaused()){
			game.resumeGame();
			//bgSound.pause();
		}else if(!game.isPaused()){
			game.pauseGame();
			//bgSound.play();
		}
		
	}

}
