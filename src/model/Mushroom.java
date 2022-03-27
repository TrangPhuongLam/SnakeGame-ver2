package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;

public class Mushroom extends Food{
	private ImageIcon iconMushroom = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom.png");
	public Mushroom(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		resizeFood(iconMushroom);
	}


}
