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
import interfaceSnakeGame.VolumeState;
import panel.PanelMap_1;
import panel.PanelMap_2;
import panel.PanelNavigationGameFrame;
import volumeState.OffVolume;
import volumeState.OnVolume;

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
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
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
		}
		
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
		boolean running = true;
		int count = 1;
		
		OnVolume onVolume = OnVolume.getInstance();
		 
		Clip clip = onVolume.clipSound("D:\\git\\SnakeGame_ver2\\src\\data\\HallofFame.wav");
		
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
