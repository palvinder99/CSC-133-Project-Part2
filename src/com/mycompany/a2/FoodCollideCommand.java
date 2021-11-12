package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/**
 * Food Collide Command adds food to food level of ant with the amount it gets from food station 
 * when this command is invoked
 * @author PalvinderSingh
 *
 */
public class FoodCollideCommand extends Command {
	
	private static FoodCollideCommand myFoodCollideCommand;
	private GameWorld target;
	public FoodCollideCommand() {
		super("FoodCollide");
	}
	
	public static FoodCollideCommand getInstance() {
		if(myFoodCollideCommand == null) {
			myFoodCollideCommand= new FoodCollideCommand();
		}
		return myFoodCollideCommand;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Food Collide command is invoked..."); 
		target.foodCollision();
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}
