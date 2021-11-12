package com.mycompany.a2;


import java.util.Observable;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;


public class GameWorld extends Observable {
	GameObjectCollection myObj;
	private int height =1000;
	private int width =1000;
	private int tick=0;
	private int livesRemaining=3;
	private Ant ant; 
	private boolean sound=false;

	
	
	//Constructor to Initialize
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public void init() {	
			System.out.println();
			System.out.println("Instiated World");
			
			//Initialize GameObjectCollection for the purpose of deleting old data
			//once init() method is called appropriately.
			myObj = new GameObjectCollection();
			ant=ant.getInstance();
			Point p1 = new Point((float) 0.0, (float) 0.0);
			Point p2= new Point ((float) 200.5, (float) 200.5);
			Point p3 = new Point((float) 700.5, (float) 800.4);
			Point p4= new Point ((float) 900.2, (float) 400.3);
			Random random= new Random();
			
			//Flag 1 / Initial Flag (int size, int color, Point location, int sequenceNumber) 
			Flags flag1 = new Flags(10, ColorUtil.BLUE, p1, 1);
		
			//Flag 2
			Flags flag2 = new Flags(10, ColorUtil.BLUE, p2, 2);
		
			//Flag 3
			Flags flag3 = new Flags(10, ColorUtil.BLUE, p3, 3);
				
			//Flag 4
			Flags flag4 = new Flags(10, ColorUtil.BLUE, p4, 4);
			
			//Ant(int size, int color, Point location, int heading, int speed,int maximumSpeed, int foodLevel, int foodConsumption,int healthLevel,int lastFlagReached)
			//ant= new Ant(10,ColorUtil.rgb(255, 0, 0),p1,0, 5, 50, 20, 2, 10, 1);
			
			
			//Spider1 (size,color,location,heading,speed)
			Point spider1Location= new Point((float) random.nextInt(1000),(float) random.nextInt(1000));
			Spider spider1= new Spider(random.nextInt(20)+1, ColorUtil.BLACK, spider1Location, random.nextInt(360), random.nextInt(10)+5);
		
			//Spider2 (size,color,location,heading,speed)
			Point spider2Location= new Point((float) random.nextInt(1000),(float) random.nextInt(1000));
			Spider spider2= new Spider(random.nextInt(20)+1, ColorUtil.BLACK, spider2Location, random.nextInt(360), random.nextInt(10)+5);
		
			//Food Station 1 (int size, int color, Point location, int capacity)
			int size1=random.nextInt(40)+10;
			Point food1Location= new Point ((float) random.nextInt(1000), (float) random.nextInt(1000));
			FoodStations foodStation1 = new FoodStations(size1,ColorUtil.GREEN,food1Location,size1);
			
			//Food Station 2(int size, int color, Point location, int capacity)
			int size2=random.nextInt(40)+10;
			Point food2Location= new Point ((float) random.nextInt(1000), (float) random.nextInt(1000));
			FoodStations foodStation2 = new FoodStations(size2,ColorUtil.GREEN,food2Location,size2);
			
			//All objects added into ArrayList
			myObj.add(flag1);
			myObj.add(flag2);
			myObj.add(flag3);
			myObj.add(flag4);
			myObj.add(ant);
			myObj.add(spider1);
			myObj.add(spider2);
			myObj.add(foodStation1);
			myObj.add(foodStation2);
			setChanged();
			notifyObservers();
			
		}
	
	//This method keeps track of user input of flag numbers and makes sure flag reached in order
		public void flagReaching(String sCommand) {
			String input= sCommand;
			//Parsing user key command for flags into integer value
			int inum=Integer.parseInt(input);
			//Locating instance of ant in the arraylist
			//Checking to make sure flags reached are in order
			if(inum > ant.getLastFlagReached() && inum< ant.getLastFlagReached()+2) {
				ant.setLastFlagReached();
				setChanged();
				notifyObservers();
			}
			if(ant.getLastFlagReached()==4) {
				winner();
				setChanged();
				notifyObservers();
			}
		}
		
		//Winner method displays when the user has reached all flags in order
		private void winner() {
			System.out.println();
			System.out.println("------------------------------------");
			System.out.println("Congraturlation You have Won the Game");
			System.out.println("------------------------------------");
			System.exit(0);
		}
		
		//This method is called when user either quits the game, or gameover when user fails to complete the game
		public void exitGame() {
			System.exit(0);
		} 		
	
		//Updates Heading of Spider, all moveable Objects depending on speed and heading
		//reduced ant food and elapsed clock time
		public void tickClock() {
			IIterator iterator = myObj.getIterator();
			Object currObj= new Object();
			Random range= new Random();
			int pathRandom= 0;
			
			System.out.println();
			setTick();
			while(iterator.hasNext()) {
				currObj= iterator.next();
				if (currObj instanceof Moveable) {
					Moveable mobj= (Moveable) currObj;
					if(currObj instanceof Spider) {
						//Random value between 0 or 1 to randomly add or subract from spider heading
						pathRandom= range.nextInt(1);
						switch(pathRandom) {
							//Adds five degrees to the heading of spider
						case 1: 
							((Moveable) currObj).setHeading(((Moveable) currObj).getHeading() + 5);
							mobj.move(((Moveable) currObj).getHeading()+5);
							break;
						case 2:
							((Moveable) currObj).setHeading(((Moveable) currObj).getHeading() - 5);
							mobj.move(((Moveable) currObj).getHeading()-5);
							break;
							
						}
						if(((GameObjects) currObj).getLocation().getY() >=height || ((GameObjects) currObj).getLocation().getY()<=0.0 || ( ((GameObjects) currObj).getLocation().getX() >=width || (((GameObjects) currObj).getLocation().getX() <=0.0 ))) {
							//Subtract 90 degrees from the current outofbounds heading
							((Moveable) currObj).setHeading(((Moveable) currObj).getHeading()-90);
						
						}
					}		
					//Checks for spider being out of bound, then turns the spider around
					 if (currObj instanceof Ant) {
						mobj= (Moveable) currObj;
						mobj.move();
						if(getLivesRemaining() !=0) {
							if(((Ant) currObj).getFoodLevel()>0) {
								subtractFoodLevel();
								
							}else {
								setLivesRemaining();
								playerDied();
							}

						} else {
							gameOver();
						}		
					} 
				}
			}
		setChanged();
		notifyObservers();
			
		}
		
