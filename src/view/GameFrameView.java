package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import abstractSnakeGame.ScreenGame;
import controller.GameFrameController;
import gameState.GameOver;
import gameState.PauseGame;
import gameState.StartGame;
import interfaceSnakeGame.VolumeState;
import panel.PanelMap_1;
import panel.PanelMap_2;
import panel.PanelMap_3;
import panel.PanelNavigationGameFrame;
import panel.PanelReplayGame;
import volumeState.OffVolume;
import volumeState.OnVolume;

public class GameFrameView extends JFrame implements Runnable{
	private Thread thread;
	private PanelNavigationGameFrame panelNavigationGameFrame;
	private GameFrameController gameFrameController;
	public static ScreenGame screenGame ;
	private static  int width = 400, height = 400;//w 413, h 472
	

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
		setSize(new Dimension(width, height));
		
		setLocationRelativeTo(null);
		setResizable(false);
		this.setLayout(new BorderLayout());
		this.addKeyListener(new handler());
		
		//----------------- Panel Navigation Game Frame -----------------
		panelNavigationGameFrame = new PanelNavigationGameFrame(this.width, this.height, this.screenGame);
		setSize(new Dimension(this.width, this.height + panelNavigationGameFrame.heightNavigation));
		panelNavigationGameFrame.getBtVolume().addMouseListener(new HandlerMouse());
		
		
		thread = new Thread(this);
		thread.start();
		
		
		
		add(panelNavigationGameFrame, BorderLayout.NORTH);
		add(screenGame, BorderLayout.CENTER);
		setVisible(true);
		
	System.out.println("im end game frame");
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

	public class HandlerMouse implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//Panel navigation
			if (e.getSource() == panelNavigationGameFrame.getBtVolume()) {
				if (panelNavigationGameFrame.getVolumeState().equals(OnVolume.getInstance())) {
					panelNavigationGameFrame.setVolumeState(OffVolume.getInstance());
					panelNavigationGameFrame.getBtVolume().setIcon(panelNavigationGameFrame.resizeImage(
							"D:\\git\\SnakeGame_ver2\\src\\data\\volume_off.png", 30, 30));
					
				}else 
					if (panelNavigationGameFrame.getVolumeState().equals(OffVolume.getInstance())) {
					panelNavigationGameFrame.setVolumeState(OnVolume.getInstance());
					panelNavigationGameFrame.getBtVolume().setIcon(panelNavigationGameFrame.resizeImage(
							"D:\\git\\SnakeGame_ver2\\src\\data\\volume_on.png", 30, 30));
				}
			}
			
			//Panel replay game
			if(e.getSource() == screenGame.getPanelReplayGame().getBtReplay()) {
				
				if (screenGame.getMapName().equalsIgnoreCase("map3")) {
					GameFrameView gameFrameView = new GameFrameView(new PanelMap_3(screenGame.getPlayerDecoratorName()));
					dispose(); 
				}else
					if (screenGame.getMapName().equalsIgnoreCase("map2")) {
					GameFrameView gameFrameView = new GameFrameView(new PanelMap_2(screenGame.getPlayerDecoratorName()));
					dispose();
				}else
					if (screenGame.getMapName().equalsIgnoreCase("map1")) {
					GameFrameView gameFrameView = new GameFrameView(new PanelMap_1(screenGame.getPlayerDecoratorName()));
					dispose();
				}
				dispose();
			}
			
