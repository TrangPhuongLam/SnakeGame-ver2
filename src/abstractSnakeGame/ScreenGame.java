package abstractSnakeGame;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ScreenGameController;

public abstract class ScreenGame extends JPanel implements Runnable{
	Thread thread;
	 ScreenGameController screenGameController;
	 private ImageIcon iconBgScreenGame;
	
	public ScreenGame() {
		// TODO Auto-generated constructor stub
		thread = new Thread(this);
		screenGameController = new ScreenGameController(this);
		iconBgScreenGame = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\bg.png");
		thread.start();
	}
	
//	public int sizeFrame() {
//		return screenGameController.sizeFrame();
//	}

	public void paint(Graphics g) {
		paintScreenGame(g);
		screenGameController.paint(g);
	}
	
	public void paintScreenGame(Graphics g) {
		g.drawImage(iconBgScreenGame.getImage(), 0, 0, getWidth(), getHeight(), null);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

//		while (true) {
//
//			screenGameController.state();
//			repaint();
//
//			try {
//				thread.sleep(20);
//			} catch (InterruptedException e) {
//			}
//		}
	}
}
