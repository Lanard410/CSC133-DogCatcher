package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Right extends Command {
	private static Right right;
	private static GameWorld game;

	public Right(GameWorld myGame) {
		super("Right");
		Right.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Net moving right");
		game.right();
	}

}
