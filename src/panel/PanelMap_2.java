package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;

public class PanelMap_2 extends ScreenGame{
	private ImageIcon iconBgMap2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\map_2.jpg");
	
	public PanelMap_2() {
		// TODO Auto-generated constructor stub
		resizeImage(iconBgMap2);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		paintScreenGame(g);
		screenGameController.paintMap_2(g);
	}
	
	

}
