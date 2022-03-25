package controller;

import java.awt.Color;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;
import abstractSnakeGame.ScreenGame;
import model.Apple;
import model.GameState;
import model.Mushroom;
import model.Snake;


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
//		snake = new Snake();
//		state = new GameState();
//		score = new Score();

//		apple = new Apple();
//		mushroom = new Mushroom();
		
		// board = new Board(20, 20);

		frameGame = new int[20][20]; // do rong cua bang la 20

		frameGame[5][6] = 2;
		frameGame[14][10] = -2;
		
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
//		g.drawImage(new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\bg.png").getImage(), 0, 0, null);
//		g.fillRect(0, 0, width, height);		
//		apple.paint(g);
//		mushroom.paint(g);
//		snake.paint(g);
		if (!state.getPlaying())
			if (!state.getStartGame()) {
				g.setColor(Color.red);
				g.setFont(g.getFont().deriveFont(18.0f));
				g.drawString("PRESS SPACE TO PLAYING GAME", 60, 150);
			}
		if (state.getgameOver()) {
			g.setColor(Color.red);
			g.setFont(g.getFont().deriveFont(18.0f));
			g.drawString("OVER GAME!!!", 120, 150);
			state.setStartGame(true);
		}
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

	
	
}
