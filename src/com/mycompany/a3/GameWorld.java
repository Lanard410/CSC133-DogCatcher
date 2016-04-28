package com.mycompany.a3;

import java.util.*;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;

public class GameWorld extends Observable {
	private Net net;
	private Dog dog;
	private Cat cat;
	GameObjectCollection objects;
	Collection start;
	private Vector<Animal> collisionA = new Vector<Animal>();
	// private Vector<Object> observerArray = new Vector<Object>();
	private int dogInit = 3;
	private int catInit = 2;
	public int removeCat = catInit, removeDog = dogInit;
	public int totalScore = 0, dogsCaptured, catsCaptured, dogsRemaining, catsRemaining;
	private int tickClock, currentTime;
	private int ticking, capturedCats = 0, capturedDogs = 0;
	private boolean sound;
	private ColorUtil color;
	Random rand = new Random();
	
	public int getInitDog(int dogInit){
		return dogInit;
	}
	public void setInitDog(int dogInit){
		this.dogInit = dogInit;
		this.setChanged();
		this.notifyObservers();
	}
	public int getInitCat(int catInit){
		return catInit;
	}
	public void setInitCat(int catInit) {
		this.catInit = catInit;
		this.setChanged();
		this.notifyObservers();
	}

	GameWorld() {
		objects = new GameObjectCollection();
		dog = new Dog();
		cat = new Cat();
		net = new Net();
	}

	public void initLayout() {
		
		randNet();
		randDog();
		randCat();

		// code to create game objects
		// creating game objects such as Cat Dog and Net
	}

	public void randDog() {
		for (int i = 0; i < dogInit; i++) {
			dog = new Dog();
			dog.setSpeed(5);
			dog.setColor(ColorUtil.rgb(0, 0, 0));
			dog.setLocation(rand.nextInt(1024), rand.nextInt(1024));
			dog.setSize(rand.nextInt(50));
			dog.setDirection(rand.nextInt(360));
			objects.add(dog);

			// direction = rand.nextInt(maxA - minA + 1) + minA;
			// dog[i] = new Dog(ColorUtil.BLUE, randX, randY,
			// ColorUtil.BLUE,50,dir,5,0,false);
			// dog[i] = new Dog(ColorUtil.BLUE, scratch, size, direction,speed,
			// location);
		}
	}

	public void randCat() {
		for (int i = 0; i < catInit; i++) {
			cat = new Cat();
			cat.setSpeed(5);
			// cat.setColor(color);
			cat.setColor(ColorUtil.rgb(250, 250, 210));
			cat.setLocation(rand.nextInt(1024), rand.nextInt(1024));
			cat.setSize(rand.nextInt(40));
			cat.setDirection(rand.nextInt(360));
			objects.add(cat);

			// direction = rand.nextInt(maxA - minA + 1) + minA;
			// Cat Vector = new Cat(ColorUtil.GREEN, size, direction, speed,
			// location);
			// cat[i] = new Cat(ColorUtil.GREEN, size, direction, speed,
			// location);
		}
	}
	public void randNet() {
		net.setColor(color);
		net.setSize(60);
		net.setLocation(rand.nextInt(1024), rand.nextInt(1024));
		objects.add(net);
		// direction = rand.nextInt(maxA - minA + 1) + minA;
		// net[i] = new Net(size, speed, direction, location);
		// Net Vector = new Net(size, speed, direction, location);
	}
	// additional methods to manipulate world objects and related game data

	public void expand() {
		// Vector<E> getNet = (Vector<E>) Collection.elementAt(2);
		// expand the size of the net the center location of the net shouldn't
		// change
		int x = net.getSize();
		if (x < 500) {
			net.setSize(x + 10);
		}
	}

	public void contract() {
		// contract(decrease the size of the net the center location shouldn't
		// change)
		int x = net.getSize();
		if (x > 50) {
			net.setSize(x - 10);
		}
	}

