package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Contract extends Command {
	private static Contract contract;
	private static GameWorld game;

	Contract(GameWorld myGame) {
		super("Contract Net");
		Contract.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Net has decreased in size");
		game.contract();

	}

}
