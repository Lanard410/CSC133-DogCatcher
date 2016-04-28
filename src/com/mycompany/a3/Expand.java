package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Expand extends Command {
	private static Expand expand;
	private static GameWorld game;

	Expand(GameWorld myGame) {
		super("Expand");
		Expand.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("expanding the net");
		game.expand();
	}
}
