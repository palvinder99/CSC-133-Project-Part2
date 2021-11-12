package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

/**
 * Spider class extends moveable
 * Responsible for data related to spider
 * @author PalvinderSingh
 *
 */
public class Spider extends Moveable {
	//Constructor method of Spider
		public Spider(int size, int color, Point location, int heading, int speed) {
			super(size, color, location, heading, speed);
			
		}
		
		//Empty setter method of color
		public void setColor(int color){}
		
		//To String method for printing stats of Spider Object
		public String toString() {
			return "Spider: loc= " + Math.round(getLocation().getX()*10.0)/10.0 + ", " + Math.round(getLocation().getY()*10.0)/10.0 + " color= [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "] " + "size = " + getSize() + " heading= " + getHeading() + " speed= " + getSpeed();	
		}
}
