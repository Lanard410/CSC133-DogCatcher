package com.mycompany.a3;

public abstract class Catcher extends GameObject implements IMoving {

	public void moveUp() {
		float x = getLocationX();
		float y = getLocationY();
		long things = Float.floatToIntBits(y);
		things++;
		y = Float.intBitsToFloat((int) things);
		if (y < 1024 - (getSize() / 2)) {
			setLocation(x, y);
		}

	}

	public void moveDown() {
		float x = getLocationX();
		float y = getLocationY();
		long things = Float.floatToIntBits(y);
		things++;
		y = Float.intBitsToFloat((int) things);
		if (y > (getSize() / 2)) {
			setLocation(x, y);
		}

	}

	public void moveLeft() {
		float x = getLocationX();
		float y = getLocationY();
		long things = Float.floatToIntBits(x);
		things++;
		x = Float.intBitsToFloat((int) things);
		if (x < 1024 - (getSize() / 2)) {
			setLocation(x, y);
		}

	}

	public void moveRight() {
		float x = getLocationX();
		float y = getLocationY();
		long things = Float.floatToIntBits(x);
		things++;
		x = Float.intBitsToFloat((int) things);
		if (x > (getSize() / 2)) {
			setLocation(x, y);
		}

	}

}
