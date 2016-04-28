package com.mycompany.a3;

import java.util.Collection;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.util.UITimer;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.layouts.BorderLayout;

public class MapView extends Container implements Observer {
	// private int width;
	// private int height;
	private int iX;
	private int iY;
	private GameWorld gw;
	private Graphics myGraphics;
	GameObjectCollection goc;
	Collection c;
	UITimer timer;
	Vector<Dog> theWorld = new Vector<Dog>();

	MapView(GameWorld mygame) {
		setLayout(new BorderLayout());
		setWidth(1000);
		setHeight(610);
		getAllStyles().setBgTransparency(255);
		getAllStyles().setBorder(Border.createLineBorder(2,ColorUtil.BLUE));

		this.gw = mygame;

	}

	public void update(Observable o, Object args) {
		// code here to call the method in GameWorld that output the game object
		// information to the console
		gw = (GameWorld) o;
		goc = gw.getGameObjectCollection();
		c = gw.getStart();
		repaint();
		if (o instanceof GameWorld) {
			gw.printMap();
		}
		if(gw.getDogsRemaining() <= 0){
			timer.cancel();
			Dialog.show("Game Complete!", "","", "Cancel");
				
			
		}
	}
	@Override
	public void pointerPressed(int x, int y) {
		//save the pointer pressed location
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtr = new Point(x,y);
		Point pCmp = new Point(getX(),getY());
		for(int i = 0; i<theWorld.size(); i++ ){
			if(theWorld.elementAt(i).contains(pPtr,pCmp)) {
				theWorld.elementAt(i).setSelected(true);
			}else {
				theWorld.elementAt(i).setSelected(false);
			}
			repaint();
		}
		
	}
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Point pCmp = new Point(getWidth(), getHeight());
		Object next;
		IIterator iter = gw.objects.getIterator();
		while(iter.hasNext()){
			next = iter.getNext();
			if(next instanceof Cat) {
				Cat cat = (Cat) next;
				cat.draw(g, pCmp);
			}
			if(next instanceof Dog) {
				Dog dog = (Dog) next;
				dog.draw(g, pCmp);
			}
			if(next instanceof Net) {
				Net net = (Net) next;
				net.draw(g, pCmp);
			}
		}
		//g.setColor(0xffffff);
		g.setColor(0xffffff);
		g.drawRect(iX-getParent().getAbsoluteX(), iY-getParent().getAbsoluteY(), 20, 40);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
		g.setColor(000000);
		g.drawString("", getX(), getY());
		g.resetAffine();
	}



}
