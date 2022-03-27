package abstractSnakeGame;

import java.awt.Graphics;

import interfaceSnakeGame.ShapePlayer;

public abstract class ShapePlayerDecorator implements ShapePlayer{
	protected ShapePlayer playerDecorator;

	public ShapePlayerDecorator(ShapePlayer playerDecorator) {
		super();
		this.playerDecorator = playerDecorator;
	}
	
	public void paintSkin(Graphics g) {
		System.out.println("I'm in ShapeCharacterDecorator");
		playerDecorator.paintSkin(g);
		
	}
}
