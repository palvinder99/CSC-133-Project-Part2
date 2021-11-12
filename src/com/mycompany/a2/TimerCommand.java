package com.mycompany.a2;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

/**
 * TimerCommand is responsible for adding time and other operations related to time such as moveing 
 * objects,subtracting food etc.
 * @author PalvinderSingh
 *
 */
public class TimerCommand extends Command {
	
	private static TimerCommand myTimerCommand;
	private GameWorld target;
	public TimerCommand() {
		super("Timer");
	}

	public static TimerCommand getInstance() {
		if(myTimerCommand == null) {
			myTimerCommand= new TimerCommand();
		}
		return myTimerCommand;
	}
	
	@Override
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Timer Command command is invoked..."); 
		target.tickClock();
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}
