package panel;

import java.awt.Graphics;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;


public class PanelMap_1 extends ScreenGame{
	private ImageIcon iconBgMap1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\map_1.png");
	private String mapName = "map1";
	
	public PanelMap_1(String playerDecoratorName) {
		this.playerDecoratorName = playerDecoratorName;
		resizeImage(iconBgMap1);
//		System.out.println("pannelMap_1(string)" + this.playerDecoratorName);
	}
	
	public PanelMap_1() {
		resizeImage(iconBgMap1);
		System.out.println("pannelMap_1()");
	}
	
	

//	@Override
//	protected void paintComponent(Graphics g) {
//		
//		paintScreenGame(g);
//		System.out.println("in panel 1 panintComponent()" + this.playerDecoratorName);
//		screenGameController.paintMap(g, this.playerDecoratorName, "paintmap1");
//	}
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		paintScreenGame(g);
//		System.out.println("in panel 1 panintComponent()" + this.playerDecoratorName);
		screenGameController.paintMap(g, this.playerDecoratorName, "paintmap1");
	}

	public String getMapName() {
		return mapName;
	}
	
	

	

	
	

}
