package panel;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


import abstractSnakeGame.ScreenGame;
import controller.GameFrameController;
import controller.NavigationController;
import controller.ScreenGameController;
import interfaceSnakeGame.VolumeState;
import model.Snake;
import volumeState.OnVolume;

public class PanelNavigationGameFrame extends JPanel implements Runnable{
	private JLabel labelAppleScore, labelMaxAppleScore, labelEnergyScore, 
	labelMushroomScore, labelSwampScore;
	private JButton btVolume;
	public int heightNavigation = 0;
	private int appleScore = 0, energyScore = 0, mushroomScore = 0, swampScore = 0, highScore = 0;
	private NavigationController navigationController;
	private Thread thread;
	private ScreenGame screenGame;
	private static int width = 0, height = 0;
	
	private VolumeState volumeState = OnVolume.getInstance();
	
	public PanelNavigationGameFrame(int width, int height, ScreenGame screenGame) {
		// TODO Auto-generated constructor stub
		this.width = width;
		this.height = height;
		this.screenGame = screenGame;
		
		labelAppleScore = new JLabel("" + this.appleScore);
		labelEnergyScore = new JLabel("" + this.energyScore);
		labelMushroomScore = new JLabel("" + this.mushroomScore);
		labelSwampScore = new JLabel("" + this.swampScore);
		labelMaxAppleScore = new JLabel("" + this.highScore);

		btVolume = new JButton();
		btVolume.setPreferredSize(new Dimension(20, 20));
		
		
		navigationController = new NavigationController(this, this.screenGame);
		
		
		thread = new Thread(this);
		thread.start();
		System.out.println("im in navi frame");
	}
	
	
	public void paintFrame(Graphics g) {
		heightNavigation = height / 10;
		SpringLayout layoutN = new SpringLayout();
		this.setLayout(layoutN);
		this.setPreferredSize(new Dimension(width, heightNavigation));
		this.setBackground(new Color(0, 139, 69));

		labelAppleScore.setText("" + appleScore);
		labelAppleScore.setFont(labelAppleScore.getFont().deriveFont(15.0f));
		labelAppleScore.setForeground(Color.WHITE);
		labelAppleScore.setIcon(resizeImage("D:\\git\\SnakeGame_ver2\\src\\data\\tao.png", 20, 20));
		
		labelEnergyScore.setText("" + energyScore);
		labelEnergyScore.setFont(labelEnergyScore.getFont().deriveFont(15.0f));
		labelEnergyScore.setForeground(Color.WHITE);
		labelEnergyScore.setIcon(resizeImage("D:\\git\\SnakeGame_ver2\\src\\data\\energy.png", 20, 20));
		
		labelMushroomScore.setText("" + mushroomScore);
		labelMushroomScore.setFont(labelMushroomScore.getFont().deriveFont(15.0f));
		labelMushroomScore.setForeground(Color.WHITE);
		labelMushroomScore.setIcon(resizeImage("D:\\git\\SnakeGame_ver2\\src\\data\\mushroom.png", 20, 20));
		
		labelSwampScore.setText("" + swampScore);
		labelSwampScore.setFont(labelSwampScore.getFont().deriveFont(15.0f));
		labelSwampScore.setForeground(Color.WHITE);
		labelSwampScore.setIcon(resizeImage("D:\\git\\SnakeGame_ver2\\src\\data\\swamp.png", 20, 20));
		
		labelMaxAppleScore.setText("" + highScore);
		labelMaxAppleScore.setFont(labelMaxAppleScore.getFont().deriveFont(15.0f));
		labelMaxAppleScore.setForeground(Color.WHITE);
		labelMaxAppleScore.setIcon( resizeImage("D:\\git\\SnakeGame_ver2\\src\\data\\cup.png", 20, 20));
		
	
//		labelVolume = new JLabel("" + score);
//		labelVolume.setFont(labelVolume.getFont().deriveFont(15.0f));
//		labelVolume.setForeground(Color.WHITE);
//		labelVolume.setIcon(new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\tao.png"));
		

		
		
//		btVolume.setBackground(new Color(0, 139, 69));
		btVolume.setBorderPainted(false);
		btVolume.setContentAreaFilled(false);
		btVolume.setFocusable(false);
		btVolume.setIcon(resizeImage("D:\\git\\SnakeGame_ver2\\src\\data\\volume.png", 20, 20));

		this.add(labelAppleScore);
		this.add(labelEnergyScore);
		this.add(labelMushroomScore);
		this.add(labelSwampScore);
		this.add(labelMaxAppleScore);
		this.add(btVolume);
		

		
		layoutN.putConstraint(SpringLayout.WEST, labelAppleScore, 10, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelAppleScore, 10, SpringLayout.NORTH, this);
		
		layoutN.putConstraint(SpringLayout.WEST, labelEnergyScore, 60, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelEnergyScore, 10, SpringLayout.NORTH, this);
		
		layoutN.putConstraint(SpringLayout.WEST, labelMushroomScore, 110, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelMushroomScore, 10, SpringLayout.NORTH, this);
		
		layoutN.putConstraint(SpringLayout.WEST, labelSwampScore, 170, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelSwampScore, 10, SpringLayout.NORTH, this);
		
		layoutN.putConstraint(SpringLayout.WEST, labelMaxAppleScore, 300, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelMaxAppleScore, 10, SpringLayout.NORTH, this);
		
		layoutN.putConstraint(SpringLayout.NORTH, btVolume, 10, SpringLayout.NORTH, this);
		layoutN.putConstraint(SpringLayout.WEST, btVolume, 360, SpringLayout.WEST, this);

	}
	
	public ImageIcon resizeImage(String pathIcon, int width, int height) {
		Image image = new ImageIcon(pathIcon).getImage();
		Image imageResize = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(imageResize);	
		
		return icon;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		paintFrame(g);
	}
	

	public int getAppleScore() {
		return appleScore;
	}

	public void setAppleScore(int appleScore) {
		this.appleScore = appleScore;
	}

	public int getEnergyScore() {
		return energyScore;
	}

	public void setEnergyScore(int energyScore) {
		this.energyScore = energyScore;
	}

	public int getMushroomScore() {
		return mushroomScore;
	}

	public void setMushroomScore(int mushroomScore) {
		this.mushroomScore = mushroomScore;
	}

	public int getSwampScore() {
		return swampScore;
	}

	public void setSwampScore(int swampScore) {
		this.swampScore = swampScore;
	}

	public int getHighScore() {
		return highScore;
	}

	public void setHighScore(int highScore) {
		this.highScore = highScore;
	}
	
	public JButton getBtVolume() {
		return btVolume;
	}


	public void setBtVolume(JButton btVolume) {
		this.btVolume = btVolume;
	}


	public ScreenGame getScreenGame() {
		return screenGame;
	}


	public void setScreenGame(ScreenGame screenGame) {
		this.screenGame = screenGame;
	}

	public VolumeState getVolumeState() {
		return volumeState;
	}


	public void setVolumeState(VolumeState volumeState) {
		this.volumeState = volumeState;
	}

	public boolean doAction(PanelNavigationGameFrame panelNavigationGameFrame) {
		return volumeState.doAction(this);
	}
	
	@Override
	public void run() {
		
		boolean running = true;
		while (running) {
			
			try {
				running = navigationController.handlerScore();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			repaint();
		}
	}

	
}
