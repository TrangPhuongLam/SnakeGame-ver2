package abstractSnakeGame;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.ScreenGameController;
import gameState.GameOver;
import gameState.PauseGame;
import gameState.StartGame;
import interfaceSnakeGame.GameState;
import model.Snake;

public  abstract class ScreenGame extends JPanel implements Runnable{
	protected Thread thread;
	protected ScreenGameController screenGameController;
	protected ImageIcon iconBgResize;
	protected Image imageBgScreenGame, imageResize;
	public static int width = 400, height = 400;
	protected static String playerDecoratorName = "playerDecorator1";
	
	protected GameState state = PauseGame.getInstance();
	
	public ScreenGame(String playerDecoratorName) {
		System.out.println("in screengame(string) input:" + playerDecoratorName);
		this.playerDecoratorName = playerDecoratorName;
		screenGameController = new ScreenGameController(this);
		
		thread = new Thread(this);
		thread.start();
		
		System.out.println("in screengame(string)" + this.playerDecoratorName);
		
	}
	
	public ScreenGame() {
		// TODO Auto-generated constructor stub
		this(playerDecoratorName);
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		state.paintState(g);
		
	}
	
	@Override
	protected abstract void paintComponent(Graphics g);
	
	public void resizeImage(ImageIcon icon) {
		imageBgScreenGame = icon.getImage();
		imageResize = imageBgScreenGame.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		
		iconBgResize = new ImageIcon(imageResize);
	}

	public static void setWidth(int width) {
		ScreenGame.width = width;
	}

	public static void setHeight(int height) {
		ScreenGame.height = height;
	}
	
	
	public void paintScreenGame(Graphics g){
//		System.out.println("Im in paint screen game");
		g.drawImage(iconBgResize.getImage(), 0, 0, width, height, null);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

//		boolean running = true;
//		while(running) {
//		screenGameController.startGame();
//		running = screenGameController.getSnake().getRunningPlayer();
//		repaint();
//			try {
//				thread.sleep(350 - screenGameController.speedSnake());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
//	}
//		boolean running = true;
//		while(running) {
			
//			if (state.doAction(this)) {
//				
//		
//			screenGameController.startGame();
//			
//			if (!screenGameController.getSnake().getRunningPlayer()) {
//				state = GameOver.getInstance();
//				running = state.doAction(this);
//			}
//			repaint();
//			try {
//				thread.sleep(350 - screenGameController.speedSnake());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			}	
//		}
		
//		boolean running = true;
//		while(running) {
//			if (!screenGameController.getSnake().getRunningPlayer()) {
//				running = screenGameController.getSnake().getRunningPlayer();
//			}
//			
//			repaint();
//		}
		
		
	}
	
	public static String getPlayerDecoratorName() {
		return playerDecoratorName;
	}

	public static void setPlayerDecoratorName(String playerDecoratorName) {
		ScreenGame.playerDecoratorName = playerDecoratorName;
	}

	public  ScreenGameController getScreenGameController() {
		return this.screenGameController;
	}
	
	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public boolean doAction(ScreenGame screenGame) {
		
		return state.doAction(screenGame);
	}

	public class ScreenGameKeyPress implements KeyListener{
		public ScreenGameKeyPress(KeyEvent e) {
			// TODO Auto-generated constructor stub
			keyPressed(e);
			keyTyped(e);
			keyReleased(e);
		}
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			screenGameController.snakeKeyPress(e);
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				
				if (state.equals(StartGame.getInstance())) {
					state = PauseGame.getInstance();
				}else 
					 if (state.equals(PauseGame.getInstance())) {
					state = StartGame.getInstance();
				}
			}
			screenGameController.snakeKeyPress(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
