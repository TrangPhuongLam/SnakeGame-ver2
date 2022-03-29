package controller;

import java.io.IOException;

import abstractSnakeGame.ScreenGame;
import model.HighScore;
import model.Snake;
import panel.PanelNavigationGameFrame;

public class NavigationController {
	private PanelNavigationGameFrame panelNavigationGameFrame;
	private ScreenGame  screenGame;
	private ScreenGameController screenGameController;
	private HighScore highScore = new HighScore();
	

	public NavigationController(PanelNavigationGameFrame panelNavigationGameFrame, ScreenGame  screenGame) {
		super();
		this.panelNavigationGameFrame = panelNavigationGameFrame;
		this.screenGame = screenGame;
		this.screenGameController = screenGame.getScreenGameController();
	}
	
	public boolean handlerScore() throws ClassNotFoundException, IOException {
		Snake snake = screenGameController.getSnake();
		int highScore = 0;
		//read file HighScore.ser
		highScore = this.highScore.readHightScore();
		
		panelNavigationGameFrame.setAppleScore(snake.getAppleEating());
		panelNavigationGameFrame.setMushroomScore(snake.getMushroomEating());
		panelNavigationGameFrame.setEnergyScore(snake.getEnergyEating());
		panelNavigationGameFrame.setSwampScore(snake.getSwampEating());
		panelNavigationGameFrame.setHighScore(highScore);
		
		
		//Update (write) HighScore.ser
		if (panelNavigationGameFrame.getAppleScore() > highScore) {
			this.highScore.updateHightScore(panelNavigationGameFrame.getAppleScore());
			panelNavigationGameFrame.setHighScore(panelNavigationGameFrame.getAppleScore());
		}
		
		return  snake.getRunningPlayer();
	}
	
}
