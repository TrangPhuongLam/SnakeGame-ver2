package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MenuController;
import panel.PanelBgMenu;
import panel.PanelContentMenu;
import volumeState.OnVolume;


public class MenuView extends JFrame{
	public MenuController menuController;
	private PanelBgMenu panelBgMenu;
	private PanelContentMenu panelContentMenu;
	static final int WIDTH = 530, HEIGHT = 646;
	private Clip clip = OnVolume.getInstance().clipSound("D:\\git\\SnakeGame_ver2\\src\\data\\sound.wav");

	public MenuView(int width, int height) {
		clip.start();
		
		setTitle("Menu Game");
		menuController = new MenuController(this);
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		//------------- Panel Background Menu------------
		panelBgMenu = new PanelBgMenu();
		setContentPane(panelBgMenu);

		// ------------- Panel Content Menu -----------------
		panelContentMenu = new PanelContentMenu();
		panelContentMenu.getBtPlay().addMouseListener(new handler());
		panelContentMenu.getBtLevel().addMouseListener(new handler());
		panelContentMenu.getBtPlayer().addMouseListener(new handler());
		panelContentMenu.getBtHelp().addMouseListener(new handler());
		panelContentMenu.getBtScore().addMouseListener(new handler());
		panelContentMenu.getBtExit().addMouseListener(new handler());

		add(panelContentMenu, BorderLayout.CENTER);
		setVisible(true);
		
	}

	public MenuView() {
		this(WIDTH, HEIGHT);
	}
	
	public Clip getClip() {
		return clip;
	}

	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			OnVolume.getInstance().sound("D:\\git\\SnakeGame_ver2\\src\\data\\pop.wav");
			clip.stop();
			if(e.getSource() == panelContentMenu.getBtPlay()) {
				menuController.newGame();
				
			}
			
			if(e.getSource() == panelContentMenu.getBtLevel()) {
				menuController.levelGame();
			}
			
			if(e.getSource() == panelContentMenu.getBtPlayer()) {
				menuController.playerGame();
			}
			
			if(e.getSource() == panelContentMenu.getBtHelp()) {
				menuController.helpGame();
			}
			
			if(e.getSource() == panelContentMenu.getBtScore()) {
				menuController.scoreGame();
			}
			
			if(e.getSource() == panelContentMenu.getBtExit()) {
				menuController.exitGame();
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
			OnVolume.getInstance().sound("D:\\git\\SnakeGame_ver2\\src\\data\\ding.wav");
			
			if(e.getSource() == panelContentMenu.getBtPlay()) {
				ImageIcon iconPlay = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Play1.png");
				panelContentMenu.getBtPlay().setIcon(iconPlay);
				panelContentMenu.getBtPlay().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentMenu.getBtHelp()) {
				ImageIcon iconHelp = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Help1.png");
				panelContentMenu.getBtHelp().setIcon(iconHelp);
				panelContentMenu.getBtHelp().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentMenu.getBtLevel()) {
				ImageIcon iconLevel = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Level1.png");
				panelContentMenu.getBtLevel().setIcon(iconLevel);
				panelContentMenu.getBtLevel().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentMenu.getBtPlayer()) {
				ImageIcon iconPlayer = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Options1.png");
				panelContentMenu.getBtPlayer().setIcon(iconPlayer);
				panelContentMenu.getBtPlayer().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentMenu.getBtScore()) {
				ImageIcon iconScore = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Score1.png");
				panelContentMenu.getBtScore().setIcon(iconScore);
				panelContentMenu.getBtScore().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentMenu.getBtExit()) {
				ImageIcon iconExit = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Exit1.png");
				panelContentMenu.getBtExit().setIcon(iconExit);
				panelContentMenu.getBtExit().setPreferredSize(new Dimension(120, 45));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentMenu.getBtPlay()) {
				ImageIcon iconPlay = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Play.png");
				panelContentMenu.getBtPlay().setIcon(iconPlay);
				panelContentMenu.getBtPlay().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentMenu.getBtHelp()) {
				ImageIcon iconHelp = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Help.png");
				panelContentMenu.getBtHelp().setIcon(iconHelp);
				panelContentMenu.getBtHelp().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentMenu.getBtLevel()) {
				ImageIcon iconLevel = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Level.png");
				panelContentMenu.getBtLevel().setIcon(iconLevel);
				panelContentMenu.getBtLevel().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentMenu.getBtPlayer()) {
				ImageIcon iconPlayer = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Options.png");
				panelContentMenu.getBtPlayer().setIcon(iconPlayer);
				panelContentMenu.getBtPlayer().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentMenu.getBtScore()) {
				ImageIcon iconScore = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Score.png");
				panelContentMenu.getBtScore().setIcon(iconScore);
				panelContentMenu.getBtScore().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentMenu.getBtExit()) {
				ImageIcon iconExit = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Exit.png");
				panelContentMenu.getBtExit().setIcon(iconExit);
				panelContentMenu.getBtExit().setPreferredSize(new Dimension(105, 30));
			}
		}
		
	}
}
