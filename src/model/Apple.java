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
		
		image1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao.png").getImage();
		image2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao1.png").getImage();
		image3 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao2.png").getImage();
		image4 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao3.png").getImage();
		
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
