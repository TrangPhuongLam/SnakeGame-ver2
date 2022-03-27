package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Barrier;
import abstractSnakeGame.Food;

public class Swamp extends Barrier{
	private ImageIcon iconSwamp = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\swamp.png");
	public Swamp(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		resizeBarrier(iconSwamp);
	}


}
