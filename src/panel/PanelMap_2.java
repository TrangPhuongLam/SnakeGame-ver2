package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;

public class PanelMap_2 extends ScreenGame{
	private ImageIcon iconBgMap2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\map_2.jpg");
	private String mapName = "map2"; 
	
	public PanelMap_2(String playerDecoratorName) {
		this.playerDecoratorName = playerDecoratorName;
		resizeImage(iconBgMap2);
//		System.out.println("pannelMap_2(string)" + this.playerDecoratorName);
	}
	
	public PanelMap_2() {
		resizeImage(iconBgMap2);
		System.out.println("pannelMap_2()");
	}
	
	

	@Override
	protected void paintComponent(Graphics g) {
		paintScreenGame(g);
//		System.out.println("in panel 2 panintComponent()" + this.playerDecoratorName);
		screenGameController.paintMap(g, this.playerDecoratorName, "paintmap2");
	}

	public String getMapName() {
		return mapName;
	}
	
	

}
