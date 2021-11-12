package com.mycompany.a2;

import com.codename1.ui.Command;

import com.codename1.ui.Dialog;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

/**
 * Flag Collided Command ask user to input a number between 1-4 when the flag collided command is invoked
 * @author PalvinderSingh
 *
 */
public class FlagCollideCommand extends Command {
	
	private static FlagCollideCommand myFlagCollideCommand;
	private GameWorld target;
	public FlagCollideCommand() {
		super("FlagCollide");
	}
	
	public static FlagCollideCommand getInstance() {
		if(myFlagCollideCommand == null) {
			myFlagCollideCommand= new FlagCollideCommand();
		}
		return myFlagCollideCommand;
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent ev) {
		TextField myTF= new TextField();
		System.out.print("Flag Collide Command Invoked");
		Command cOk = new Command("Ok");
		Command cCancel = new Command("Cancel");
		Command[] cmds = new Command[] {cOk,cCancel};
		Command c= Dialog.show("Enter a number", myTF, cmds);
		if(myTF.getText()=="") {
			
		} else {
			if (c==cOk) {
				String num= myTF.getText();
				target.flagReaching(num);	
			} else {  
			}
		}
			
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}
