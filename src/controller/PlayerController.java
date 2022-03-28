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
import view.PlayerView;

public class PlayerController {
	private PlayerView playerView;
	private String playerDecoratorName = "playerDecorator2";
	private ArrayList<PaintMapObserver> paintMapObservers = new ArrayList<PaintMapObserver>();
	
	private ScreenGameController screenGameController;

	public PlayerController() {
		super();
	}
	
	public void attach(PaintMapObserver map) {
		paintMapObservers.add(map);
	}
	
	public String getPlayerDecoratorName() {
		return playerDecoratorName;
	}

	public void setPlayerDecoratorName(String playerDecoratorName) {
		this.playerDecoratorName = playerDecoratorName;
	}


}
