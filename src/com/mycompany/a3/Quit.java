package com.mycompany.a3;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class Quit extends Command {
	private static Quit quit;
	private static GameWorld game;

	Quit(GameWorld myGame) {
		super("Exit!");
		Quit.game = myGame;
	}

	// public static void setTarget(GameWorld gw) {
	// if(game == null) {
	// game = gw;
	// }
	// }
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Quiting the applications! Enter y or n");
		game.exit();
	}

}
