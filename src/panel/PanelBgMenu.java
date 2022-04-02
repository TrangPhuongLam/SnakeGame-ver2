package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBgMenu extends JPanel{
	private ImageIcon iconBgMenu;
	
	public PanelBgMenu() {
		// TODO Auto-generated constructor stub
		iconBgMenu = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\Background_desktop.png"); 
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(iconBgMenu.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
}
