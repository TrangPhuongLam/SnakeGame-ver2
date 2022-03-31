package observer;

import java.awt.Graphics;
import java.util.Arrays;

import abstractSnakeGame.Food;
import abstractSnakeGame.PaintMapObserver;
import controller.PlayerController;
import factory.FoodFactory;
import factory.PlayerDecoratorFactory;
import interfaceSnakeGame.ShapePlayer;
import subject.PlayerChose;

public class PaintMap_ver1 extends PaintMapObserver{
	public PaintMap_ver1(PlayerChose playerChose, ShapePlayer player) {
		super(playerChose, player);
		// TODO Auto-generated constructor stub
		System.out.println("in paint map ver 1 (playerchose, player) " + this.playerChose.getPlayerDecoratorName());
		this.playerDecorator = playerDecoratorFactory.getPlayerDecorator(this.playerChose.getPlayerDecoratorName(), 
				this.player);
		this.apple = foodFactory.getFood("apple", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
		
		this.mushroom = foodFactory.getFood("mushroom", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
		
		this.energy = foodFactory.getFood("energy", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
		
		this.swamp = barrierFactory.getBarrier("swamp", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
		
		this.wall = barrierFactory.getBarrier("wall", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
	}
	

	@Override
	public void paintMap(Graphics g) {
		//Paint player decorator
		playerDecorator.paintSkin(g);
//		System.out.println();
		//Paint food
		apple.paintFood(g);
	}


	@Override
	public void paintMap_1(Graphics g) {
		// TODO Auto-generated method stub
		playerDecorator.paintSkin(g);
		
		//Paint food
		apple.paintFood(g);
		mushroom.paintFood(g);
	}


	@Override
	public void paintMap_2(Graphics g) {
		// TODO Auto-generated method stub
		playerDecorator.paintSkin(g);
		
		//Paint food
		apple.paintFood(g);
		mushroom.paintFood(g);
		energy.paintFood(g);
		
		//Paint Barrier
		swamp.paintBarrier(g);
	}


	@Override
	public void paintMap_3(Graphics g) {
		// TODO Auto-generated method stub
		playerDecorator.paintSkin(g);
		
		//Paint food
		apple.paintFood(g);
		mushroom.paintFood(g);
		energy.paintFood(g);
		
		//Paint Barrier
		swamp.paintBarrier(g);
		wall.paintBarrier(g);
		
//		System.out.println("im in paint map 3");
	}

}
