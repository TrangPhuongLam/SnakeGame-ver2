package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import abstractSnakeGame.Food;

public class Mushroom extends Food{
	private ImageIcon iconMushroom = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom.png");
	
	
	public Mushroom(int screenWidth, int screenHeight, int unit_size) {
		super(screenWidth, screenHeight, unit_size);
		// TODO Auto-generated constructor stub
		resizeFood(iconMushroom);
		
		image1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom.png").getImage();
		image2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom1.png").getImage();
		image3 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom2.png").getImage();
		
		animation = new Animation(unit_size, unit_size);
		animation.addImage(image1);
		animation.addImage(image2);
		animation.addImage(image3);
	}

@Override
public void paintFood(Graphics g) {
	// TODO Auto-generated method stub
	animation.paintAnimation(g, this.xFood, this.yFood);
}
}
