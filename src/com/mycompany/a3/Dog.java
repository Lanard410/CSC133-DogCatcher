package com.mycompany.a3;

import java.util.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
//import com.codename1.charts.models.Point;

public class Dog extends Animal implements ICollider, IDrawable, IGuide, ISelectable{
	private int scratch;
	private int speed;
	private Random rand;
	private GameWorld gw;
	private int colorR = 0;
	private int colorG = 0;
	private int colorB = 0;
	private boolean selected;
	private int currentX = 0; private int incX = 3;
	private int currentY = 0; private int incY = 3;
	Image image = null;
	private int size = 35;

	// Dog information that pertains to the dog in class
	public int getColorR() {return colorR;}
	public void setColorR(int colorR) {this.colorR = colorR;}
	public int getColorG() {return colorG;}
	public void setColorG(int colorG) {this.colorG = colorG;}
	public int getColorB() {return colorB;}
	public void setColorB(int colorB) {this.colorB = colorB;}

	public int getScratch() {return scratch;}

	public void setScratch(int scratch) {this.scratch = scratch;}

	public void setSelected(boolean select) {
		selected = select;
	}
	public boolean isSelected() {
		return selected;
	}
	public void resetScratches() {
		scratch = 0;
	}

	public void scratched() {
		scratch++;
		speed--;
		if (scratch > 5) {
			scratch = 5;
		}
		if (speed < 0) {
			speed = 0;
		}
	}


	@Override
	public String toString() {
		return ("Dog: loc = (" + getLocationX() + ", " + getLocationY() + "), color = [" + getColorR() + ","
				+ getColorG() + "," + getColorB() + "], size = " + getSize() + ", dir = " + getDirection()
				+ ", scratches = " + getScratch() + "\n");
	}
	//move object within boundaries
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
		//g.drawArc(getX(), getY(), width, height, 0, 360);
		//int halfSize = getSize()/2;
		//g.drawImage(image, pCmp.getX() + currentX, pCmp.getY()+ currentY, size, size);
		Dog dog = new Dog();
		int xLoc = (int) (pCmp.getX()+getLocationX());
		int yLoc = (int) (pCmp.getY()+getLocationY());
		g.setColor(ColorUtil.BLACK);
		if(dog.isSelected()) {
			g.fillArc(xLoc, yLoc, getSize(), getSize(), 0, 360);
		}else {
			g.drawArc(xLoc, yLoc, getSize(), getSize(), 0, 360);
		}
	}
	public boolean contains(Point pPtr, Point pCmp) {
		int px = pPtr.getX();
		int py = pPtr.getY();
		int xLoc = (int) (pCmp.getX()+getLocationX());
		int yLoc = (int) (pCmp.getY()+getLocationY());
		if((px >= xLoc) && (px <= xLoc+getSize()) && (py>=yLoc) && (py <= yLoc+getSize())){
			return true;
		}else {
			return false;
		}
	}

	public void setColor(int bLACK) {
		ColorUtil.rgb(0, 0, 0);

	}

	public boolean collidesWith(ICollider otherObject) {
		boolean result = false;
		int thisCenterX = (int) (this.getLocationX() + (getSize()/2));
		int thisCenterY = (int) (this.getLocationY() + (getSize()/2));
		int otherCenterX = (int) (((GameObject) otherObject).getLocationX() + (((GameObject) otherObject).getSize()/2));
		int otherCenterY = (int) (((GameObject) otherObject).getLocationY() + (((GameObject) otherObject).getSize()/2));
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
		gw.prefight();
//		Dog dog1 = new Dog();
//		Dog dog2 = new Dog();
//		Cat cat1 = new Cat();
//		if(dog1.collidesWith(dog2) && dog2.collidesWith(dog1)){
//			//gw.prefight();
//			int randomR = this.rand.nextInt(256);
//			int randomG = this.rand.nextInt(256);
//			int randomB = this.rand.nextInt(256);
//			this.setColor(ColorUtil.rgb(randomR, randomG, randomB));
//		}

		int speed = getSpeed();
		speed--;
		if(speed==0){
			setSpeed(speed);
			setColor(ColorUtil.rgb(255, 0, 0));
		}
		
	}

}
