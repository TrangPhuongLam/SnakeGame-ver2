package panel;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelContentHelp extends JPanel{
	private ImageIcon iconBack;
	private JButton btBack;
	public PanelContentHelp() {
		// TODO Auto-generated constructor stub
		//button Back
		ImageIcon iconBack = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\back.png");
		btBack = new JButton(iconBack);
		btBack.setBorderPainted(false);
		btBack.setContentAreaFilled(false);
		btBack.setFocusable(false);
		btBack.setPreferredSize(new Dimension(105,30));
		
		//add components to jPanel
		this.setOpaque(false);
		
		this.add(btBack);
	}
	
	public JButton getBtBack() {
		return btBack;
	}
	
	
}
