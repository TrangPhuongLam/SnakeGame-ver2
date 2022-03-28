package decorater;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ShapePlayerDecorator;
import interfaceSnakeGame.ShapePlayer;

public class PlayerDecorator_2 extends ShapePlayerDecorator{
	private ImageIcon iconHeadPlayer = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_Down.png");
	
	public PlayerDecorator_2(ShapePlayer playerDecorator) {
		super(playerDecorator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paintSkin(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSkin(g);
		paintPlayer(playerDecorator, g);
	}
	
	public void paintPlayer(ShapePlayer playerDecorator, Graphics g) {
		this.running = playerDecorator.getRunningPlayer();
		
		if (running) {
			for(int i = 0; i< bodyPlayer;i++) {
				if(i == 0) {
					g.drawImage(iconHeadPlayer.getImage(), x[i], y[i], 
							unit_size, unit_size, null);
				}
				
			}
			
		}
	}

}
