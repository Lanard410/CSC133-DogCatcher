package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Fight extends Command {
	private static Fight fight;
	private static GameWorld game;

	Fight(GameWorld myGame) {
		super("Fight!");
		Fight.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("A fight has broke out!");
		game.prefight();

	}

}
