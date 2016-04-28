package com.mycompany.a3;

import java.util.Vector;

public class GameObjectCollection implements ICollection {
	private Vector<Object> collection;

	GameObjectCollection() {
		collection = new Vector();
	}

	public void add(Object o) {
		collection.addElement(o);
	}

	public boolean remove(Object o) {
		return false;
	}

	public IIterator getIterator() {
		return new GameObjectIterator();
	}

	private class GameObjectIterator implements IIterator {
		private int index;

		public GameObjectIterator() {
			index = -1;
		}

		public boolean hasNext() {
			if (collection.size() <= 0) {
				return false;
			}
			if (index == collection.size() - 1) {
				return false;
			}
			return true;
		}
		public Object getNext() {
			index++;
			return (collection.elementAt(index));
		}
		public void remove() {
			collection.remove(index);
		}
		public int getIndex() {
			return index;
		}
		public Object objectAt(int i) {
			return collection.get(i);
		}

	}

}
