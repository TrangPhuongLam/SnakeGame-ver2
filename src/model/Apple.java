package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;

public class Apple extends Food{
	private ImageIcon iconApple;
	public Apple(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		iconApple = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao.png");
	}



	@Override
	public void paintFood(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(iconApple.getImage(), xFood, yFood, 
				iconApple.getIconWidth(), iconApple.getIconHeight(), null);
	}

}
