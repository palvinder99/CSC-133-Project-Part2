package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/**
 * SpiderCollide Command extends Command
 * Responsible for calling collision method when this command is invoked
 * @author PalvinderSingh
 *
 */
public class SpiderCollideCommand extends Command {
	
	private static SpiderCollideCommand mySpiderCollideCommand;
	private GameWorld target;
	public SpiderCollideCommand() {
		super("SpiderCollide");
	}

	public static SpiderCollideCommand getInstance() {
		if(mySpiderCollideCommand == null) {
			mySpiderCollideCommand= new SpiderCollideCommand();
		}
		return mySpiderCollideCommand;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Spider Collide Command command is invoked..."); 
		target.antCollision();
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}
