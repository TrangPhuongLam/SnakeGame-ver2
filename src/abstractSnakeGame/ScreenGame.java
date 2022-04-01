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
import panel.PanelReplayGame;

public  abstract class ScreenGame extends JPanel {
	protected Thread thread;
	protected ScreenGameController screenGameController;
	protected ImageIcon iconBgResize;
	protected Image imageBgScreenGame, imageResize;
	public static int width = 400, height = 400;
	protected static String playerDecoratorName = "playerDecorator1";
	protected String mapName = "map1";
	protected PanelReplayGame panelReplayGame = new PanelReplayGame();
	protected GameState state = PauseGame.getInstance();
	
	
	public ScreenGame(String playerDecoratorName) {
		System.out.println("in screengame(string) input:" + playerDecoratorName);
		this.playerDecoratorName = playerDecoratorName;
		screenGameController = new ScreenGameController(this);
		
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
	
	public String getMapName() {
		return mapName;
	}


	public void paintScreenGame(Graphics g){
//		System.out.println("Im in paint screen game");
		g.drawImage(iconBgResize.getImage(), 0, 0, width, height, null);
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
	
	public PanelReplayGame getPanelReplayGame() {
		return panelReplayGame;
	}

	public void setPanelReplayGame(PanelReplayGame panelReplayGame) {
		this.panelReplayGame = panelReplayGame;
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
