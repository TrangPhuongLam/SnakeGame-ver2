package decorater;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import abstractSnakeGame.ShapePlayerDecorator;
import interfaceSnakeGame.ShapePlayer;

public class PlayerDecorator_3 extends ShapePlayerDecorator{
	private ImageIcon iconHeadPlayer = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\superman.png");
	public PlayerDecorator_3(ShapePlayer playerDecorator) {
		super(playerDecorator);
		// TODO Auto-generated constructor stub
		iconHead_Down = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman_down.png"); 
		iconHead_Up = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman_up.png");
		iconHead_Left = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman_left.png");
		iconHead_Right = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman_right.png");
		
		iconHead = iconHead_Right;
		
		iconBody = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman_body.png"); 
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
				if(i == 1) {
					g.drawImage(iconHead.getImage(), x[i] - 5, y[i] - 5, 
							unit_size + 10, unit_size +10, null);
				}else if (i > 1 ) {
					g.drawImage(iconBody.getImage(), x[i] - 5, y[i] - 5, 
							unit_size + 10, unit_size +10, null);
				}
				
				
				
			}
			
		}
		
	}

}
