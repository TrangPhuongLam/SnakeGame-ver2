package controller;

import abstractSnakeGame.ScreenGame;
import panel.PanelMap_1;
import panel.PanelMap_2;
import panel.PanelMap_3;
import view.GameFrameView;
import view.LevelView;

public class LevelController {
	public LevelView levelView;
	public GameFrameView gameFrameMap1, gameFrameMap2, gameFrameMap3;
	public ScreenGame map1, map2, map3;
	public static String playerDecoratorName = "playerDecoratorName1";

	public LevelController(LevelView levelView) {
		super();
		this.levelView = levelView;
		
	}
	
	public LevelController(String playerDecoratorName) {
		
		this.map1.setPlayerDecoratorName(playerDecoratorName);
		this.map2.setPlayerDecoratorName(playerDecoratorName);
		this.map3.setPlayerDecoratorName(playerDecoratorName);
	}
	
	public LevelController() {
		this(playerDecoratorName);
	}
	
	public void Map1() {
		map1 = new PanelMap_1();
		gameFrameMap1 = new GameFrameView(map1);
	}
	
	public void Map2() {
		map2 = new PanelMap_2();
		gameFrameMap2 = new GameFrameView(map2);
	}
	
	public void Map3() {
		map3 = new PanelMap_3();
		gameFrameMap3 = new GameFrameView(map3);
	}
}
