package com.mycompany.a2;
/**
 * Custom Collection Interface 
 * @author PalvinderSingh
 *
 */
public interface ICollection {
	
	//add object into the collection
	public void add(Object newObject);
	
	//Get the iterator for traversel of the collection
	public IIterator getIterator();
	
	//Remove the obj from iterator
	public void remove(Object obj);
}
