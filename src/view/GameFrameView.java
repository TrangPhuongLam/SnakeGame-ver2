package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import abstractSnakeGame.ScreenGame;
import controller.GameFrameController;
import panel.PanelMap_1;
import panel.PanelMap_2;
import panel.PanelNavigationGameFrame;

public class GameFrameView extends JFrame implements Runnable{
	Thread thread;
	PanelNavigationGameFrame panelNavigationGameFrame;
	GameFrameController gameFrameController;
	public static ScreenGame screenGame ;
	static  int width = 400, height = 400;//w 413, h 472

	public GameFrameView(ScreenGame map) {
		// TODO Auto-generated constructor stub
		this.width = screenGame.width + 15;
		this.height = screenGame.height + 90;
		this.screenGame = map;
		System.out.println("im in game frame");
		gameFrameController = new GameFrameController(this);
		// labelScore = new JLabel(score.getScore()+"");
		setTitle("Game Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocationRelativeTo(null);
		setResizable(false);
		this.setLayout(new BorderLayout());
		this.addKeyListener(new handler());
		
		//----------------- Panel Navigation Game Frame -----------------
		panelNavigationGameFrame = new PanelNavigationGameFrame(this.width, this.height, this.screenGame);
		setSize(new Dimension(this.width, this.height + panelNavigationGameFrame.heightNavigation));
		
		thread = new Thread(this);
		thread.start();
		
		
		
		add(panelNavigationGameFrame, BorderLayout.NORTH);
		add(screenGame, BorderLayout.CENTER);
		setVisible(true);
		
	
	}
	
	
	public ScreenGame getScreenGame() {
		return screenGame;
	}

	public void setScreenGame(ScreenGame screenGame) {
		this.screenGame = screenGame;
	}



	public PanelNavigationGameFrame getPanelNavigationGameFrame() {
		return panelNavigationGameFrame;
	}


	public void setPanelNavigationGameFrame(PanelNavigationGameFrame panelNavigationGameFrame) {
		this.panelNavigationGameFrame = panelNavigationGameFrame;
	}



	public GameFrameController getGameFrameController() {
		return gameFrameController;
	}


	public void setGameFrameController(GameFrameController gameFrameController) {
		this.gameFrameController = gameFrameController;
	}



	public class handler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
//		gameFrameController.handlerKeyPress(e);
			gameFrameController.getKeyPressSnake(e);
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			gameFrameController.getKeyPressSnake(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

	}
	
	@Override
	public void run() {
//		boolean running = true;
//		while(running) {
//			running = screenGame.getScreenGameController().getSnake().getRunningPlayer();
//			System.out.println("in run game frame");
//		}
	}

}
