package com.mycompany.a2;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;

public class Ant extends Moveable implements iSteerable{
		//Max Speed limit of Ant
		private static int maximumSpeed;
		//How Hungry the Ant is 
		private static int foodLevel;
		//Amount of food ant needs to consume with each clock ticks
		private static int foodConsumption;
		//Level of the Ant
		private static int healthLevel;
		//Indicates Sequence number of last flag that ant has reached in increasing order
		private static int lastFlagReached;
		private static Point point;
		private  static Ant ant;
		
		
		//Private Constructor method for ant, so only single instance can exist of ant
		private Ant(int size, int color, Point location, int heading, int speed,int maximumSpeed, int foodLevel, int foodConsumption,int healthLevel,int lastFlagReached) {
			super(size, color, location, heading, speed);
			this.maximumSpeed=maximumSpeed;
			this.foodLevel=foodLevel;
			this.foodConsumption=foodConsumption;
			this.healthLevel=healthLevel;
			this.lastFlagReached=lastFlagReached;
			
		}
		public static Ant getInstance() {
			ant=null;
			maximumSpeed=50;
			//How Hungry the Ant is 
			foodLevel=20;
			//Amount of food ant needs to consume with each clock ticks
			foodConsumption=2;
			//Level of the Ant
			healthLevel=10;
			//Indicates Sequence number of last flag that ant has reached in increasing order
			lastFlagReached=1;
			point= new Point(0,0);
			if(ant==null) {
				ant= new Ant(10, ColorUtil.rgb(255, 0, 0), point,0,5, maximumSpeed,foodLevel,foodConsumption, healthLevel, lastFlagReached);
			}
			return ant;
		}
		
		//Set foodlevel after ant collides with foodstation
		public void setFoodLevel(int totalFood) {
			foodLevel=foodLevel+totalFood;	
		}

		//Getter method for maximum speed
		public int getMaximumSpeed() {
			return maximumSpeed;
		}
		
		//Getter method for Food level of Ant
		public int getFoodLevel() {
			return foodLevel;
		}
		
		//Setter method of food level that foodLevel  every second
		public void settotalLevel(int foodLevel) {
			this.foodLevel=foodLevel;
		}
		
		//Getter method for food Consumption
		public int getFoodConsumption() {
			return foodConsumption;
		}

		//Getter method of health of ant
		public int getHealthLevel() {
			return healthLevel;
		}
		
		//Setter method for decreasing 1 from health of ant with spider
		public void setHealthLevel() {
			this.healthLevel = healthLevel-1;
		}
		
		//Getter method of lastFlagReached
		public int getLastFlagReached() {
			return lastFlagReached;
		}
		
		//Setter method for last flag Reached
		public void setLastFlagReached() {
			this.lastFlagReached = lastFlagReached+1;
		}
		
		//Direction left part of interface that moves 5 degrees to the left
		public void directionLeft() {
			super.setHeading((int) ((getHeading()-5)));	
		}
		
		//Direction right part of interface that move 5 degree to the right
		public void directionRight() {
			super.setHeading((int) ((getHeading()+5)));
		}
		
		//To String method that display all stats of ant object
		public String toString() {
			return "Ant: loc=" + Math.round(getLocation().getX()*10.0)/10.0 + ", " + Math.round(getLocation().getY()*10.0)/10.0 + " color= [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "] " + "size = " + getSize() + " heading= " + getHeading() + " speed= " + getSpeed() + " maxSpeed= " + getMaximumSpeed() + " foodConsumptionRate= " + getFoodConsumption() ;	
		}
}
