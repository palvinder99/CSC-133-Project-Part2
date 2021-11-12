package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/**
 * Brake Command class that decreases the speed of Ant when brake Command is invoked
 * @author PalvinderSingh
 *
 */
public class BrakeCommand extends Command {
	
	private static BrakeCommand myBrakeCommand;
	private GameWorld target;

	public BrakeCommand() {
		super("   Brake   ");
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Brake command is invoked...");
		target.brake();
	}

	public static BrakeCommand getInstance() {
		if(myBrakeCommand == null) {
			myBrakeCommand= new BrakeCommand();
		}
		return myBrakeCommand;
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}
