package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Tick extends Command {
	private static Tick tick;
	private static GameWorld game;

	Tick(GameWorld myGame) {
		super("Tick");
		Tick.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Clock is ticking");
		game.clockTick();
	}

}
