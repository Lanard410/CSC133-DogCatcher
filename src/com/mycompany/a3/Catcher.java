package com.mycompany.a3;

public abstract class Catcher extends GameObject implements IMoving {

	public void moveUp() {
		float x = getLocationX();
		float y = getLocationY();
//		long things = Float.floatToIntBits(y);
//		//things++;
//		things = things+3;
//		y = Float.intBitsToFloat((int) things);
//		if (y < 1024 - (getSize() / 2)) {
//			setLocation(x, y);
//		}
		if( y > 0){
			y -= 10;
			setLocation(x,y);
		}
	}

	public void moveDown() {
		float x = getLocationX();
		float y = getLocationY();
//		long things = Float.floatToIntBits(y);
//		//things++;
//		things = things+3;
//		y = Float.intBitsToFloat((int) things);
//		if (y > (getSize() / 2)) {
//			setLocation(x, y);
//		}
		if(y < 721 - getSize()){
			y += 10;
			setLocation(x,y);
		}
	}

	public void moveLeft() {
		float x = getLocationX();
		float y = getLocationY();
//		long things = Float.floatToIntBits(x);
//		//things++;
//		things = things+3;
//		x = Float.intBitsToFloat((int) things);
//		if (x < 1024 - (getSize() / 2)) {
//			setLocation(x, y);
//		}
		if(x > 1 ){
			x-= 10;
			setLocation(x,y);
		}
	}

	public void moveRight() {
		float x = getLocationX();
		float y = getLocationY();
//		long things = Float.floatToIntBits(x);
//		things = things+3;
//		x = Float.intBitsToFloat((int) things);
//		if (x > (getSize() / 2)) {
//			setLocation(x, y);
//		}
		if(x < 864 - getSize()){
			x+= 10;
			setLocation(x,y);
		}
	}

}
