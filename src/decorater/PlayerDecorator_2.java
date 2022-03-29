package decorater;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ShapePlayerDecorator;
import interfaceSnakeGame.ShapePlayer;

public class PlayerDecorator_2 extends ShapePlayerDecorator{
	
	public PlayerDecorator_2(ShapePlayer playerDecorator) {
		super(playerDecorator);
		// TODO Auto-generated constructor stub
		iconHead_Down = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_down.png"); 
		iconHead_Up = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_up.png");
		iconHead_Left = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_left.png");
		iconHead_Right = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_right.png");
		
		iconHead = iconHead_Right;
	}

	@Override
	public void paintSkin(Graphics g) {
		// TODO Auto-generated method stub
		super.paintSkin(g);
		paintPlayer(playerDecorator, g);
	}
	
	public void paintPlayer(ShapePlayer playerDecorator, Graphics g) {
		this.running = playerDecorator.getRunningPlayer();
		directionIconHead();
		if (running) {
			for(int i = 0; i< bodyPlayer;i++) {
				if(i == 0) {
					g.drawImage(iconHead.getImage(), x[i] - 10, y[i] - 10, 
							unit_size + 20, unit_size + 20, null);
				}
				
			}
			
		}
		
	}

}
