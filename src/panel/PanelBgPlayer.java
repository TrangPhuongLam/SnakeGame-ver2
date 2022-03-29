package panel;

import java.awt.Graphics;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBgPlayer extends JPanel{
	private ImageIcon iconBgPlayer;
	
	public PanelBgPlayer() {
		// TODO Auto-generated constructor stub
		iconBgPlayer = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\playerbg.png");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		g.drawImage(iconBgPlayer.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}
