package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/**
 * LeftCommand causes ant to move left when this command is invoked
 * @author PalvinderSingh
 *
 */
public class LeftCommand extends Command {

	private static LeftCommand myLeftCommand;
	private GameWorld target;
	public LeftCommand() {
		super("Left");
	}

	public static LeftCommand getInstance() {
		if(myLeftCommand == null) {
			myLeftCommand= new LeftCommand();
		}
		return myLeftCommand;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Left command is invoked...");
		target.directLeft();
	}
	
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}

}
