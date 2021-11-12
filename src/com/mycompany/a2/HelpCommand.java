package com.mycompany.a2;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;

/**
 * HelpCommand Class shows the tutorial for the game by showing all key binding to user when this
 * command is invoked
 * @author PalvinderSingh
 *
 */
public class HelpCommand extends Command {
	private static HelpCommand myHelpCommand;
	
	public HelpCommand() {
		super("Help");
	}
	
	public static HelpCommand getInstance() {
		if(myHelpCommand == null) {
			myHelpCommand= new HelpCommand();
		}
		return myHelpCommand;
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent ev) {
		 Dialog d= new Dialog();
		 Command cBack= new Command("Back");
		 SpanLabel help= new SpanLabel("a-Accelerate \nb-Brake \nl-Left Turn \nr-Right Turn \nf-Collide Food Station\ng-Collide Spider\nt-Tick");
		 d.setLayout(new BorderLayout());
		 d.add(BorderLayout.CENTER,help);
		 d.show("Tutorial",d,cBack);
		 if (cBack != null) {
			 
		 }
	}
}
