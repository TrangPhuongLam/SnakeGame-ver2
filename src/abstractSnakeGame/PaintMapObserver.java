package abstractSnakeGame;

import java.awt.Graphics;

import controller.PlayerController;
import interfaceSnakeGame.ShapePlayer;

public abstract class PaintMapObserver {
	protected PlayerController playerController;

	public PaintMapObserver(PlayerController playerController) {
		super();
		this.playerController = playerController;
//		this.playerController.attach(this);
	}
	
	public abstract void paintMap(Graphics g, ShapePlayer playerDecorator);
}
