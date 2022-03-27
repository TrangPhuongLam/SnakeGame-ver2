package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;

public class PanelMap_3 extends ScreenGame{
	private ImageIcon iconBgMap3 =  new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\map_3.png");
	public PanelMap_3() {
		// TODO Auto-generated constructor stub
		resizeImage(iconBgMap3);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		paintScreenGame(g);
		screenGameController.paintMap_3(g);
	}
}
