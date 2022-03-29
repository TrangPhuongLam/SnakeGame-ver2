package observer;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.PaintMapObserver;
import interfaceSnakeGame.ShapePlayer;
import subject.PlayerChose;

public class PaintMap_ver2 extends PaintMapObserver{
	public PaintMap_ver2(PlayerChose playerChose, ShapePlayer player) {
		super(playerChose, player);
		// TODO Auto-generated constructor stub
		System.out.println("in paint map 1 (playerchose, player) " + this.playerChose.getPlayerDecoratorName());
		this.playerDecorator = playerDecoratorFactory.getPlayerDecorator(this.playerChose.getPlayerDecoratorName(), 
				this.player);
		this.apple = foodFactory.getFood("apple", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
		
		this.mushroom = foodFactory.getFood("mushroom", this.player.getScreenWidth(), 
				this.player.getScreenHeight(), this.player.getUnit_size());
		
//		this.energy = foodFactory.getFood("energy", this.player.getScreenWidth(), 
//				this.player.getScreenHeight(), this.player.getUnit_size());
		
	}
	

	@Override
	public void paintMap(Graphics g) {
		//Paint player decorator
		playerDecorator.paintSkin(g);
		
		//Paint food
		apple.paintFood(g);
		mushroom.paintFood(g);
//		energy.paintFood(g);
	}


	@Override
	public void paintMap_1(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void paintMap_2(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void paintMap_3(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
