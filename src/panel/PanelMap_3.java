package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ScreenGame;

public class PanelMap_3 extends ScreenGame{
	private ImageIcon iconBgMap3 =  new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\map_3.png");
	private static String playerDecorator = "playerDecorator1";
	private String mapName = "map3";
	
	public PanelMap_3(String playerDecoratorName) {
		this.playerDecoratorName = playerDecoratorName;
		resizeImage(iconBgMap3);
//		System.out.println("pannelMap_3(string)" + this.playerDecoratorName);
	}
	
	public PanelMap_3() {
		resizeImage(iconBgMap3);
		System.out.println("pannelMap_3()");
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		paintScreenGame(g);
//		System.out.println("in panel 3 panintComponent()" + this.playerDecoratorName);
		screenGameController.paintMap(g, this.playerDecoratorName, "paintmap3");
	}

	public String getMapName() {
		return mapName;
	}
	
	
}
