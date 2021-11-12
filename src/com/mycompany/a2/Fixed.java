package com.mycompany.a2;

import com.codename1.charts.models.Point;

/**
 * Abstract class Fixed that extends GameObjects
 */
public abstract class Fixed extends GameObjects {
	//Constructor for fixed with extended field from GameObjects
		public Fixed(int size, int color, Point location) {
			super(size, color, location);

		}
		
		//setter method for location
		@Override
		public void setLocation(Point location) {}
		
}
