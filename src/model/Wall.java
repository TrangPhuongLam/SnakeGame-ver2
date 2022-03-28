package model;

import javax.swing.ImageIcon;

import abstractSnakeGame.Barrier;

public class Wall extends Barrier{
	private ImageIcon iconWall = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\wall.png");
	public Wall(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		resizeBarrier(iconWall);
		randomBarrier();
	}

	@Override
	public void randomBarrier() {
		// TODO Auto-generated method stub
		super.randomBarrier();
		
	}
}
