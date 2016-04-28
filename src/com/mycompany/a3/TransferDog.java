package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class TransferDog extends Command {
	private static TransferDog transferdog;
	private static GameWorld game;

	TransferDog(GameWorld myGame) {
		super("JumpToADog");
		TransferDog.game = myGame;
	}

	public static void setTarget(GameWorld gw) {
		if (game == null) {
			game = gw;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Transfering Net to a Dog");
		game.transferD();
	}

}
