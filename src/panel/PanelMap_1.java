package panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;


public class PanelMap_1 extends ScreenGame{
	private ImageIcon iconBgMap1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\map_1.png");
	
	public PanelMap_1() {
		// TODO Auto-generated constructor stub
		resizeImage(iconBgMap1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		paintScreenGame(g);
		screenGameController.paintMap_1(g);
	}
	

	

	
	

}
