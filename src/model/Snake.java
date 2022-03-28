package model;

import java.awt.Color;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

import abstractSnakeGame.Barrier;
import abstractSnakeGame.Food;
import context.EatingContext;
import interfaceSnakeGame.Collision;
import interfaceSnakeGame.Eating;
import interfaceSnakeGame.ShapePlayer;
import view.GameFrameView;

public class Snake implements Eating, Collision, ShapePlayer{
	private char direction = 'R';
	static int screenWidth = 800, screenHeight = 600;
	public static int unit_size =50;
	static final int GAME_UNIT = (screenWidth * screenHeight) / (unit_size * unit_size);
	private int[] x = new int[GAME_UNIT];
	private int[] y = new int[GAME_UNIT];
	private int bodySnake = 3;
	public boolean running = true;
	private int appleEating = 0, mushroomEating = 0, energyEating = 0, swampEating = 0;
	private int speed = 0;
	
//	private HighScore highScore;
	private GameState state;
	private ImageIcon iconHeadUp, iconHeadDown, iconHeadLeft, iconHeadRight, iconBody, iconHead;
	
	public Snake(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		
		// TODO Auto-generated constructor stub

		iconHeadUp = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\Head_Up.png");
		iconHeadDown = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\Head_Down.png");
		iconHeadLeft = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\Head_Left.png");
		iconHeadRight = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\Head_Right.png");
		iconBody = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\body.png");
		
		
		iconHead = iconHeadRight;
		this.unit_size = iconHeadUp.getIconWidth();
		
		
		snakePositionInitial();
	}
	
	
	
	public void paintSnake(Graphics g) {
		for(int i = 0; i< bodySnake;i++) {
			if(i == 0) {
				g.drawImage(iconHead.getImage(), x[i], y[i], 
						unit_size, unit_size, null);
				
			}
			else {
				g.drawImage(iconBody.getImage(), x[i], y[i], 
						unit_size, unit_size, null);
			}			
		}
	}
	
	public static void setScreenWidth(int screenWidth) {
		Snake.screenWidth = screenWidth;
	}

	public static void setScreenHeight(int screenHeight) {
		Snake.screenHeight = screenHeight;
	}

	public void snakePositionInitial() {
		int sumOfSquare = screenWidth /unit_size;
		for (int i = 0; i < bodySnake; i++) {
			x[i] = (sumOfSquare / 2) * unit_size - (i * unit_size);
			y[i] = (sumOfSquare / 2) * unit_size ;
		}
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
	}
	
	public void eatFood(EatingContext Food) {
		
	}
	
	public void eatApple(Food apple) {
		if((x[0] == apple.getxFood()) && (y[0] == apple.getyFood())) {
			bodySnake++;
			appleEating++;
			apple.randomFood();
		}
	}

	public void eatMushroom(Food mushroom) {
		if (bodySnake < 2) {
			running = false;
			System.out.println("Game Over!");
			System.out.println("Apple eating: " + appleEating);
			System.out.println("Mushroom eating: " + mushroomEating);
		}else 
		if((x[0] == mushroom.getxFood()) && (y[0] == mushroom.getyFood())) {
			bodySnake--;
			mushroomEating++;
			mushroom.randomFood();
		}
	}
	
	public void eatEnergy(Food energy) {
		if((x[0] == energy.getxFood()) && (y[0] == energy.getyFood())) {
			if (speed < 400) {
				speed += 50;
			}
			energyEating++;
			energy.randomFood();
		}
	}
	
	
	public int getSpeed() {
		return speed;
	}

	public void collisionBody() {
		//checks if head collides with body
		for(int i = bodySnake;i>0;i--) {
			//check head move right to body 
			
			if((x[0] == x[i])&& (y[0] == y[i])) {
				running = false;
				System.out.println("Game Over!");
			}
		}
		
//		//check if head touches left border
//		if(x[0] < 0) {
//			running = false;
//		}
//		//check if head touches right border
//		if(x[0] > screenWidth) {
//			running = false;
//		}
//		//check if head touches top border
//		if(y[0] < 0) {
//			running = false;
//		}
//		//check if head touches bottom border
//		if(y[0] > screenHeight) {
//			running = false;
//		}
		
		
	}
	
	public void collisionWall(Barrier wall) {
		if((x[0] == wall.getxBarrier()) && (y[0] == wall.getyBarrier())) {
			running = false;
			
		}
	}
	
