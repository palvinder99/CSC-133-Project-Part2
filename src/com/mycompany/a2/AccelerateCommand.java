package com.mycompany.a2;

import com.codename1.ui.Command;

import com.codename1.ui.events.ActionEvent;

/**
 * 
 * Accelerate Command class is responsible for acclerating the ant speed when the command is invoked
 * @author PalvinderSingh
 *
 */
public class AccelerateCommand extends Command {
	
	private static AccelerateCommand myAccelerateCommand;
	private GameWorld target;
	
	public AccelerateCommand() {
		super("Accelerate");
	}
	
	public static AccelerateCommand getInstance() {
		if(myAccelerateCommand == null) {
			myAccelerateCommand= new AccelerateCommand();
		}
		return myAccelerateCommand;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Accelerate command is invoked...");
		target.accelerate();
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}

}
