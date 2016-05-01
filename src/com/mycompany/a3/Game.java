package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.events.*;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;

public class Game extends Form implements Runnable{
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private boolean isGamePaused;
	private UITimer timer;

	private Button expand = new Button();
	private Expand myExpand = new Expand(gw);
	private Button up = new Button();
	private Up myUp = new Up(gw);
	private Button left = new Button();
	private Left myLeft = new Left(gw);
	private Button jumpToDog = new Button();
	private TransferDog jumpDog = new TransferDog(gw);
	private Button contract = new Button();
	private Contract myContract = new Contract(gw);
	private Button down = new Button();
	private Down myDown = new Down(gw);
	private Button right = new Button();
	private Right myRight = new Right(gw);
	private Button jumptocat = new Button();
	private TransferCat jumpCat = new TransferCat(gw);
	private Button scoop = new Button();
	private Scoop myScoop = new Scoop(gw);
	private Button heal = new Button();
	private Heal myHeal = new Heal(gw);
	private Button pause = new Button();
	private Pause myPause = new Pause(this);
	private Button play = new Button();
	
	//private Tick tickCmd = Tick.getInstance();

	public Game() {
		gw = new GameWorld();
		mv = new MapView(gw);
		sv = new ScoreView(gw);
		
		gw.initLayout();
		gui();

		timer = new UITimer(this);
		timer.schedule(20, true, this);
		

		gw.addObserver(mv);
		gw.addObserver(sv);
		gw.notifyObservers();
		
		
		//Dimension worldSize = new Dimension(myContainer.getWidth(), myContainer.getHeight());
		// play();
	}
	public void run() {
		if(!isGamePaused) {
			gw.clockTick();
		}
		repaint();
	}
	private void gui() {
//		sv = new ScoreView(gw);
//		mv = new MapView(gw);
		setLayout(new BorderLayout());
		Container totalContainer = new Container(new GridLayout(1000, 800));
		totalContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.YELLOW));
		totalContainer.setLayout(new BorderLayout());

		add(BorderLayout.NORTH, sv);

		// Side Menu Options
		Toolbar toolBar = new Toolbar();
		setToolbar(toolBar);
		Label myText = new Label("Dog Catcher");
		toolBar.setTitleComponent(myText);

		Command sideItem1 = new Command("File") {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Further additions will be added in the future");
			}
		};
		toolBar.addCommandToSideMenu(sideItem1);

		CheckBox soundCheck = new CheckBox("Toggle Sound");
		// Command sideSound = new Command("Toggle Sound");
		Sound mySound = new Sound(gw);
		soundCheck.setCommand(mySound);
		mySound.putClientProperty("Sound toggle", soundCheck);
		toolBar.addCommandToSideMenu(mySound);

		Command sideAbout = new Command("About") {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Andrew Kwon, CSC133, A3Prj");
				Dialog.show("Game: Dog Catcher by Andrew Kwon, CSC133, A3Prj", "", "", "Cancel");
			}
		};
		toolBar.addCommandToSideMenu(sideAbout);

		Command sideHelp = new Command("Help?") {
			@Override
			public void actionPerformed(ActionEvent e) {
				Dialog.show("Commands",
						"e: Expand Net\n" + "u: Move net up\n" + "l: Move net left\n" + "o: Transfer net to Dog\n"
								+ "c: Contract net\n" + "d: Move net down\n" + "r: Move net right\n"
								+ "a: Transfer net to Cat\n" + "s: Net scoops\n" + "k: Cats collide and make Kitten\n"
								+ "f: Cat and Dog Fight\n" + "t: Clock ticks",
						"", "Cancel");
			}
		};
		toolBar.addCommandToRightBar(sideHelp);
		// Commands classes
		// Container leftContainer = new Container(new
		// BoxLayout(BoxLayout.Y_AXIS));
		Container leftContainer = new Container(new GridLayout(5, 1));
		leftContainer.getAllStyles().setPadding(Component.TOP, 90);

		expand.setCommand(myExpand);
		expand.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		expand.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		expand.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		expand.getUnselectedStyle().setBgTransparency(255);
		leftContainer.add(expand);
		addKeyListener('e', myExpand);
		// leftContainer.add(Expand.getInstance());
		// this.addKeyListener('e', (ActionListener) e);
		up.setCommand(myUp);
		up.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		up.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		up.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		up.getUnselectedStyle().setBgTransparency(255);
		leftContainer.add(up);
		addKeyListener('u', myUp);
		// leftContainer.add(Up.getInstance());
		// this.addKeyListener('u', (ActionListener) e);
		left.setCommand(myLeft);
		left.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		left.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		left.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		left.getUnselectedStyle().setBgTransparency(255);
		leftContainer.add(left);
		addKeyListener('l', myLeft);
		// leftContainer.add(Left.getInstance());
		// this.addKeyListener('l', (ActionListener) e);
		jumpToDog.setCommand(jumpDog);
		jumpToDog.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		jumpToDog.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		jumpToDog.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		jumpToDog.getUnselectedStyle().setBgTransparency(255);
		leftContainer.add(jumpToDog);
		addKeyListener('o', jumpDog);
		// leftContainer.add(TransferDog.getInstance());
		// this.addKeyListener('o', (ActionListener) e);
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));

		add(BorderLayout.WEST, leftContainer);

		// Container rightContainer = new Container(new
		// BoxLayout(BoxLayout.Y_AXIS));
		Container rightContainer = new Container(new GridLayout(6, 1));
		rightContainer.getAllStyles().setPadding(Component.TOP, 90);

		contract.setCommand(myContract);
		contract.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		contract.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		contract.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		contract.getUnselectedStyle().setBgTransparency(255);
		rightContainer.add(contract);
		addKeyListener('c', myContract);
		// rightContainer.add(Contract.getInstance());
		// this.addKeyListener('c', (ActionListener) e);
		down.setCommand(myDown);
		down.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		down.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		down.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		down.getUnselectedStyle().setBgTransparency(255);
		rightContainer.add(down);
		addKeyListener('d', myDown);
		// rightContainer.add(Down.getInstance());
		// this.addKeyListener('d', (ActionListener) e);
		right.setCommand(myRight);
		right.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		right.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		right.getUnselectedStyle().setBgTransparency(255);
		right.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		rightContainer.add(right);
		addKeyListener('r', myRight);
		// rightContainer.add(Right.getInstance());
		// this.addKeyListener('r', (ActionListener) e);
		jumptocat.setCommand(jumpCat);
		jumptocat.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		jumptocat.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		jumptocat.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		jumptocat.getUnselectedStyle().setBgTransparency(255);
		rightContainer.add(jumptocat);
		addKeyListener('a', jumpCat);
		// rightContainer.add(TransferCat.getInstance());
		// this.addKeyListener('a', (ActionListener) e);
		scoop.setCommand(myScoop);
		scoop.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		scoop.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		scoop.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		scoop.getUnselectedStyle().setBgTransparency(255);
		addKeyListener('s', myScoop);
		// rightContainer.add(Scoop.getInstance());
		// this.addKeyListener('s', (ActionListener) e);
		rightContainer.add(scoop);
		rightContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));

		add(BorderLayout.EAST, rightContainer);

		// Mapview
		add(BorderLayout.CENTER, mv);

		Container bottomContainer = new Container(new FlowLayout(Component.CENTER));
		bottomContainer.getAllStyles().setPadding(Component.RIGHT, 10);
		heal.getUnselectedStyle().setPadding(TOP, 5);
		heal.getUnselectedStyle().setPadding(BOTTOM, 5);
		//heal.getUnselectedStyle().setPadding(LEFT, 5);
		//heal.getUnselectedStyle().setPadding(RIGHT, 5);
		heal.getUnselectedStyle().setBgColor(ColorUtil.WHITE);
		heal.getUnselectedStyle().setFgColor(ColorUtil.BLUE);
		heal.getUnselectedStyle().setBgTransparency(255);
		heal.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		heal.setCommand(myHeal);
		addKeyListener('h',myHeal);
		bottomContainer.add(heal);
		pause.getUnselectedStyle().setPadding(TOP, 5);
		pause.getUnselectedStyle().setPadding(BOTTOM, 5);
		//pause.getUnselectedStyle().setPadding(LEFT, 5);
		//pause.getUnselectedStyle().setPadding(RIGHT, 5);
		pause.setCommand(myPause);
		pause.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		pause.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		pause.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		pause.getUnselectedStyle().setBgTransparency(255);
		addKeyListener('p', myPause);
		bottomContainer.add(pause);
		play.getUnselectedStyle().setPadding(TOP, 5);
		play.getUnselectedStyle().setPadding(BOTTOM, 5);
		play.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		play.getUnselectedStyle().setFgColor(ColorUtil.WHITE);
		play.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLUE));
		play.getUnselectedStyle().setBgTransparency(255);

		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.GRAY));

		add(BorderLayout.SOUTH, bottomContainer);

		Expand.setTarget(gw);
		Contract.setTarget(gw);
		Down.setTarget(gw);
		Fight.setTarget(gw);
		Kitten.setTarget(gw);
		Left.setTarget(gw);
		Right.setTarget(gw);
		Scoop.setTarget(gw);
		Sound.setTarget(gw);
		Tick.setTarget(gw);
		TransferCat.setTarget(gw);
		TransferDog.setTarget(gw);
		Up.setTarget(gw);
		Pause.setTarget(this);
		Heal.setTarget(gw);

		this.requestFocus();
		this.setVisible(true);
		this.show();

	}
	public boolean isPaused() {
		return isGamePaused;
	}
	public void pauseGame() {
		timer.cancel();
		isGamePaused = true;
		
		Dog dog = new Dog();
		IIterator iter = gw.objects.getIterator();
		while(iter.hasNext()){
			if(iter instanceof Dog) {
				dog.setSelected(true);
			}
		}
		heal.setEnabled(true);
		
		contract.setEnabled(false);
		down.setEnabled(false);
		expand.setEnabled(false);
		left.setEnabled(false);
		right.setEnabled(false);
		scoop.setEnabled(false);
		up.setEnabled(false);

		contract.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		contract.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		down.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		down.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		expand.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		expand.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		left.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		left.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		right.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		right.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		scoop.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		scoop.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		up.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		up.getDisabledStyle().setFgColor(ColorUtil.WHITE);

		removeKeyListener('c', myContract);
		removeKeyListener('d', myDown);
		removeKeyListener('e', myExpand);
		removeKeyListener('l', myLeft);
		removeKeyListener('r', myRight);
		removeKeyListener('s', myScoop);
		removeKeyListener('u', myUp);
		
	}
	public void resumeGame() {
		timer.schedule(20, true, this);
		isGamePaused = false;
		
		if(gw.isSoundOn()){
			//play background music again
		}
		
		Dog dog = new Dog();
		IIterator iter = gw.objects.getIterator();
		while(iter.hasNext()){
			if(iter instanceof Dog) {
				dog.setSelected(false);
			}
		}
		
		heal.setEnabled(false);
		heal.getDisabledStyle().setBgColor(ColorUtil.GRAY);
		heal.getDisabledStyle().setFgColor(ColorUtil.WHITE);
		
		contract.setEnabled(true);
		down.setEnabled(true);
		expand.setEnabled(true);
		left.setEnabled(true);
		right.setEnabled(true);
		scoop.setEnabled(true);
		up.setEnabled(true);
		addKeyListener('c', myContract);
		addKeyListener('d', myDown);
		addKeyListener('e', myExpand);
		addKeyListener('l', myLeft);
		addKeyListener('r', myRight);
		addKeyListener('s', myScoop);
		addKeyListener('u', myUp);
		
	}

}// play
