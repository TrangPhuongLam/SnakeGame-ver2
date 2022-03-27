package decorater;

import java.awt.Graphics;

import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import abstractSnakeGame.ShapePlayerDecorator;
import interfaceSnakeGame.ShapePlayer;

public class PlayerDecorater_1 extends ShapePlayerDecorator{
	private ImageIcon iconHeadPlayer = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\crown.png");
	private int[] x = new int[1], y = new int[1];
	private int bodyPlayer = 1;
	private int unit_size = 1;
	
	
	public PlayerDecorater_1(ShapePlayer playerDecorator) {
		super(playerDecorator);
		// TODO Auto-generated constructor stub
		this.x = new int[playerDecorator.getGAME_UNIT()];
		this.y = new int[playerDecorator.getGAME_UNIT()];
		this.x = playerDecorator.getXPlayer();
		this.y = playerDecorator.getYPlayer();
		this.bodyPlayer = playerDecorator.getBodyPlayer();
		this.unit_size = playerDecorator.getUnit_size();
	}
	@Override
	public void paintSkin(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSkin(g);
		System.out.println("I'm in player deco 1 paintskin");
		paintPlayer(playerDecorator, g);
	}
	
	public void paintPlayer(ShapePlayer playerDecorator, Graphics g) {
		for(int i = 0; i< bodyPlayer;i++) {
			if(i == 0) {
				g.drawImage(iconHeadPlayer.getImage(), x[i], y[i], 
						unit_size, unit_size, null);
			}
		}
		System.out.println("I'm in CharacterDecorater_1");
	}
	@Override
	public int[] getXPlayer() {
		// TODO Auto-generated method stub
		return x;
	}
	@Override
	public int[] getYPlayer() {
		// TODO Auto-generated method stub
		return y;
	}
	@Override
	public int getUnit_size() {
		// TODO Auto-generated method stub
		return unit_size;
	}
	@Override
	public int setUnit_size(int unit_size) {
		// TODO Auto-generated method stub
		return this.unit_size = unit_size;
	}
	@Override
	public int getBodyPlayer() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getGAME_UNIT() {
		// TODO Auto-generated method stub
		return 0;
	}

}
