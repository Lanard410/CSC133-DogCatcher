package com.mycompany.a3;

import java.util.*;

import com.codename1.charts.util.*;

public abstract class GameObject {
	// GameObject
	private Vector<Float> location;
	private int size;
	private ColorUtil color;

	public GameObject() {
		location = new Vector<Float>();
		location.setSize(2);
	}

	public ColorUtil getColor() {
		return color;
	}

	public void setColor(ColorUtil color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public float getLocationX() {
		return location.get(0);
	}

	public float getLocationY() {
		return location.get(1);
	}

	public void setLocation(float x, float y) {
		location.set(0, x);
		location.set(1, y);
	}

}
