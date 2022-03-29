package abstractSnakeGame;

import java.awt.Graphics;

import controller.PlayerController;
import factory.BarrierFactory;
import factory.FoodFactory;
import factory.PaintMapFactory;
import factory.PlayerDecoratorFactory;
import interfaceSnakeGame.ShapePlayer;
import subject.PlayerChose;

public abstract class PaintMapObserver {
	protected PlayerChose playerChose;
	
	protected PlayerDecoratorFactory playerDecoratorFactory = new PlayerDecoratorFactory();
	protected FoodFactory foodFactory = new FoodFactory();
	protected BarrierFactory barrierFactory = new BarrierFactory();
	protected PaintMapFactory paintMapFactory = new PaintMapFactory();
	protected ShapePlayer player, playerDecorator ;
	protected Food apple , mushroom, energy;
	protected Barrier wall, swamp;

	public PaintMapObserver(PlayerChose playerChose, ShapePlayer player) {
		super();
		this.playerChose = playerChose;
		this.playerChose.attach(this);
		this.player = player;
	}
	
	public abstract void paintMap(Graphics g);
	public abstract void paintMap_1(Graphics g);
	public abstract void paintMap_2(Graphics g);
	public abstract void paintMap_3(Graphics g);

	public void updatePlayerDecorator() {
		this.playerDecorator = playerDecoratorFactory.getPlayerDecorator(this.playerChose.getPlayerDecoratorName(),
				this.player);
	}
	
	public void chosePaintMap(Graphics g, String paintMapName) {
		if (paintMapName.equalsIgnoreCase("PAINTMAP1")) {
			paintMap_1(g);
		}else 
			if (paintMapName.equalsIgnoreCase("PAINTMAP2")) {
			paintMap_2(g);
		}else 
			if (paintMapName.equalsIgnoreCase("PAINTMAP3")) {
			paintMap_3(g);
		}
	}

	public Food getApple() {
		return apple;
	}

	public Food getMushroom() {
		return mushroom;
	}

	public Food getEnergy() {
		return energy;
	}

	public Barrier getWall() {
		return wall;
	}

	public Barrier getSwamp() {
		return swamp;
	}
	
	
	
}
