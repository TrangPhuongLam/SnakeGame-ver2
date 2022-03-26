package controller;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;
import abstractSnakeGame.ScreenGame;
import model.Apple;
import model.GameState;
import model.Mushroom;
import model.Snake;
import panel.PanelMap_1;


public class ScreenGameController {
	ScreenGame screenGame;
	public static Snake snake;
	private GameState state;

//	private Score score;
	public static int[][] frameGame;
	Food apple, mushroom;

	long t = 0;
	long t1 = 0;
	long t2 = 0;

	public ScreenGameController(ScreenGame screenGame) {
		super();
//		init();
		this.screenGame = screenGame;
		
		snake = new Snake(screenGame.width, screenGame.height);
//		state = new GameState();
//		score = new Score();

		apple = new Apple(screenGame.width, screenGame.height, snake.unit_size);
		mushroom = new Mushroom(screenGame.width, screenGame.height, snake.unit_size);
		

		
	}
	
	public void init() {
//		Data.loadImage();
//		Data.loadAnimation();
	}
	
	public int sizeFrame() {
		return frameGame.length;
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
			snake.collision();
			snake.returnSnake();
		}else {
		}
		
	}
	
	public void handlerKeyPress(KeyEvent e) {
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
