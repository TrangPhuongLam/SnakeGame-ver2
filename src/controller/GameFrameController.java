package controller;

import java.awt.event.KeyEvent;

import abstractSnakeGame.ScreenGame;
import model.Snake;
import panel.PanelNavigationGameFrame;
import view.GameFrameView;

public class GameFrameController {
	public GameFrameView gameFrameView ;
	public ScreenGame screenGame;

	public GameFrameController(GameFrameView gameFrameView) {
		super();
		this.gameFrameView = gameFrameView;
		screenGame = gameFrameView.getScreenGame();
		
	}
	
	public void getKeyPressSnake(KeyEvent e) {
		ScreenGame.ScreenGameKeyPress handlerKeyPress = screenGame.new ScreenGameKeyPress(e);
	}
	
	
	
}
