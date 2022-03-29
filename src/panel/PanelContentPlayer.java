package panel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelContentPlayer extends JPanel{
	private JButton btPlayer1, btPlayer2, btPlayer3, btBack;
	private ImageIcon iconPlayer1, iconPlayer2, iconPlayer3, iconBack;
	private final int 	WIDTH = 300, HEIGHT = 500;
	
	public PanelContentPlayer() {
		// TODO Auto-generated constructor stub
		this.setLayout(new GridLayout(6, 1));
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		iconPlayer1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\crown.png");
		btPlayer1 = new JButton(iconPlayer1);
		btPlayer1.setBorderPainted(false);
		btPlayer1.setContentAreaFilled(false);
		btPlayer1.setFocusable(false);
		btPlayer1.setPreferredSize(new Dimension(105, 30));
//		btPlayer1.addMouseListener(levelController);

		// create button Normal, hidden background button Normal and event button Normal

		iconPlayer2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1.png");
		btPlayer2 = new JButton(iconPlayer2);
		btPlayer2.setBorderPainted(false);
		btPlayer2.setContentAreaFilled(false);
		btPlayer2.setFocusable(false);
		btPlayer2.setPreferredSize(new Dimension(105, 105));
//		btPlayer2.addMouseListener(levelController);

		// create button Hard, hidden background button hard and event button Hard

		iconPlayer3 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman.png");
		btPlayer3 = new JButton(iconPlayer3);
		btPlayer3.setBorderPainted(false);
		btPlayer3.setContentAreaFilled(false);
		btPlayer3.setFocusable(false);
		btPlayer3.setPreferredSize(new Dimension(105, 105));
//		btPlayer3.addMouseListener(levelController);

		// create button Exit...

		iconBack = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\back.png");
		btBack = new JButton(iconBack);
		btBack.setBorderPainted(false);
		btBack.setContentAreaFilled(false);
		btBack.setFocusable(false);
		btBack.setPreferredSize(new Dimension(105, 105));
//		btBack.addMouseListener(levelController);

		// no bug for hidden background button

		this.setOpaque(false);

		// add button to the panel

		this.add(btPlayer1);
		this.add(btPlayer2);
		this.add(btPlayer3);
		this.add(btBack);
	}

	public JButton getBtPlayer1() {
		return btPlayer1;
	}

	public JButton getBtPlayer2() {
		return btPlayer2;
	}

	public JButton getBtPlayer3() {
		return btPlayer3;
	}

	public JButton getBtBack() {
		return btBack;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	
	
}