		//method subtract foodLevel from ant level on each tick
		private void subtractFoodLevel() {
			this.ant.settotalLevel(ant.getFoodLevel()- (ant.getFoodConsumption()));
			
			
			
		}
		
		//method reinitializes the world
		private void playerDied() {
			init();
		}
		
		//This method displays gameover screen, then quits the game
		private void gameOver() {
			
			System.out.println("----------------------------");
			System.out.println("           Game Over        ");
			System.out.println("----------------------------");
			exitGame();
		}
		
		//This method display the map when the mapview is invoked 
		public void displayMap() {
			IIterator printIterator= myObj.getIterator();
			Object printObj= new Object();
			System.out.println();
			System.out.println("Map of the game:");
			while(printIterator.hasNext()) {
				printObj=printIterator.next();
				System.out.println(printObj.toString());
			}
			System.out.println();

		}
		
		//This method detects collision of ant with spider
		public void antCollision() {
			//Checks for if ant health is not 0
			if (ant.getHealthLevel() !=0) {
				//Subtract 1 from health of ant
				ant.setHealthLevel();
				//Decrease speed by 5
				brake();
				
				//Change color of ant to light red
				ant.setColor(ColorUtil.rgb(225, 164, 164));
			//If ant's health is 0 , re-initializes the game and subtacts 1 lives remaining
			} else if (ant.getHealthLevel() ==0){
				setLivesRemaining();
				playerDied();
			}
			//If lives remaining is 0, call gameover
			if(getLivesRemaining() == 0) {
				gameOver();
			}
			setChanged();
			notifyObservers();
		}	
		
		//Ant collides with food station
		public boolean foodCollision() {
			Random random= new Random();
			IIterator iterator= myObj.getIterator();
			Object currentObj= new Object();
			//Counts the total food to add to ant
			while( iterator.hasNext() ){
				currentObj = iterator.next();
				// found the first food Station
				if( currentObj instanceof FoodStations){
					// add food to ant remainingfood
					ant.setFoodLevel(((FoodStations) currentObj).getCapacity());
					
					// remove the food station
					myObj.remove(currentObj);
					
					// create new FoodStations 
					int cap= random.nextInt(40)+10;
					Point food3Location= new Point ((float) random.nextInt(1000), (float) random.nextInt(1000));
					FoodStations foodStation3 = new FoodStations(cap,ColorUtil.GREEN,food3Location,cap);
					myObj.add(foodStation3);
					// remove successful, return true
					notifyObservers();
					return true;
				}
			}
			return false;
		}	
	
		//This method changes the direction of ant 5 degrees to the right
		public void directRight() {
			//Changes direction of ant to right on command
			ant.directionRight();
		}

		//This method changes the direction of ant 5 degrees to the left
		public void directLeft() {
			//Changes direction of ant to left on command
			ant.directionLeft();
		}

		//This method decreases acceleration of the ant by 5
		public void brake() {
			if (ant.getSpeed() > 0 &&  ant.getFoodLevel() !=0) {
				ant.setSpeedDec();	
			}
		}

		//This method increases acceleration of the any by 5
		public void accelerate(){
			//Checks if the health is lower, to account to maximum speed being limited to health of ant
			if (ant.getSpeed() < ant.getMaximumSpeed()) {
				int acceleration= (ant.getMaximumSpeed()-ant.getHealthLevel());
				ant.getSpeed(acceleration);
			}
		}

		//Getter method for lives remaining
		public int getLivesRemaining() {
			return livesRemaining;
		}

		//Subract the lives remaining value by 1
		public void setLivesRemaining() {
			this.livesRemaining--;
		}

		//Getter method for tick that calculates seconds
		public int getTick() {
			return tick;
		}

		//Adds tick each time the commands is entered
		public void setTick() {
			this.tick = tick+1;
			
		}
		
		//Gets the highest flag the ant has reached
		public int getHighestFlag() {
			return ant.getLastFlagReached();
		}
		
		//Gets food level for ant
		public int getFoodLevel() {
			return ant.getFoodLevel();
			
		}

		//Gets healthlevel of ant
		public int getHealth() {
			return ant.getHealthLevel();
		}
		
		//sets sound to turn on 
		public boolean soundOn() {
			return sound;
		}
		
		//Changes the value for sound to indicate it is turned on
		public void turnSoundOn() {
			sound=true;
			setChanged();
			notifyObservers();	
		}
		
		//Changes the value for sound to indicate it is turned off
		public void turnSoundOff() {
			sound=false;
			setChanged();
			notifyObservers();
		}
		
		//Toggles sound on or off
		public void toggleSound() {
			if(sound) {
				sound=false;
			} else {
				sound=true;
				
			}
			setChanged();
			notifyObservers();
		}
}
