package panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;


public class PanelMap_1 extends ScreenGame{
	private ImageIcon iconBgScreenGame;
	
	public PanelMap_1() {
		// TODO Auto-generated constructor stub
		iconBgScreenGame = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\bg.png");
	}
	@Override
	public void paintScreenGame(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(iconBgScreenGame.getImage(), 0, 0, getWidth(), getHeight(), null);
	}

	

	
	

}
