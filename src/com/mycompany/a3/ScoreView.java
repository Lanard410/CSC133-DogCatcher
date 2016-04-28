package com.mycompany.a3;

import java.util.*;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

public class ScoreView extends Container implements Observer {

	private Label totalScore;
	private Label dogsCaptured;
	private Label catsCaptured;
	private Label dogsRemaining;
	private Label catsRemaining;
	private Label sound;
	private GameWorld gw;
	// private Observable o;

	ScoreView(GameWorld game) {
		totalScore = new Label("  Total Score: " + game.getTotalScore());
		dogsCaptured = new Label("  Dogs Captured: " + game.getDogsCaptured());
		catsCaptured = new Label("Cats Captured: " + game.getCatsCaptured());
		dogsRemaining = new Label("Dogs Remaining: " + game.getDogsRemaining());
		catsRemaining = new Label("Cats Remaining: " + game.getCatsRemaining());
		sound = new Label("Sound: " + game.isSoundOn());
		setLayout(new FlowLayout(Component.CENTER));
		// Container topContainer = new Container(new GridLayout(1,6));
		Container topContainer = new Container();
		totalScore.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(totalScore);
		dogsCaptured.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(dogsCaptured);
		catsCaptured.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(catsCaptured);
		dogsRemaining.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(dogsRemaining);
		catsRemaining.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(catsRemaining);
		sound.getAllStyles().setFgColor(ColorUtil.BLUE);
		topContainer.add(sound);
		topContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.WHITE));
		// add(BorderLayout.NORTH, topContainer);
		add(topContainer);

		this.gw = game;
	}

	public void update(Observable o, Object args) {
		// code here to update labels from game state data in GameWorld
		// (Observable)
		totalScore.setText("Total Score: " + gw.getTotalScore());
		dogsCaptured.setText("Dogs Captured: " + gw.getDogsCaptured());
		catsCaptured.setText("Cats Captured: " + gw.getCatsCaptured());
		dogsRemaining.setText("Dogs Remaining: " + gw.getDogsRemaining());
		catsRemaining.setText("Cats Remaining: " + gw.getCatsRemaining());
		if (gw.isSoundOn()) {
			sound.setText("Sound: on");
		} else {
			sound.setText("Sound: off");
		}
		this.setVisible(true);
	}

}
