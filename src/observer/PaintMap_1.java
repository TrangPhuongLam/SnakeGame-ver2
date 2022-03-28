package observer;

import java.awt.Graphics;

import abstractSnakeGame.PaintMapObserver;
import controller.PlayerController;
import factory.PlayerDecoratorFactory;
import interfaceSnakeGame.ShapePlayer;

public class PaintMap_1 extends PaintMapObserver{

	public PaintMap_1(PlayerController playerController) {
		super(playerController);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintMap(Graphics g, ShapePlayer playerDecorator) {
		// TODO Auto-generated method stub
		PlayerDecoratorFactory factory = new PlayerDecoratorFactory();
		
		ShapePlayer player = factory.getPlayerDecorator(playerController.getPlayerDecoratorName(), playerDecorator);
		player.paintSkin(g);
	}

}
