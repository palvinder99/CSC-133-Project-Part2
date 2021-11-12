package com.mycompany.a2;

import java.util.ArrayList;

/**
 * GameObjectCollection is responsible for implementing Icollection and responsible for iterator related
 * such adding to list,removing and geting new itterator, but also keeping track of iterator
 */
public class GameObjectCollection implements ICollection {
	private ArrayList<Object> collection;
	
	//Constructs the Game Object Collection
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GameObjectCollection(){
		collection = new ArrayList();
	}
	
	//Adds to the arraylist
	public void add(Object newObject) {
		collection.add(newObject);
	}
	
	@Override
	//Removes from the arraylist
	public void remove(Object obj) {
		 collection.remove(obj);
	}
	
	//Get the iterator to move through the collection
	public IIterator getIterator() {
		return new GameObjectIterator();
		
	}
	
	/**
	 * GameObject Iterator implements Itterator
	 * Responsible for keeping track of the the object in list such as checking if their is another value
	 * in the list and next method that returns the obj in list.
	 * @author PalvinderSingh
	 *
	 */
	private class GameObjectIterator implements IIterator {
		//index
		private int currObj;
		
		public GameObjectIterator() {
			currObj=-1;
		}
		@Override
		//Checks if there is more obj in arraylist
		public boolean hasNext() {
			//check for objects in collection
			if(collection.size() <1) {
				return false;
			}
			if (currObj==collection.size()-1) {
				return false;
			}
			return true;
		}

		@Override
		//Returns the obj in arraylist at curent Object or iterate
		public Object next() {
			currObj++;
			return (collection.get(currObj));
		}
	}
}


