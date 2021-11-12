package com.mycompany.a2;

import com.codename1.charts.models.Point;

/**
 * Moveable method is responsible for information related to moving objects such as ant and spider
 * implements GameObjects
 * @author PalvinderSingh
 *
 */
public class Moveable extends GameObjects {
	private int heading;
	private int speed;

	//Moveable Constructor with added fields of moveable objects 
	public Moveable(int size, int color, Point location, int heading, int speed) {
		super(size, color, location);
		this.heading = heading;
		this.speed = speed;
	}
	
	

	//Move class that changes the value of location depending on speed and heading of Spider objects
	public void move(int value) {
		double theta = (Math.toRadians(90 - value));
		Point newLocation = new Point(((float) Math.cos(theta) * getSpeed()) + getLocation().getX(), ((float) Math.sin(theta) * getSpeed()) + getLocation().getY());
		setLocation(newLocation);
		
	}
	

	//Getter method for heading
	public int getHeading() {
		return heading;
	}
	
	//Setter method for heading
	public void setHeading(int heading) {
		this.heading = heading;
	}

	
	//Getter method for speed
	public int getSpeed() {
		return speed;
	}
	
	//Setter for decreasing speed during braking
	public void setSpeedDec() {
		speed-=5;
	}
	
	
	//Setter method for setting speed to 0 when food level is 0 or ant health is 0
	public void setSpeed(int speed) {
		speed=0;
	}
	
	//Accelerates the speed
	public void getSpeed(int acceleration) {
		speed=speed + 5;
		
	}

	//Move method for ant object and determining new location
	public void move() {
		double theta = (Math.toRadians(90 - heading));
		Point newLocation = new Point(((float) Math.cos(theta) * getSpeed()) + getLocation().getX(), ((float) Math.sin(theta) * getSpeed()) + getLocation().getY());
		setLocation(newLocation);
	}
}
