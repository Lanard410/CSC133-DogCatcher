package com.mycompany.a3;

import java.util.Random;

public abstract class Animal extends GameObject implements IGuide {
	private int direction;
	private int speed;
	private Random rand;

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

		float deltaX = (float) Math.cos(Math.toRadians((double) 90 - getDirection())) * getSpeed();
		float deltaY = (float) Math.sin(Math.toRadians((double) 90 - getDirection())) * getSpeed();
		float newLocationX = (getLocationX() + deltaX);
		float newLocationY = (getLocationY() + deltaY);

		if (newLocationX < 1024 - (this.getSize() / 2) && newLocationY > (this.getSize() / 2)
				&& newLocationY < 1024 - (this.getSize() / 2) && newLocationY > (this.getSize() / 2)) {
			setLocation(newLocationX, newLocationY);
		}else {
			setDirection(rand.nextInt(360));
		}
	}
}