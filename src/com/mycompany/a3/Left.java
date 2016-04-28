package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Left extends Command {
	private static Left left;
	private static GameWorld game;

	Left(GameWorld myGame) {
		super("Left");
		Left.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Moving net left");
		game.left();
	}

}
