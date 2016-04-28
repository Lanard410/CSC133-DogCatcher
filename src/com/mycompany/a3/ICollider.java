package com.mycompany.a3;

public interface ICollider {
	//detection algorithm
	//public boolean collidesWith(ICollider otherObject);
	public boolean collidesWith(ICollider otherObj);
	//response algorithm
	//public void handleCollision(ICollider otherObject);
	public void handleCollision(ICollider otherObj);

}
