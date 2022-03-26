package abstractSnakeGame;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.ScreenGameController;

public  abstract class ScreenGame extends JPanel implements Runnable{
	protected Thread thread;
	protected ScreenGameController screenGameController;
	public static int width = 400, height = 400;
	
	public ScreenGame() {
			this(width, height);
	} 
 
	public ScreenGame(int width, int height) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		
		
		screenGameController = new ScreenGameController(this);
		
		thread = new Thread(this);
		thread.start();
	}
	
	
	
//	public int sizeFrame() {
//		return screenGameController.sizeFrame();
//	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		paintScreenGame(g);
		screenGameController.paint(g);
	}
	

	public static void setWidth(int width) {
		ScreenGame.width = width;
	}

	public static void setHeight(int height) {
		ScreenGame.height = height;
	}

	public abstract void paintScreenGame(Graphics g) ;
	//----------- implement paintScreenGame --------------
		//g.drawImage(iconBgScreenGame.getImage(), 0, 0, getWidth(), getHeight(), null);
	
	
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
		while(true) {
		screenGameController.startGame();
		repaint();
			
			try {
				thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	}

	public class HandlerKeyPress implements KeyListener{
		public HandlerKeyPress(KeyEvent e) {
			// TODO Auto-generated constructor stub
			keyPressed(e);
			keyTyped(e);
			keyReleased(e);
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			screenGameController.handlerKeyPress(e);
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			screenGameController.handlerKeyPress(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
