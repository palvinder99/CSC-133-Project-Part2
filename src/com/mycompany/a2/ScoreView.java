package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;

/**
 * ScoreView class is responsible for displaying stats of ant other information such as sound status, time
 * @author PalvinderSingh
 *
 */
public class ScoreView extends Container implements Observer {
	private Label time;
	private  Label lives;
	private Label flagReached;
	private Label foodLevel;
	private Label health;
	private Label sound;
	
	public ScoreView(){
		
		time= new Label ("Time:##");
		time.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
		add(time);
		
		lives= new Label ("LivesLeft:#");
		lives.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
		add(lives);
		
		flagReached= new Label ("FlagReached:##");
		flagReached.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
		add(flagReached);
		
		foodLevel= new Label ("RemainingFood:## ");
		foodLevel.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
		add(foodLevel);
		
		health= new Label ("HealthLevel:###");
		health.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
		add(health);
		
		sound= new Label ("Sound:XXX");
		sound.getUnselectedStyle().setFgColor(ColorUtil.YELLOW);
		add(sound);
		this.setVisible(true); 
	}
	
	@Override
	public void update(Observable o, Object arg) {
		revalidate();
		time.setText("Time:" + ((GameWorld) o).getTick());
		lives.setText("LivesLeft:" + ((GameWorld) o).getLivesRemaining());
		flagReached.setText("FlagReached:" + ((GameWorld) o).getHighestFlag());
		foodLevel.setText("RemainingFood: " + ((GameWorld) o).getFoodLevel());
		health.setText("HealthLevel:" + ((GameWorld) o).getHealth());
		if (((GameWorld) o).soundOn()) {
			sound.setText("Sound:ON");
		}else {
			sound.setText("Sound:OFF");
		}
		this.setVisible(true);
	}

}
