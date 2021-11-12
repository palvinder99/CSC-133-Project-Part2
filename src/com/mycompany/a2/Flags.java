package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
/**
 * Flag class extend fixed and is responsible for all information related to flag
 * @author PalvinderSingh
 *
 */
public class Flags extends Fixed {
	private int sequenceNumber;

	//Constructor method for specific flag fields and extended field from GameObjects
	public Flags(int size, int color, Point location, int sequenceNumber) {
		super(size, color, location);
		this.sequenceNumber = sequenceNumber;

	}

	//Getter method for sequence number
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	
	//Empty body setter method of color, so it does not override the original set value for flags
	public void setColor(int color){}
	
	//Returns the location same as the original set location of flags
	public Point getLocation() {

		return super.getLocation();
	}
	
	//To String  method that display all flag objects with its stats
	public String toString() {
		return "Flag: loc=" + Math.round(getLocation().getX()*10.0)/10.0 + ", " + Math.round(getLocation().getY()*10.0)/10.0 + " color= [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "] " + "size = " + getSize() + " SeqNum= " + getSequenceNumber();
		
	}
}
