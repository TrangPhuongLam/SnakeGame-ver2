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
import panel.PanelNavigationGameFrame;

public class GameFrameView extends JFrame implements Runnable{
	Thread thread;
	PanelNavigationGameFrame panelNavigationGameFrame;
	GameFrameController gameFrameController;
	public ScreenGame screenGame = new ScreenGame();
	static final int WIDTH = 413, HEIGHT = 472;

	public GameFrameView(int width, int height) {
		// TODO Auto-generated constructor stub
		gameFrameController = new GameFrameController(this);
		// labelScore = new JLabel(score.getScore()+"");
		setTitle("Game Snake");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setResizable(false);
		this.setLayout(new BorderLayout());
		this.addKeyListener(new handler());
		
		//----------------- Panel Navigation Game Frame -----------------
		panelNavigationGameFrame = new PanelNavigationGameFrame(width, height);
		
		
		thread = new Thread(this);
		thread.start();
		
		
		add(panelNavigationGameFrame, BorderLayout.NORTH);
		add(screenGame, BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public GameFrameView() {
		// TODO Auto-generated constructor stub
		this(WIDTH, HEIGHT);
	}
	
	public GameFrameView(ScreenGame screenGame) {
		
	}
	
	

	public ScreenGame getScreenGame() {
		return screenGame;
	}

	public void setScreenGame(ScreenGame screenGame) {
		this.screenGame = screenGame;
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
		// TODO Auto-generated method stub
		
	}

}