			if(e.getSource() == screenGame.getPanelReplayGame().getBtHome()) {
				MenuView menuView = new MenuView();
				dispose();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			//Panel navigation
			if (e.getSource() == panelNavigationGameFrame.getBtVolume()) {
				if (panelNavigationGameFrame.getVolumeState().equals(OnVolume.getInstance())) {
					panelNavigationGameFrame.getBtVolume().setIcon(
							panelNavigationGameFrame.resizeImage(
									"D:\\git\\SnakeGame_ver2\\src\\data\\volume_on.png", 30, 30));
					panelNavigationGameFrame.getBtVolume().setPreferredSize(new Dimension(30, 30));
				}else 
					if (panelNavigationGameFrame.getVolumeState().equals(OffVolume.getInstance())) {
						panelNavigationGameFrame.getBtVolume().setIcon(
								panelNavigationGameFrame.resizeImage(
										"D:\\git\\SnakeGame_ver2\\src\\data\\volume_off.png", 30, 30));
						panelNavigationGameFrame.getBtVolume().setPreferredSize(new Dimension(30, 30));
						
				}
				
				
			}
			
			//Panel replay game
			
			if(e.getSource() == screenGame.getPanelReplayGame().getBtReplay()) {
				PanelReplayGame panelReplayGame = screenGame.getPanelReplayGame();
				panelReplayGame.getBtReplay().setIcon(panelReplayGame.resizeImage(
						"D:\\git\\SnakeGame_ver2\\src\\data\\replay.png", 75, 75));
				panelReplayGame.getBtReplay().setPreferredSize(new Dimension(75, 75));
			}
			
			if(e.getSource() == screenGame.getPanelReplayGame().getBtHome()) {
				PanelReplayGame panelReplayGame = screenGame.getPanelReplayGame();
				panelReplayGame.getBtHome().setIcon(panelReplayGame.resizeImage(
						"D:\\git\\SnakeGame_ver2\\src\\data\\home.png", 75, 75));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			//Panel navigation
			if (e.getSource() == panelNavigationGameFrame.getBtVolume()) {
				if (panelNavigationGameFrame.getVolumeState().equals(OnVolume.getInstance())) {
					panelNavigationGameFrame.getBtVolume().setIcon(
							panelNavigationGameFrame.resizeImage(
									"D:\\git\\SnakeGame_ver2\\src\\data\\volume_on.png", 20, 20));
					panelNavigationGameFrame.getBtVolume().setPreferredSize(new Dimension(20, 20));
				}else 
					if (panelNavigationGameFrame.getVolumeState().equals(OffVolume.getInstance())) {
						panelNavigationGameFrame.getBtVolume().setIcon(
								panelNavigationGameFrame.resizeImage(
										"D:\\git\\SnakeGame_ver2\\src\\data\\volume_off.png", 20, 20));
						panelNavigationGameFrame.getBtVolume().setPreferredSize(new Dimension(20, 20));
						
				}
			}
			
			//Panel replay game
			if(e.getSource() == screenGame.getPanelReplayGame().getBtReplay()) {
				PanelReplayGame panelReplayGame = screenGame.getPanelReplayGame();
				panelReplayGame.getBtReplay().setIcon(panelReplayGame.resizeImage(
						"D:\\git\\SnakeGame_ver2\\src\\data\\replay.png", 60, 60));
				panelReplayGame.getBtReplay().setPreferredSize(new Dimension(60, 60));
			}
			
			if(e.getSource() == screenGame.getPanelReplayGame().getBtHome()) {
				PanelReplayGame panelReplayGame = screenGame.getPanelReplayGame();
				panelReplayGame.getBtHome().setIcon(panelReplayGame.resizeImage(
						"D:\\git\\SnakeGame_ver2\\src\\data\\home.png", 60, 60));
			}
			
		}
		
	}

	public class handler implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			gameFrameController.getKeyPressSnake(e);
			
//			//Press space
//			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
//				
//				if (screenGame.getState().equals(StartGame.getInstance())) {
//					screenGame.setState(PauseGame.getInstance());
//				}else 
//					 if (screenGame.getState().equals(PauseGame.getInstance())) {
//					screenGame.setState(StartGame.getInstance());
//				}
//			}
			
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
		boolean running = true;
		int count = 1;
		
		OnVolume onVolume = OnVolume.getInstance();
		 
		Clip clip = onVolume.clipSound("D:\\git\\SnakeGame_ver2\\src\\data\\Silent-Partner-Dog-Park.wav");
		
		while(running) {
			//On Volume
			if (panelNavigationGameFrame.getVolumeState().doAction(panelNavigationGameFrame)
					&& count == 1) {
				clip.start();
				count -= 1;
			}
		
			//Off volume
			if (!panelNavigationGameFrame.getVolumeState().doAction(panelNavigationGameFrame)
					&& count == 0) {
				clip.stop();
				count += 1;
			}
			
			if (screenGame.getState().doAction(screenGame)) {
				
				//Update score (Panel navi)
				try {
					panelNavigationGameFrame.getNavigationController().handlerScore();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				//Start Snake
				screenGame.getScreenGameController().startSnake();
				
				
				//Game Over
				if (!screenGame.getScreenGameController().getSnake().getRunningPlayer()) {
					screenGame.setState(GameOver.getInstance());
					running = screenGame.getState().doAction(screenGame);
					clip.stop();
					
					//Appear panelReplayGame
					screenGame.setPanelReplayGame(screenGame.getScreenGameController().replayGame());
					screenGame.getPanelReplayGame().getBtReplay().addMouseListener(new HandlerMouse());
					screenGame.getPanelReplayGame().getBtHome().addMouseListener(new HandlerMouse());
				}
				
				try {
					thread.sleep(350 - screenGame.getScreenGameController().speedSnake());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
			repaint();
			}	
			
			
		}
		
	}

}
