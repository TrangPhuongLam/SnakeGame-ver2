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
import model.GameState;
import model.Mushroom;
import model.Snake;
import model.Swamp;
import model.Wall;
import observer.PaintMap_ver1;
import panel.PanelMap_1;
import subject.PlayerChose;


public class ScreenGameController {
	static ScreenGame screenGame;
	public static Snake snake;
	private GameState state;

//	private Score score;
	Food apple, mushroom, energy;
	Barrier swamp, wall;
	private EatingContext snakeEatingContext;
	private CollisionContext snakeCollisionContext;
	private PaintMapObserver paintMapObserver;
	private PlayerChose playerChose;
	
	private FoodFactory foodFactory;
	private PaintMapFactory paintMapFactory;

	public ScreenGameController(ScreenGame screenGame) {
		super();
		this.screenGame = screenGame;
		
		snake = new Snake(screenGame.width, screenGame.height);
//		state = new GameState();
//		score = new Score();

		foodFactory = new FoodFactory();
		paintMapFactory = new PaintMapFactory();
		
		swamp = new Swamp(screenGame.width, screenGame.height, snake.unit_size);
		wall = new Wall(screenGame.width, screenGame.height, snake.unit_size);
		
		snakeEatingContext = new EatingContext(snake);
		snakeCollisionContext = new CollisionContext(snake);
		
		
		
		playerChose = new PlayerChose();
		paintMapObserver = new PaintMap_ver1(playerChose, snake);
		
	}
	
	public ScreenGameController() {
		this(screenGame);
	}
	//Paint character: snake, food, barrier
	public void paint(Graphics g) {
		
//		if (!state.getPlaying())
//			if (!state.getStartGame()) {
//				g.setColor(Color.red);
//				g.setFont(g.getFont().deriveFont(18.0f));
//				g.drawString("PRESS SPACE TO PLAYING GAME", 60, 150);
//			}
//		if (state.getgameOver()) {
//			g.setColor(Color.red);
//			g.setFont(g.getFont().deriveFont(18.0f));
//			g.drawString("OVER GAME!!!", 120, 150);
//			state.setStartGame(true);
//		}
		
//		snake.paintSnake(g);
		
	}
	
	
	public void paintMap(Graphics g, String playerDecoratorName, String paintMapName) {
		playerChose.setPlayerDecoratorName(playerDecoratorName);
		paintMapObserver.chosePaintMap(g, paintMapName);
	}

	public void state() {
//		if (!state.getgameOver()) {
//			if (state.getPlaying()) {
//
//				if (System.currentTimeMillis() - t1 > 300) {
//					Data.apple.update();
//					t1 = System.currentTimeMillis();
//				}
//				if (System.currentTimeMillis() - t2 > 200) {
//					Data.mushroom.update();
//					t2 = System.currentTimeMillis();
//				}
//				snake.update();
//			} else {
//				if (System.currentTimeMillis() - t > 500) {
//					state.setStartGame(!state.getStartGame());
//					t = System.currentTimeMillis();
//				}
//			}
//		}
	}

	public void startGame() {
		if(snake.running) {
			snake.moving();
			snakeEatingContext.excuteEating(paintMapObserver.getApple(), 
					paintMapObserver.getMushroom(), paintMapObserver.getEnergy());
			snakeCollisionContext.excuteCollision(wall, swamp);
			snake.returnSnake();
		}else {
		}
		
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
