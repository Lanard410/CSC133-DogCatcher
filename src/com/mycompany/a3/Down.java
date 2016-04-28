package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Down extends Command {
	private static Down down;
	private static GameWorld game;

	Down(GameWorld myGame) {
		super("Down");
		Down.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Net has moved down");
		game.down();
	}

}
