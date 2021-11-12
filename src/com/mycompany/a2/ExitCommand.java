package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionEvent;

/**
 * 
 * Exit Command class asks user if they want to exit with popup menu and asking for their confirmation
 * when the exit command is invoked
 * @author PalvinderSingh
 *
 */
public class ExitCommand extends Command {
	
	private static ExitCommand myExitCommand;
	private GameWorld target;
	
	public ExitCommand() {
		super("Exit");
	}
	
	public static ExitCommand getInstance() {
		if(myExitCommand == null) {
			myExitCommand= new ExitCommand();
		}
		return myExitCommand;
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Exit command is invoked...");
		if(Dialog.show("Exit?", " ", "No", "Yes")) {
		    // user clicked no
			
		} else {
		    // user clicked yes
			target.exitGame();
		}
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}

}
