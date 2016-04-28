package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Kitten extends Command {
	private static Kitten kitten;
	private static GameWorld game;

	Kitten(GameWorld myGame) {
		super("Kitten");
		Kitten.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("A Kitten is created!");
		game.precatCollide();

	}

}
