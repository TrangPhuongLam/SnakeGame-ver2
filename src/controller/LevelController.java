package controller;

import abstractSnakeGame.ScreenGame;
import panel.PanelMap_1;
import panel.PanelMap_2;
import panel.PanelMap_3;
import view.GameFrameView;
import view.LevelView;
import view.MenuView;

public class LevelController {
	public static LevelView levelView;
	public GameFrameView gameFrameMap1, gameFrameMap2, gameFrameMap3, gameFrame;
	public ScreenGame map1, map2, map3, screenGame;
	public static String playerDecoratorName = "playerDecoratorName1";

	public LevelController(LevelView levelView) {
		this.levelView = levelView;
		
	}
	
	public void map1() {
		
		screenGame = new PanelMap_1();
		screenGame.setPlayerDecoratorName(this.playerDecoratorName);
		gameFrame = new GameFrameView(screenGame);
		levelView.dispose();
	}
	
	public void map2() {
		
		screenGame = new PanelMap_2();
		screenGame.setPlayerDecoratorName(this.playerDecoratorName);
		gameFrame = new GameFrameView(screenGame);
		levelView.dispose();
	}
	
	public void map3() {
		
		screenGame = new PanelMap_3();
		screenGame.setPlayerDecoratorName(this.playerDecoratorName);
		gameFrame = new GameFrameView(screenGame);
		levelView.dispose();
	}
	
	public void backMenuView() {
		MenuView menuView = new MenuView();
		levelView.dispose();
	}

	public static String getPlayerDecoratorName() {
		return playerDecoratorName;
	}

	public static void setPlayerDecoratorName(String playerDecoratorName) {
		LevelController.playerDecoratorName = playerDecoratorName;
	}
	
	
}
