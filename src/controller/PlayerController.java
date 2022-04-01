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
import view.MenuView;
import view.PlayerView;

public class PlayerController {
	private PlayerView playerView;
	private String playerDecoratorName = "playerDecorator1";
	private LevelController levelController;
	private LevelView levelView;
	
	public PlayerController(PlayerView playerView) {
		// TODO Auto-generated constructor stub
		this.playerView = playerView;
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
		
		levelView =  new LevelView(getPlayerDecorator_1());
		playerView.dispose();
	}

	public void chosePlayerDecorator_2() {
		
		levelView =  new LevelView(getPlayerDecorator_2());
		playerView.dispose();
	}
	
	public void chosePlayerDecorator_3() {
		
		levelView =  new LevelView(getPlayerDecorator_3());
		playerView.dispose();
	}
	
	public void backMenuView() {
		MenuView menuView = new MenuView();
		playerView.dispose();
	}
	
	
}