	public void collisionSwamp(Barrier swamp) {
		if((x[0] == swamp.getxBarrier()) && (y[0] == swamp.getyBarrier())) {
			if (speed > -100) {
				speed -= 50;
			}
			swampEating++;
			swamp.randomBarrier();
		}
	}
	
	public void moving() {
		//moving body
		for(int i = bodySnake;i>0;i--) {
			x[i] = x[i-1];
			y[i] = y[i-1];
		}
	
		//moving head
		switch(direction) {
		case 'U':
			y[0] = y[0] - unit_size;
			break;
		case 'D':
			y[0] = y[0] + unit_size;
			break;
		case 'L':
			x[0] = x[0] - unit_size;
			break;
		case 'R':
			x[0] = x[0] + unit_size;
			break;
		}
	}
	
	public void returnSnake() {
		//Right side
		if (x[0] == screenWidth) {
			for (int i = 0; i < bodySnake; i++) {
				x[i] = 0 - (i * unit_size);
				
			}
		}else
			//Left side
			if (x[0] == (0 - unit_size)) {
				for (int i = 0; i < bodySnake; i++) {
					x[i] = screenWidth + ((i - 1) * unit_size);
					
				}
		}else
			//Bottom side
			if (y[0] == screenHeight) {
				for (int i = 0; i < bodySnake; i++) {
					y[i] = 0 - (i * unit_size);
					
				}
		}else
			//Top side
			if (y[0] == (0 - unit_size)) {
				for (int i = 0; i < bodySnake; i++) {
					y[i] = screenHeight + ((i - 1) * unit_size);
					
				}
		}
		
	}
	
	
	
	public int getAppleEating() {
		return appleEating;
	}

	public int getMushroomEating() {
		return mushroomEating;
	}

	public int getEnergyEating() {
		return energyEating;
	}

	public int getSwampEating() {
		return swampEating;
	}

	public class HandlerKeyPress implements KeyListener{
		public HandlerKeyPress(KeyEvent e) {
			// TODO Auto-generated constructor stub
			keyPressed(e);
			keyTyped(e);
			keyReleased(e);
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyChar() ){
			case 'a':
				if(direction != 'R') {
					direction = 'L';
					iconHead = iconHeadLeft;
				}
				break;
			case 'd':
				if(direction != 'L') {
					direction = 'R';
					iconHead = iconHeadRight;
				}
				break;
			case 'w':
				if(direction != 'D') {
					direction = 'U';
					iconHead = iconHeadUp;
				}
				break;
			case 's':
				if(direction != 'U') {
					direction = 'D';
					iconHead = iconHeadDown;
				}
				break;

			default:
				break;
			}
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(direction != 'R') {
					direction = 'L';
					iconHead = iconHeadLeft;
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(direction != 'L') {
					direction = 'R';
					iconHead = iconHeadRight;
				}
				break;
			case KeyEvent.VK_UP:
				if(direction != 'D') {
					direction = 'U';
					iconHead = iconHeadUp;
				}
				break;
			case KeyEvent.VK_DOWN:
				if(direction != 'U') {
					direction = 'D';
					iconHead = iconHeadDown;
				}
				break;

			default:
				break;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public void paintSkin(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0; i< bodySnake;i++) {
			if(i == 0) {
				g.drawImage(iconHead.getImage(), x[i], y[i], 
						unit_size, unit_size, null);
			}
			else {
				g.drawImage(iconBody.getImage(), x[i], y[i], 
						unit_size, unit_size, null);
			}	
	}
	}



	@Override
	public int[] getXPlayer() {
		// TODO Auto-generated method stub
		return x;
	}



	@Override
	public int[] getYPlayer() {
		// TODO Auto-generated method stub
		return y;
	}



	@Override
	public int getUnit_size() {
		// TODO Auto-generated method stub
		return unit_size;
	}



	@Override
	public int setUnit_size(int unit_size) {
		// TODO Auto-generated method stub
		return this.unit_size = unit_size;
	}



	@Override
	public int getBodyPlayer() {
		// TODO Auto-generated method stub
		return bodySnake;
	}



	@Override
	public int getGAME_UNIT() {
		// TODO Auto-generated method stub
		return GAME_UNIT;
	}



	@Override
	public boolean getRunningPlayer() {
		// TODO Auto-generated method stub
		return running;
	}



	@Override
	public char getDirection() {
		// TODO Auto-generated method stub
		return direction;
	}



}
