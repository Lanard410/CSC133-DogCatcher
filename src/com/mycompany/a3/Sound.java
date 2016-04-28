package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Sound extends Command {
	private static Sound sound;
	private static GameWorld game;

	Sound(GameWorld myGame) {
		super("Toggle Sound");
		Sound.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Sound toggle on or off");
		game.toggleSound();
	}

}