	public void scoop() {
		// scoop up all animals in net. causes all animals whose centers are
		// within the boundaries of the bounding square of the net to be removed
		// form the game world and score to be updated according to the rules of
		// the play described above
		float netLeft = net.getLocationX() - (net.getSize() / 2);
		float netRight = net.getLocationX() + (net.getSize() / 2);
		float netDown = net.getLocationY() - (net.getSize() / 2);
		float netUp = net.getLocationY() + (net.getSize() / 2);

		IIterator iter = objects.getIterator();
		Object currentObject;

		while (iter.hasNext()) {
			currentObject = iter.getNext();
			if (currentObject instanceof Cat) {
				if (((Cat) currentObject).getLocationX() > netLeft && ((Cat) currentObject).getLocationX() < netRight
						&& ((Cat) currentObject).getLocationY() > netDown
						&& ((Cat) currentObject).getLocationY() < netUp) {
					System.out.println("You caught a cat!");

					capturedCats++;
					totalScore = totalScore - 10;
					removeCat--;

					iter.remove();
				}
			} else if (currentObject instanceof Dog) {
				if (((Dog) currentObject).getLocationX() > netLeft && ((Dog) currentObject).getLocationX() < netRight
						&& ((Dog) currentObject).getLocationY() > netDown
						&& ((Dog) currentObject).getLocationY() < netUp) {
					System.out.println("You caught a dog!");

					capturedDogs++;

					totalScore = totalScore + 10 - dog.getScratch();
					removeDog--;

					iter.remove();

					if (removeDog == 0) {
						System.out.print(" GAME OVER! ");
						printPoints();
						System.exit(0);
					}
				}
			}
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void right() {
		// move the net to the right
		net.moveRight();
	}

	public void left() {
		// move the net to the left
		net.moveLeft();
	}

	public void up() {
		// move the net up
		net.moveUp();
	}

	public void down() {
		// move the net down
		net.moveDown();
	}

	public void transferD() {
		// transfer the net to a location of a randomly selected dog
		Dog dog1;
		Random rand = new Random();
		int dogIndex;
		IIterator iter = objects.getIterator();
		dogIndex = rand.nextInt(dogInit) + 1;
		dog1 = (Dog) iter.objectAt(dogIndex);

		float x = dog1.getLocationX();
		float y = dog1.getLocationY();
		net.setLocation(x, y);

	}

	public void transferC() {
		// transfer the net to a location of a randomly selected cat. if there
		// are no cas print an error message instead
		Cat cat1;
		Random rand = new Random();
		int catIndex;
		IIterator iter = objects.getIterator();
		catIndex = rand.nextInt(catInit) + 4;
		cat1 = (Cat) iter.objectAt(catIndex);

		float x = cat1.getLocationX();
		float y = cat1.getLocationY();
		net.setLocation(x, y);

	}
	public void healDogs() {
		IIterator iterator = objects.getIterator();
		Object current;
		//heal selected dogs
		while(iterator.hasNext()){
			current = iterator.getNext();
			if(current instanceof Dog && ((Dog)current).isSelected()){
				((Dog) current).setSelected(false);
				((Dog) current).resetScratches();
				((Dog) current).setSpeed(5);
				((Dog) current).setColor(ColorUtil.BLACK);
				this.setChanged();
				this.notifyObservers();
			}
		}
	}
	public boolean collisionCheck(Animal c) {
		for(int i = 0; i< collisionA.size(); i++) {
			if(collisionA.get(i) == c){
				return true;
			}
		}
		return false;
	}
	public void addCollision(Animal cat) {
		collisionA.add(cat);
	}

	public void precatCollide() {
		// pretend that a collision between two cats. player specifies the k
		// command the program first checks if there at least two cats if
		// so it randomly picks a cat and produces a kitten in a location that
		// is close to the chosen cat. If the number of cats in the world
		// is less than two then print an error message
		if(catInit<30){
			cat = new Cat();
			cat.setSpeed(5);
			cat.setColor(ColorUtil.YELLOW);
			cat.setLocation(rand.nextInt(1024), rand.nextInt(1024));
			cat.setSize(rand.nextInt(30) + 20);
			cat.setDirection(rand.nextInt(360));
			float spawn = rand.nextInt(4) + 1;
			if (spawn == 1) {
				float kitX = cat.getLocationX() + 50.0f;
				float kitY = cat.getLocationY() + 50.0f;
				if (kitX > 1024.0f) {kitX = 974.0f;}
				if (kitX < 0.0f) {kitX = 50.0f;}
				if (kitY > 1024.0f) {kitY = 974.0f;}
				if (kitY < 0.0f) {kitY = 50.0f;}
			}if (spawn == 2) {
				float kitX = cat.getLocationX() - 50.0f;
				float kitY = cat.getLocationY() + 50.0f;
				if (kitX > 1024.0f) {kitX = 974.0f;}
				if (kitX < 0.0f) {kitX = 50.0f;}
				if (kitY > 1024.0f) {kitY = 974.0f;}
				if (kitY < 0.0f) {kitY = 50.0f;}
			}if (spawn == 3) {
				float kitX = cat.getLocationX() + 50.0f;
				float kitY = cat.getLocationY() - 50.0f;
				if (kitX > 1024.0f) {kitX = 974.0f;}
				if (kitX < 0.0f) {kitX = 50.0f;}
				if (kitY > 1024.0f) {kitY = 974.0f;}
				if (kitY < 0.0f) {kitY = 50.0f;}
			}if (spawn == 4) {
				float kitX = cat.getLocationX() - 50.0f;
				float kitY = cat.getLocationY() - 50.0f;
				if (kitX > 1024.0f) {kitX = 974.0f;}
				if (kitX < 0.0f) {kitX = 50.0f;}
				if (kitY > 1024.0f) {kitY = 974.0f;}
				if (kitY < 0.0f) {kitY = 50.0f;}
			}
			objects.add(cat);
			removeCat++;
			this.setChanged();
			this.notifyObservers();

		}

	}

	public void prefight() {
		// pretend that a fight occurred between a cat and a dog(a cat and dog
		// run into each other).
		// The program randomly picks a dog and scratches it once, changing its
		// color, and reduces its speed by 1.
		// If there are no coats print an error message instead
		ArrayList<Integer> dogList = new ArrayList<Integer>();
		IIterator iter = objects.getIterator();
		while (iter.hasNext()) {
			if (iter.getNext() instanceof Dog) {
				dogList.add(iter.getIndex());
				dog.scratched();
				// dog.changeColor();
				break;
			}
		}
	}

	public void clockTick() {
		// tell the game world that the game clock has ticked all moving objects
		// are told to update their positions according to their current
		// direction and speed
		ticking = ticking + 1;
		//IIterator iter3 = objects.getIterator();
		GameObject currentObject;
		IIterator iter = objects.getIterator();

		while (iter.hasNext()) {
			currentObject = (GameObject) iter.getNext();
			if (currentObject instanceof Animal) {
				((Animal) currentObject).move();
			}
		}
		//run
//		while(iter.hasNext()){
//			((IGuide)iter.getNext()).move();
//		}
		iter = objects.getIterator();
		while(iter.hasNext()){
			ICollider currentObj = (ICollider)iter.getNext();
			//check if object collides with any other object
			IIterator iter2 = objects.getIterator();
			while(iter2.hasNext()){
				ICollider otherObj = (ICollider) iter2.getNext();//get collision object
				//check collision
				if(otherObj != currentObj){
					if(currentObj.collidesWith(otherObj)){
						currentObj.handleCollision(otherObj);
					}
				}
			}
		}
		this.setChanged();
		this.notifyObservers();
		//this.collision();
//		if(currentTime+20 < tickClock){
//			for(int i = 0; i<collisionA.size(); i++){
//				collisionA.remove(i);
//			}
//		}
	}
	public void collision() {
		GameObject a;
		GameObject b;
		IIterator iter = objects.getIterator();
		while(iter.hasNext()){
			a = (GameObject) iter.getNext();
			if(a instanceof Dog) {
				Dog dog = (Dog) a;
				IIterator iter2 = objects.getIterator();
				while(iter2.hasNext()){
					b = (GameObject) iter2.getNext();
					if(b instanceof Cat) {
						Cat cat = (Cat) b;
						if(dog.collidesWith(cat) && collisionCheck(dog) == false){
							currentTime = tickClock;
							dog.handleCollision(this.dog);
							addCollision(dog);
						}
					}
				}
			}
			if(a instanceof Cat) {
				Cat cat = (Cat) a;
				IIterator iter2 = objects.getIterator();
				while(iter2.hasNext()){
					b = (GameObject) iter2.getNext();
					if(b instanceof Cat) {
						Cat cat2 = (Cat) b;
						if(cat.collidesWith(cat2) && collisionCheck(cat) == false){
							currentTime = tickClock;
							cat.handleCollision(this.cat);
							addCollision(cat);
							addCollision(cat2);
							
						}
					}
				}
			}
		}
	}

	public void printPoints() {
		// print the points of game state values 1 current score 2 number of
		// dogs/cats captures and 3 number of dogs/cats left in the world.
		// Output should be appropriately labeled in easily readable format
		int a = catInit - removeCat;
		int b = dogInit - removeDog;
		// System.out.println("Current score: " + y);
		System.out.println("Current score: " + totalScore);
		System.out.println("Number of Cats Remaining: " + removeCat);
		System.out.println("Number of Dogs Remaining: " + removeDog);
		System.out.println("Number of Dogs Captured: " + b);
		System.out.println("Number of Cats Captured: " + a);
	}

	public void printMap() {
		// print a map showing the current world state
		IIterator iter = objects.getIterator();
		while (iter.hasNext()) {
			System.out.print(iter.getNext().toString());
		}
	}

	public void quit() {
		System.exit(0);
	}

	public void exit() {
		if (Dialog.show("You wanna quit?", "", "Yes", "Cancel")) {
			quit();
		}
	}

	public int getTotalScore() {
		System.out.println(totalScore);
		return totalScore;
	}

	public int getDogsCaptured() {
		// return dogsCaptured;
		return capturedDogs;
	}

	public int getCatsCaptured() {
		// return catsCaptured;
		return capturedCats;
	}

	public int getDogsRemaining() {
		// return dogsRemaining;
		return removeDog;
	}

	public int getCatsRemaining() {
		// return catsRemaining;
		return removeCat;
	}

	public void turnOnSound() {
		sound = true;
		this.setChanged();
		this.notifyObservers();
	}

	public void turnOffSound() {
		sound = false;
		this.setChanged();
		this.notifyObservers();
	}

	public void toggleSound() {
		if (sound) {
			sound = false;
		} else {
			sound = true;
		}
		this.setChanged();
		this.notifyObservers();
	}

	public boolean isSoundOn() {
		return sound;
	}
	public GameObjectCollection getGameObjectCollection() {
		return objects;
	}
	public void setStart(Collection start){
		this.start = start;
	}
	public Collection getStart() {
		return start;
	}

}
