package controller;

import java.awt.Color;



import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import abstractSnakeGame.Barrier;
import abstractSnakeGame.Food;
import abstractSnakeGame.PaintMapObserver;
import abstractSnakeGame.ScreenGame;
import context.CollisionContext;
import context.EatingContext;
import decorater.PlayerDecorator_1;
import factory.FoodFactory;
import factory.PaintMapFactory;
import interfaceSnakeGame.ShapePlayer;
import model.Apple;
import model.Energy;
import model.Mushroom;
import model.Snake;
import model.Swamp;
import model.Wall;
import observer.PaintMap_ver1;
import panel.PanelContentPlayer;
import panel.PanelMap_1;
import panel.PanelReplayGame;
import subject.PlayerChose;
import view.ReplayView;


public class ScreenGameController {
	static ScreenGame screenGame;
	public static Snake snake;

	private EatingContext snakeEatingContext;
	private CollisionContext snakeCollisionContext;
	private PaintMapObserver paintMapObserver;
	private PlayerChose playerChose;
	

	public ScreenGameController(ScreenGame screenGame) {
		super();
		this.screenGame = screenGame;
		
		snake = new Snake(screenGame.width, screenGame.height);

		snakeEatingContext = new EatingContext(snake);
		snakeCollisionContext = new CollisionContext(snake);
		
		playerChose = new PlayerChose();
		paintMapObserver = new PaintMap_ver1(playerChose, snake);
		
	}
	
	public ScreenGameController() {
		this(screenGame);
	}
	
	
	public void paintMap(Graphics g, String playerDecoratorName, String paintMapName) {
		playerChose.setPlayerDecoratorName(playerDecoratorName);
		paintMapObserver.chosePaintMap(g, paintMapName);
	}


	public void startSnake() {
		if(snake.running) {
			snake.moving();
			snakeEatingContext.excuteEating(paintMapObserver.getApple(), 
					paintMapObserver.getMushroom(), paintMapObserver.getEnergy());
			
			snakeCollisionContext.excuteCollision(paintMapObserver.getWall(), 
					paintMapObserver.getSwamp());
			snake.returnSnake();
		}
	}
	
	public PanelReplayGame replayGame() {
		PanelReplayGame panelReplayGame = new PanelReplayGame();
		screenGame.add(panelReplayGame);
		return panelReplayGame;
	}
	
	public int speedSnake() {
		return snake.getSpeed();
	}
	
	public void snakeKeyPress(KeyEvent e) {
		Snake.HandlerKeyPress handlerKeyPress = snake.new HandlerKeyPress(e);
		System.out.println("snake key press");
	}
	
	public int getScreenWidth() {
		return screenGame.width;
	}
	
	public int getScreenHeight() {
		return screenGame.height;
	}

	public static Snake getSnake() {
		return snake;
	}



	
	
	
}
