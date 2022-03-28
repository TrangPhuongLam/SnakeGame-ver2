package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;

public class Energy extends Food{
	private ImageIcon iconEnergy = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\energy.png");
	public Energy(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		resizeFood(iconEnergy);
	}


}
