package com.mycompany.a2;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
/**
 * AboutUs Command Class is responsible for displaying my information when the command is invoked
 * @author PalvinderSingh
 *
 */
public class AboutUsCommand extends Command {
	
	private static AboutUsCommand myAboutUsCommand;
	private GameWorld target;
	
	//Constructor
	public AboutUsCommand() {
		super("AboutUs");
	}
	//Gets Instance if none exist
	public static AboutUsCommand getInstance() {
		if(myAboutUsCommand == null) {
			myAboutUsCommand= new AboutUsCommand();
		}
		return myAboutUsCommand;
	}

	@SuppressWarnings("static-access")
	@Override
	//Performs the action
	public void actionPerformed(ActionEvent ev) {
		Dialog d= new Dialog();
		 Command cBack= new Command("Back");
		SpanLabel name= new SpanLabel("Name: Palvinde Singh \nClass: CSC133 \n Program: Assignment 2");
		 d.setLayout(new BorderLayout());
		 d.add(BorderLayout.CENTER,name);
		 d.show("AboutMe",d,cBack);
		 if (cBack != null) {
			 
		 }
			 
	}
	//Sets Target
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}

}
