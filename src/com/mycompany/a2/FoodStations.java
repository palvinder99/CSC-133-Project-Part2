package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
/**
 * Food Stations class extends fixed and is responsible for information related to FoodStatios
 * @author PalvinderSingh
 *
 */
public class FoodStations extends Fixed {
	private int capacity;

	//Constructor of food station with certain partent fields and capacity for its food capacity
	public FoodStations(int size, int color, Point location, int capacity) {
		super(size, color, location);
		this.capacity = capacity;
	}

	//Setter method for capacity
	public void setCapacity(int finalCapacity) {
		capacity= finalCapacity;
		
	}

	//getter method for capacity
	public int getCapacity() {
		return capacity;
	}
	
	//To string method that prints all stats of Food Station objects
	public String toString() {
		return "FoodStation: loc=" + Math.round(getLocation().getX()*10.0)/10.0 + ", " + Math.round(getLocation().getY()*10.0)/10.0 + " color= [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "] " + "size = " + getSize() + " Capacity= " + getCapacity();
		
	}
}
