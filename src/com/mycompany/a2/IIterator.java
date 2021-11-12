package com.mycompany.a2;

/**
 * Custom Itterator interface
 * @author PalvinderSingh
 *
 */
public interface IIterator {
	//checks if collection has another object
	public boolean hasNext();
	
	//return the next object in the game collection
	public Object next();
}
