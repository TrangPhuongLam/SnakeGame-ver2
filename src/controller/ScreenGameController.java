package controller;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import abstractSnakeGame.Barrier;
import abstractSnakeGame.Food;
import abstractSnakeGame.ScreenGame;
import model.Apple;
import model.Energy;
import model.GameState;
import model.Mushroom;
import model.Snake;
import model.Swamp;
import model.Wall;
import panel.PanelMap_1;


public class ScreenGameController {
	ScreenGame screenGame;
	public static Snake snake;
	private GameState state;

//	private Score score;
	Food apple, mushroom, energy;
	Barrier swamp, wall;

	public ScreenGameController(ScreenGame screenGame) {
		super();
		this.screenGame = screenGame;
		
		snake = new Snake(screenGame.width, screenGame.height);
//		state = new GameState();
//		score = new Score();

		apple = new Apple(screenGame.width, screenGame.height, snake.unit_size);
		mushroom = new Mushroom(screenGame.width, screenGame.height, snake.unit_size);
		energy = new Energy(screenGame.width, screenGame.height, snake.unit_size);
		swamp = new Swamp(screenGame.width, screenGame.height, snake.unit_size);
		wall = new Wall(screenGame.width, screenGame.height, snake.unit_size);
		
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
		
		snake.paintSnake(g);
		apple.paintFood(g);
		mushroom.paintFood(g);
		
	}
	
	public void paintMap_1(Graphics g) {
		snake.paintSnake(g);
		apple.paintFood(g);
		
	}
	
	public void paintMap_2(Graphics g) {
		snake.paintSnake(g);
		apple.paintFood(g);
		mushroom.paintFood(g);
	}
	
	public void paintMap_3(Graphics g) {
		snake.paintSnake(g);
		apple.paintFood(g);
		mushroom.paintFood(g);
		energy.paintFood(g);
		swamp.paintBarrier(g);
		wall.paintBarrier(g);
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
			snake.eatApple(apple);
			snake.eatMushroom(mushroom);
			snake.eatEnergy(energy);
			snake.collisionBody();
			snake.collisionSwamp(swamp);
			snake.collisionWall(wall);
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
	
}
