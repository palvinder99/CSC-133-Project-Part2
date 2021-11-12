package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;

/**
 * Game Class makes creates obj fields of GameWorld,MapView,ScoreView, and responsible for all Commands
 * and GUI Component that users can interact with such as buttons, sidemenu
 * @author PalvinderSingh
 *
 */
public class Game extends Form {
	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private Toolbar myToolbar= new Toolbar();
	private Label checkStatusVal = new Label("OFF");
	@SuppressWarnings("deprecation")
	public Game() {
		gw= new GameWorld();
		mv= new MapView();
		sv= new ScoreView();
		gw.addObserver(sv);
		gw.addObserver(mv);
		
		Button accelerate= new Button("Accelerate");
		accelerate.getUnselectedStyle().setBgTransparency(255);
		accelerate.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		accelerate.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button brake= new Button("Brake");
		brake.getUnselectedStyle().setBgTransparency(255);
		brake.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		brake.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button left= new Button("left");
		left.getUnselectedStyle().setBgTransparency(255);
		left.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		left.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button right= new Button("right");
		right.getUnselectedStyle().setBgTransparency(255);
		right.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		right.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button spiderCollide= new Button("Collide With Spider");
		spiderCollide.getUnselectedStyle().setBgTransparency(255);
		spiderCollide.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		spiderCollide.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button flagCollide= new Button("Collide with Flag");
		flagCollide.getUnselectedStyle().setBgTransparency(255);
		flagCollide.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		flagCollide.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button foodCollide= new Button ("Collide with Food Station");
		foodCollide.getUnselectedStyle().setBgTransparency(255);
		foodCollide.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		foodCollide.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
		
		Button timer = new Button ("Tick");
		timer.getUnselectedStyle().setBgTransparency(255);
		timer.getUnselectedStyle().setBgColor(ColorUtil.BLUE);
		timer.getUnselectedStyle().setFgColor(ColorUtil.rgb(255, 255, 0));
	
		
		//Set Color 
		//Command object for each command in the game
		Command accelerateCommand = new AccelerateCommand();
		Command brakeCommand = new BrakeCommand();
		Command leftCommand = new LeftCommand();
		Command rightCommand = new RightCommand();
		Command spiderCollideCommand = new SpiderCollideCommand();
		Command flagCollideCommand = new FlagCollideCommand();
		Command foodCollideCommand = new FoodCollideCommand();
		Command timerCommand = new TimerCommand();
		Command exitCommand= new ExitCommand();
		Command helpCommand= new HelpCommand();
		Command aboutUsCommand= new AboutUsCommand();
		
		//Set Target for each command
		((AccelerateCommand) accelerateCommand).setTarget(gw);
		((BrakeCommand) brakeCommand).setTarget(gw);
		((LeftCommand) leftCommand).setTarget(gw);
		((RightCommand) rightCommand).setTarget(gw);
		((SpiderCollideCommand) spiderCollideCommand).setTarget(gw);
		((FlagCollideCommand) flagCollideCommand).setTarget(gw);
		((FoodCollideCommand) foodCollideCommand).setTarget(gw);
		((TimerCommand) timerCommand).setTarget(gw);
		((ExitCommand) exitCommand).setTarget(gw);
		((AboutUsCommand) aboutUsCommand).setTarget(gw);
		
		//Setting command to buttons
		accelerate.setCommand(accelerateCommand);
		brake.setCommand(brakeCommand);
		left.setCommand(leftCommand);
		right.setCommand(rightCommand);
		spiderCollide.setCommand(spiderCollideCommand);
		flagCollide.setCommand(flagCollideCommand);
		foodCollide.setCommand(foodCollideCommand);
		timer.setCommand(timerCommand);
		
		setLayout(new BorderLayout(BASELINE));
		setToolbar(myToolbar);
		myToolbar.addCommandToRightBar(helpCommand);
		myToolbar.setTitle("The Path Game");
		
		CheckBox checkSideMenuComponent = new CheckBox("Sound");

		checkSideMenuComponent.getAllStyles().setBgTransparency(255);
		checkSideMenuComponent.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		//create a command object and set it as the command of check box
		Command mySound= new SoundCommand(this);
		((SoundCommand) mySound).setTarget(gw);
		//add the CheckBox component as a side menu item
		checkSideMenuComponent.setCommand(mySound);

		checkSideMenuComponent.setComponentState(true);
		myToolbar.addComponentToSideMenu(checkSideMenuComponent);
		//Label checkStatusCheck= new Label ("Check Box Status: ");
		myToolbar.addCommandToSideMenu(accelerateCommand);
		myToolbar.addCommandToSideMenu(exitCommand);
		myToolbar.addCommandToSideMenu(aboutUsCommand);
		//topContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.YELLOW));
		
		Container statContain= new Container (new FlowLayout(CENTER));
		statContain.getAllStyles().setPadding(Component.BOTTOM, 10);
		statContain.getAllStyles().setBgTransparency(255);
		statContain.getAllStyles().setBgColor(ColorUtil.rgb(153, 153, 153));
		statContain.add(sv);
		//Top panel for scores and status;
		add(BorderLayout.NORTH,statContain);
		
	
		statContain.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.CYAN));
		
		
		
		//left container with boxlayout positioned on the west
		Container leftContainer= new Container(new BoxLayout(BoxLayout.Y_AXIS));
		
		//Start adding components at a location 50 pixels below the upper border of the container
		leftContainer.getAllStyles().setPadding(Component.TOP, 50);
		leftContainer.getAllStyles().setBgTransparency(255);
		leftContainer.getAllStyles().setBgColor(ColorUtil.rgb(153, 153, 153));
		leftContainer.add(accelerate);
		leftContainer.add(left);
		leftContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.YELLOW));
		add(BorderLayout.WEST,leftContainer);
		//Right container with the GridLayout position on the east
		Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		rightContainer.getAllStyles().setPadding(Component.TOP, 50);
		rightContainer.getAllStyles().setBgTransparency(255);
		
		rightContainer.getAllStyles().setBgColor(ColorUtil.rgb(153, 153, 153));
		rightContainer.getAllStyles().setPadding(Component.TOP, 50);
		rightContainer.add(brake);
		rightContainer.add(right);
		rightContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLUE));
		//add similar components that exists on the left container
		add(BorderLayout.EAST,rightContainer);
		
		//Add empty container to the center
		Container centerContainer = new Container();
		
		//Setting the background color of center 
		centerContainer.getAllStyles().setBgTransparency(255);
		centerContainer.getAllStyles().setBgColor(ColorUtil.WHITE);
		centerContainer.add(mv);
		//Setting the border color
		centerContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.GREEN));
		add(BorderLayout.CENTER,centerContainer);
		System.out.println("Center container width/height (printed BEFORE show()): " + centerContainer.getWidth() + " " + centerContainer.getHeight());
		//Bottom Container with the FlowLayout positioned on the South, components are laid out
		//at the center
		
		Container bottomContainer = new Container(new FlowLayout(Component.CENTER));
		// Setting color of container
		bottomContainer.getAllStyles().setBgTransparency(255);	
		bottomContainer.getAllStyles().setPadding(Component.BOTTOM, 20);
		bottomContainer.getAllStyles().setBgColor(ColorUtil.rgb(153, 153, 153));
		
		//Buttons for container
		bottomContainer.add(spiderCollide);
		bottomContainer.add(flagCollide);
		bottomContainer.add(foodCollide);
		bottomContainer.add(timer);		
		//Setting border Color 
		bottomContainer.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.YELLOW));
		add(BorderLayout.SOUTH,bottomContainer);
		
		addKeyListener('a',accelerateCommand);
		addKeyListener('b',brakeCommand);
		addKeyListener('l',leftCommand);
		addKeyListener('r',rightCommand);
		addKeyListener('f',foodCollideCommand);
		addKeyListener('g',spiderCollideCommand);
		addKeyListener('t',timerCommand);
		addKeyListener('x',exitCommand);
		
		
		
		// code here to query MapView’s width and height and set them as world’s    
		// width and height
		
		//Register the views so they update
		this.show();
		//1674 1254
		centerContainer.setHeight(1000);
		centerContainer.setWidth(1000);
		System.out.println("Center container width/height (printed AFTER show()): " + centerContainer.getWidth() + " " + centerContainer.getHeight());
		//Initialization of GameWorld
		gw.init();
		
		
	}
	public void setCheckStatusVal(boolean b) {
		if (b) {
			checkStatusVal.setText("ON");
		} else {
			checkStatusVal.setText("OFF");
			revalidate();
		}
		
	}
}	
