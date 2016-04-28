package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TransferCat extends Command {
	private static TransferCat transfercat;
	private static GameWorld game;

	TransferCat(GameWorld myGame) {
		super("JumpToACat");
		TransferCat.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Moving Net to Cats");
		game.transferC();
	}

}
