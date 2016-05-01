package com.mycompany.a3;

import java.util.Formatter;
import java.util.Random;

import com.codename1.ui.geom.Dimension;

public abstract class Animal extends GameObject implements IGuide {
	private int direction;
	private int speed;
	private int count;
	private Random rand = new Random();
	private float x = 0, y = 0;

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void move() {
		// location = oldLocation + (deltaX, deltaY);
		if(count > 0) {
			count--;
		}

		float deltaX = (float) Math.cos(Math.toRadians((double) 90 - getDirection())) * getSpeed();
		float deltaY = (float) Math.sin(Math.toRadians((double) 90 - getDirection())) * getSpeed();
		float newLocationX = (getLocationX() + deltaX);
		float newLocationY = (getLocationY() + deltaY);
		
		x += deltaX;
		y += deltaY;
		
//		if(x > 1024.0f){
//			x = 974.0f;
//		}
//		if(x < 0.0f){
//			x = 50.0f;
//		}
//		if(y > 1024.0f) {
//			y = 974.0f;
//		}
//		if(y < 0.0f){
//			y = 50.0f;
//		}
//		
//		setLocation(x, y);
//		setDirection(rand.nextInt(360));
		
		if(newLocationX < 875-(getSize()/2) && newLocationX > 0 && newLocationY < 700-getSize() && newLocationY > 0 ){
			setLocation(newLocationX, newLocationY);
		}else {
			setDirection(rand.nextInt(360));
		}

//		if((x + getLocationX() >= 1024.0f) || (x < 0.0f)){
//			deltaX = -deltaX;
//		}
//		if((y + getLocationY() >= 1024.0f) || (y < 0.0f)) {
//			deltaY = -deltaY;
//		}
//		setLocation(deltaX, deltaY);
//		setDirection(rand.nextInt(360));
//		if (newLocationX < 1024 - (this.getSize() / 2) && newLocationY > (this.getSize() / 2)
//				&& newLocationY < 1024 - (this.getSize() / 2) && newLocationY > (this.getSize() / 2)) {
//			setLocation(newLocationX, newLocationY);
//		}else {
//			setDirection(rand.nextInt(360));
//		}
	}
}