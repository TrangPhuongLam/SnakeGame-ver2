package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import abstractSnakeGame.PaintMapObserver;
import abstractSnakeGame.ScreenGame;
import decorater.PlayerDecorator_1;
import interfaceSnakeGame.ShapePlayer;
import model.Snake;
import panel.PanelMap_1;
import panel.PanelMap_3;
import view.GameFrameView;
import view.LevelView;
import view.PlayerView;

public class PlayerController {
	private String playerDecoratorName = "playerDecorator1";
	private LevelController levelController;
	private LevelView levelView;
	
	public PlayerController() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPlayerDecorator_1() {
		return this.playerDecoratorName = "playerDecorator1";
		
	}

	public String getPlayerDecorator_2() {
		return this.playerDecoratorName = "playerDecorator2";
	}
	
	public String getPlayerDecorator_3() {
		return this.playerDecoratorName = "playerDecorator3";
	}

	public void chosePlayerDecorator_1() {
		levelController = new LevelController(getPlayerDecorator_1());
		levelView = new LevelView(levelController);
	}

	public void chosePlayerDecorator_2() {
		levelController = new LevelController(getPlayerDecorator_2());
		levelView = new LevelView(levelController);
	}
	
	public void chosePlayerDecorator_3() {
		levelController = new LevelController(getPlayerDecorator_3());
		levelView = new LevelView(levelController);
	}
	
	
}
