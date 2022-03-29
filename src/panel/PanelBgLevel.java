package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBgLevel extends JPanel{
	ImageIcon iconBgLevel;
	
	public PanelBgLevel() {
		// TODO Auto-generated constructor stub
		iconBgLevel = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\levelbg.png");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(iconBgLevel.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}
