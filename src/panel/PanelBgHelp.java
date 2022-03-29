package panel;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelBgHelp extends JPanel{
	private ImageIcon iconBgHelp;
	
	public PanelBgHelp() {
		// TODO Auto-generated constructor stub
		iconBgHelp = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\helpbg.png");
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(iconBgHelp.getImage(), 0, 0,getWidth(), getHeight(), null);
	}

}
