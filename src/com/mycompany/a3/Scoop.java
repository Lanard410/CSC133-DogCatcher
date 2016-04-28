package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Scoop extends Command {
	private static Scoop scoop;
	private static GameWorld game;

	Scoop(GameWorld myGame) {
		super("Scoop");
		Scoop.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Net Scooping up animals");
		game.scoop();
	}

}
