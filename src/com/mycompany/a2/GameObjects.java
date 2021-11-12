package com.mycompany.a2;

import com.codename1.charts.models.Point;

/**
 * Game Object class is reponsible for data related to object's size,color,location
 * @author PalvinderSingh
 *
 */
public abstract class GameObjects {
	protected int size;
	private int color;
	private Point location;

	//Contructor of GameObjects
	public GameObjects(int size, int color, Point location) {
		this.size=size;
		this.color=color;
		this.location=location;
	}
	
	
	//getter method for location
	public Point getLocation() {
		return location;
	}
	
	//Setter method for color
	public void setColor(int color) {
		this.color = color;
	}
	
	//setter method for location
	public void setLocation(Point location) {
		this.location = location;
	}

	//getter method color
	public int getColor() {
		return color;
	}

	//getter method of size
	public int getSize() {
		return size;
	}

	
	
	//To string method 
	public String toString() {
		return "Location:" + getLocation().getX() + ", " + getLocation().getY();
	}
}
