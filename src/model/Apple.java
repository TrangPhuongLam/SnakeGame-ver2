package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;
import interfaceSnakeGame.Controller;
import interfaceSnakeGame.Eating;

public class Apple extends Food {
	private ImageIcon iconApple = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao.png");
	public Apple(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		resizeFood(iconApple);
	}

}
