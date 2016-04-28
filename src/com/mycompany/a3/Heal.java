package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Heal extends Command{
	private static GameWorld game;

	Heal(GameWorld myGame){
		super("Heal");
		Heal.game = myGame;
	}
	
	public static void setTarget(GameWorld gw) {
		if(game == null) {
			game = gw;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You healed the Dog!");
		game.healDogs();
	}

}
