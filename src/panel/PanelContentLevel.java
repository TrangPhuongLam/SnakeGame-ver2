package panel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelContentLevel extends JPanel{
	private JButton btMap1, btMap2, btMap3, btBack;
	private ImageIcon iconMap1, iconMap2, iconMap3, iconBack;
	private final int 	WIDTH = 150, HEIGHT = 300;
	
	public PanelContentLevel() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(6, 1));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		iconMap1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\easy.png");
		btMap1 = new JButton(iconMap1);
		btMap1.setBorderPainted(false);
		btMap1.setContentAreaFilled(false);
		btMap1.setFocusable(false);
		btMap1.setPreferredSize(new Dimension(105, 30));
//		btMap1.addMouseListener(levelController);

		// create button Normal, hidden background button Normal and event button Normal

		iconMap2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\normal.png");
		btMap2 = new JButton(iconMap2);
		btMap2.setBorderPainted(false);
		btMap2.setContentAreaFilled(false);
		btMap2.setFocusable(false);
		btMap2.setPreferredSize(new Dimension(105, 30));
//		btMap2.addMouseListener(levelController);

		// create button Hard, hidden background button hard and event button Hard

		iconMap3 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\hard.png");
		btMap3 = new JButton(iconMap3);
		btMap3.setBorderPainted(false);
		btMap3.setContentAreaFilled(false);
		btMap3.setFocusable(false);
		btMap3.setPreferredSize(new Dimension(105, 30));
//		btMap3.addMouseListener(levelController);

		// create button Exit...

		iconBack = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\back.png");
		btBack = new JButton(iconBack);
		btBack.setBorderPainted(false);
		btBack.setContentAreaFilled(false);
		btBack.setFocusable(false);
		btBack.setPreferredSize(new Dimension(105, 30));
//		btBack.addMouseListener(levelController);

		// no bug for hidden background button

		this.setOpaque(false);

		// add button to the panel

		this.add(btMap1);
		this.add(btMap2);
		this.add(btMap3);
		this.add(btBack);
	}

	public JButton getBtBack() {
		return btBack;
	}

	public JButton getBtMap1() {
		return btMap1;
	}

	public JButton getBtMap2() {
		return btMap2;
	}

	public JButton getBtMap3() {
		return btMap3;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	
}
