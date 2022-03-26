package model;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;

public class Mushroom extends Food{
	private ImageIcon iconMushroom;
	public Mushroom(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		iconMushroom = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom.png");
	}

	@Override
	public void paintFood(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(iconMushroom.getImage(), xFood, yFood, 
				iconMushroom.getIconWidth(), iconMushroom.getIconHeight(), null);
	}

}
