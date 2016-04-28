package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Up extends Command {
	private static Up up;
	private static GameWorld game;

	Up(GameWorld myGame) {
		super("Up");
		Up.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Net is moving up");
		game.up();
	}

}
