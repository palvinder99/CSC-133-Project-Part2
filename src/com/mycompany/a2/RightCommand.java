package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/**
 * Right command causes the ant to move to the right when this command is invoked
 * @author PalvinderSingh
 *
 */
public class RightCommand extends Command {
	
	private static RightCommand myRightCommand;
	private GameWorld target;
	public RightCommand() {
		super("Right");
	}

	public static RightCommand getInstance() {
		if(myRightCommand == null) {
			myRightCommand= new RightCommand();
		}
		return myRightCommand;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Right command is invoked...");
		target.directRight();
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}