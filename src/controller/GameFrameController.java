package controller;

import java.awt.Graphics;
import java.awt.event.KeyEvent;


import abstractSnakeGame.ScreenGame;
import gameState.PauseGame;
import gameState.StartGame;
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
		screenGame.getScreenGameController().snakeKeyPress(e);
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (screenGame.getState().equals(StartGame.getInstance())) {
				screenGame.setState(PauseGame.getInstance());
			}else 
				 if (screenGame.getState().equals(PauseGame.getInstance())) {
					screenGame.setState(StartGame.getInstance());
			}
		}
		
	}
	
	public void paintState(Graphics g) {
		screenGame.getState().paintState(g);
	}
	
	
	
}
