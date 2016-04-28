package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Pause extends Command{
	private static Game game;
	
	Pause(Game myGame) {
		super("Pause");
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
		}else if(!game.isPaused()){
			game.pauseGame();
		}
		
	}

}
