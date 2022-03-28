package decorater;

import java.awt.Graphics;

import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import abstractSnakeGame.ShapePlayerDecorator;
import interfaceSnakeGame.ShapePlayer;

public class PlayerDecorator_1 extends ShapePlayerDecorator{
//	private ImageIcon iconHead_Down, iconHead_Up, iconHead_Left, iconHead_Right, iconHead;
	
	
	
	public PlayerDecorator_1(ShapePlayer playerDecorator) {
		super(playerDecorator);
		// TODO Auto-generated constructor stub
		iconHead_Down = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\crown.png"); 
		iconHead_Up = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_Down.png");
		iconHead_Left = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\swamp.png");
		iconHead_Right = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao.png");
		
		iconHead = iconHead_Right;
	}
	@Override
	public void paintSkin(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSkin(g);
		paintPlayer(playerDecorator, g);
	}
	
	
	
	

}
