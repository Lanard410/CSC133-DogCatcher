package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;

public class Cat extends Animal implements ICollider, IGuide, IDrawable {
	private int colorR = 250;
	private int colorG = 250;
	private int colorB = 210;
	private int currentX = 0; private int incX = 3;
	private int currentY = 0; private int incY = 3;
	private GameWorld gw;
	Random rand;
	Image image = null;
	private int size = 35;
	
	public int getColorR() {return colorR;}
	public void setColorR(int colorR) {this.colorR = colorR;}
	public int getColorG() {return colorG;}
	public void setColorG(int colorG) {this.colorG = colorG;}
	public int getColorB() {return colorB;}
	public void setColorB(int colorB) {this.colorB = colorB;}
	
	@Override
	public String toString() {
		return ("Cat: loc = (" + getLocationX() + ", " + getLocationY() + "), color = [" + getColorR() + ","
				+ getColorG() + "," + getColorB() + "], size = " + getSize() + ", speed = " + getSize() + ", dir = "
				+ getDirection() + "\n");
	}

	public void setColor(int color) {
		color = ColorUtil.rgb(250, 250, 210);

	}
	public void move(Dimension dCmp){
		//update the object position
		currentX += incX;
		currentY += incY;
		
		//reverse the next movement direction
		if((currentX + size >= dCmp.getWidth()) || (currentX < 0)){
			incX = -incX;
		}
		if((currentY + size >= dCmp.getHeight()) || (currentY < 0)){
			incY = -incY;
		}
	}
	public void draw(Graphics g, Point pCmp) {
		g.setColor(ColorUtil.YELLOW);
		Point top = new Point((int)getLocationX(),(int)getLocationY()+ (getSize()/2));
		Point bottomL = new Point((int)getLocationX()-(getSize()/2),(int)getLocationY()-(getSize()/2));
		Point bottomR = new Point((int)getLocationX()+(getSize()/2),(int)getLocationY()-(getSize()/2));
		g.drawLine(pCmp.getX()+ top.getX(), pCmp.getY()+top.getY(), pCmp.getX()+bottomL.getX(), pCmp.getY()+bottomL.getY());
		g.drawLine(pCmp.getX()+bottomL.getX(), pCmp.getY()+bottomL.getY(), pCmp.getX()+bottomR.getX(), pCmp.getY()+bottomR.getY());
		g.drawLine(pCmp.getX()+bottomR.getX(), pCmp.getY()+bottomR.getY(), pCmp.getX()+top.getX(), pCmp.getY()+top.getY());
		//g.drawImage(image, pCmp.getX() + currentX, pCmp.getY()+ currentY, size, size);
	}
	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		int thisCenterX = (int) (this.getLocationX() + (getSize()/2));
		int thisCenterY = (int) (this.getLocationY() + (getSize()/2));
		int otherCenterX = (int) (((GameObject) otherObject).getLocationX() + ((GameObject) otherObject).getSize()/2);
		int otherCenterY = (int) (((GameObject) otherObject).getLocationY() + ((GameObject) otherObject).getSize()/2);
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distBetweenCenters = (dx*dx + dy*dy);
		int thisRadius = getSize()/2;
		int otherRadius = getSize()/2;
		int radii = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
		if(distBetweenCenters <= radii) {
			result = true;
		}
		return result;
	}

	public void handleCollision(ICollider otherObject) {
		//change color by generating three random colors
//		IIterator iter = gw.objects.getIterator();
//		while(iter.hasNext()){
//			if(iter instanceof Cat){
//				gw
//			}
//		}
		gw.precatCollide();
//		Cat cat1 = new Cat();
//		Cat cat2 = new Cat();
//		if(cat1.collidesWith(cat2) && cat2.collidesWith(cat1)){
//			int randomR = this.rand.nextInt(256);
//			int randomG = this.rand.nextInt(256);
//			int randomB = this.rand.nextInt(256);
//			this.setColor(ColorUtil.rgb(randomR, randomG, randomB));
//		}
		
	}

}
