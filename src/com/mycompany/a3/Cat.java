package com.mycompany.a3;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Point;
import com.codename1.ui.geom.Point2D;

public class Cat extends Animal implements ICollider, IDrawable {
	private int colorR = 250;
	private int colorG = 250;
	private int colorB = 210;
	private GameWorld gw;
	private int count = 0;
	private int currentX = 0; private int incX = 3;
	private int currentY = 0; private int incY = 3;
	private boolean collision;
	private int direction;
	Random rand;
	Image image = null;
	
	Cat() {
		rand = new Random();
		setColor(ColorUtil.rgb(250, 250, 210));
		setLocation(rand.nextInt(750), rand.nextInt(600));
		setSize(rand.nextInt(40)+20);
		setDirection(rand.nextInt(360));
		
	}
	
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
	public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
//	public void move(int m) {
//		if(count > 0){
//			count--;
//		}
//        direction = direction + randInt(-10, 10);
//        int theta = 90 - direction;
//        Math.toRadians((double)theta);
//        //update new location
//        Point2D newLocation = new Point2D(0, 0);
//        newLocation.setX((getLocationX() + ((double) Math.cos(theta)) * getSpeed()));
//        newLocation.setY((getLocationY() + ((double) Math.sin(theta)) * getSpeed()));
//
//        //this.setLocation((com.codename1.ui.geom.Point2D) newLocation);
//
////        Point2D newLocation;
////        newLocation.setLocation(getObjLocation().x + ((float) Math.cos(theta) * speed, getObjLocation().y + ((float) Math.sin(theta) * speed);
////        newLocation.y = getObjLocation().y + ((float) Math.sin(theta) * speed);
////        setObjLocation(newLocation);
//
//    }

	public void draw(Graphics g, Point pCmp) {
		g.setColor(ColorUtil.YELLOW);
        int[] xPoints = {(int) this.getLocationX()+pCmp.getX(),
                (int) this.getLocationX()+this.getSize()+pCmp.getX(),
                (int) this.getLocationX()+(this.getSize()/2)+pCmp.getX()};
        int[] yPoints = {(int) this.getLocationY()+pCmp.getY(),
                (int) this.getLocationY()+pCmp.getY(),
                (int) this.getLocationY()+this.getSize()+pCmp.getY()};
//		Point top = new Point((int)getLocationX(),(int)getLocationY()+ (getSize()/2));
//		Point bottomL = new Point((int)getLocationX()-(getSize()/2),(int)getLocationY()-(getSize()/2));
//		Point bottomR = new Point((int)getLocationX()+(getSize()/2),(int)getLocationY()-(getSize()/2));
		g.fillPolygon(xPoints, yPoints, 3);
//		g.drawLine(pCmp.getX()+ top.getX(), pCmp.getY()+top.getY(), pCmp.getX()+bottomL.getX(), pCmp.getY()+bottomL.getY());
//		g.drawLine(pCmp.getX()+bottomL.getX(), pCmp.getY()+bottomL.getY(), pCmp.getX()+bottomR.getX(), pCmp.getY()+bottomR.getY());
//		g.drawLine(pCmp.getX()+bottomR.getX(), pCmp.getY()+bottomR.getY(), pCmp.getX()+top.getX(), pCmp.getY()+top.getY());
		//g.drawImage(image, pCmp.getX() + currentX, pCmp.getY()+ currentY, size, size);
	}
	public boolean collidesWith(ICollider otherObject) {
//		if(count != 0){
//			return false;
//		}
		if(otherObject instanceof Cat) {
			Cat cat = (Cat) otherObject;
			if((cat.getLocationX() > this.getLocationX() && cat.getLocationX() < this.getLocationX() + this.getSize())
					|| (cat.getLocationX() + cat.getSize() > this.getLocationX() && cat.getLocationX() + cat.getSize() < this.getLocationX() + this.getSize()) ){
				if((cat.getLocationY() > this.getLocationY() && cat.getLocationY() < this.getLocationY() + this.getSize())
						|| (cat.getLocationY() + cat.getSize() > this.getLocationY() && cat.getLocationY() + cat.getSize() < this.getLocationY() + this.getSize()) ){
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}
		}else{
			return false;
		}


		//boolean result = false;
		//		int thisCenterX = (int) (this.getLocationX() + (getSize()/2));
		//		int thisCenterY = (int) (this.getLocationY() + (getSize()/2));
//		int otherCenterX = (int) (((GameObject) otherObject).getLocationX() + ((GameObject) otherObject).getSize()/2);
//		int otherCenterY = (int) (((GameObject) otherObject).getLocationY() + ((GameObject) otherObject).getSize()/2);
//		int dx = thisCenterX - otherCenterX;
//		int dy = thisCenterY - otherCenterY;
//		int distBetweenCenters = (dx*dx + dy*dy);
//		int thisRadius = getSize()/2;
//		int otherRadius = getSize()/2;
//		int radii = (thisRadius*thisRadius + 2*thisRadius*otherRadius + otherRadius*otherRadius);
//		if(distBetweenCenters <= radii) {
//			result = true;
//		}
//		return result;
	}

	public void handleCollision(ICollider otherObject) {
		//change color by generating three random colors
//		IIterator iter = gw.objects.getIterator();
//		while(iter.hasNext()){
//			if(iter instanceof Cat){
//				gw
//			}
//		}
		if(otherObject instanceof Cat){
			count = 1000;
			gw.precatCollide();
			
		}
		
	}


}
