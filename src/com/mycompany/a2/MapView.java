package com.mycompany.a2;

import java.util.Observable;
import java.util.Observer;

import com.codename1.ui.Container;

/**
 * MapView is responsible for displaying the map of the game when it is invoked
 * @author PalvinderSingh
 *
 */
public class MapView extends Container implements Observer {

	//Constructor empty due to not fully implementing in GUI
	public MapView(){
		
	}
	@Override
	//Update method that calls gameworld's displayMap()
	public void update(Observable o, Object arg) {
		if (o instanceof GameWorld) {
			((GameWorld) o).displayMap();
		}
		
	}

}
