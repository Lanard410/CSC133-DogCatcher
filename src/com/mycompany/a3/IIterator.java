package com.mycompany.a3;

public interface IIterator {

	boolean hasNext();
	Object getNext();
	public void remove();
	public int getIndex();
	public Object objectAt(int i);

}
