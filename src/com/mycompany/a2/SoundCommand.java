package com.mycompany.a2;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;

/**
 * SoundCommand class toggle sound on or off when this command is invoked
 * @author PalvinderSingh
 *
 */
public class SoundCommand extends Command {
	private static SoundCommand mySoundCommand;
	private GameWorld target;
	private static Game fgame;
	public SoundCommand(Game game) {
		super("Sound");
		fgame=game;
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (((CheckBox) ev.getComponent()).isSelected()){
			fgame.setCheckStatusVal(true);
			target.toggleSound();
		} else if (!((CheckBox) ev.getComponent()).isSelected()) {
			fgame.setCheckStatusVal(false);
			target.toggleSound();
		}

	}

	public static SoundCommand getInstance() {
		if(mySoundCommand == null) {
			mySoundCommand= new SoundCommand(fgame);
		}
		return mySoundCommand;
	}
	
	public void setTarget(GameWorld gw) {
		if (target==null) {
			target=gw;
		}
	}
}	