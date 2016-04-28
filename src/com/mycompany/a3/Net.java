package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Point;

public class Net extends Catcher implements IDrawable, ICollider{
	private int colorR = 0;
	private int colorG = 0;
	private int colorB = 0;
	private int currentX = 0; private int incX = 3;
	private int currentY = 0; private int incY = 3;
	Image image = null;
	Random rand;
	private int size = 35;

	public int getColorR() {return colorR;}
	public void setColorR(int colorR) {this.colorR = colorR;}
	public int getColorG() {return colorG;}
	public void setColorG(int colorG) {this.colorG = colorG;}
	public int getColorB() {return colorB;}
	public void setColorB(int colorB) {this.colorB = colorB;}

	@Override
	public String toString() {
		return ("Net: loc = (" + getLocationX() + ", " + getLocationY() + "), color = [" + getColorR() + ","
				+ getColorG() + "," + getColorB() + "], size = " + getSize() + "\n");
	}

	public void setColor(int i) {
		ColorUtil.rgb(0, 0, 0);

	}
//	public void move(Dimension dCmp){
//		//update the object position
//		currentX += incX;
//		currentY += incY;
//		
//		//reverse the next movement direction
//		if((currentX + size >= dCmp.getWidth()) || (currentX < 0)){
//			incX = -incX;
//		}
//		if((currentY + size >= dCmp.getHeight()) || (currentY < 0)){
//			incY = -incY;
//		}
//	}
	public void draw(Graphics g, Point pCmp) {
		int halfSize = getSize()/2;
		g.setColor(ColorUtil.BLACK);
		g.drawRect((int)getLocationX()-halfSize, (int)getLocationY()-halfSize, getSize(), getSize());
		//g.drawRect((int)getLocationX(),(int)getLocationY(),5,5);
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
//		int randomR = this.rand.nextInt(256);
//		int randomG = this.rand.nextInt(256);
//		int randomB = this.rand.nextInt(256);
//		this.setColor(ColorUtil.rgb(randomR, randomG, randomB));
		System.out.print("Net collision");
		
	}

}
