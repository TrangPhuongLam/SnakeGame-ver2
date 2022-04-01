package view;

import java.awt.Dimension;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import controller.LevelController;
import controller.PlayerController;
import controller.ScreenGameController;
import panel.PanelBgLevel;
import panel.PanelBgPlayer;
import panel.PanelContentLevel;
import panel.PanelContentPlayer;
import volumeState.OnVolume;

public class PlayerView extends JFrame{
	static MenuView menuView;
	private PanelBgPlayer panelBgPlayer;
	private static PanelContentPlayer panelContentPlayer ;
	private ScreenGameController screenGameController;
	private PlayerController playerController;
	static  int width = 500, height = 600;
	private Clip clip = OnVolume.getInstance().clipSound("D:\\git\\SnakeGame_ver2\\src\\data\\sound.wav");
	
	public PlayerView(int width, int height) {
		// TODO Auto-generated constructor stub
		clip.start();
		playerController = new PlayerController(this);
		setTitle("Player");
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set border layout
		SpringLayout layout = new SpringLayout();

		//------------- Panel Background Player --------------
		panelBgPlayer = new PanelBgPlayer();
		
		setContentPane(panelBgPlayer);

		// ----------------- Panel Content Player -----------------
		panelContentPlayer = new PanelContentPlayer();
		panelContentPlayer.getBtPlayer1().addMouseListener(new handler());
		panelContentPlayer.getBtPlayer2().addMouseListener(new handler());
		panelContentPlayer.getBtPlayer3().addMouseListener(new handler());
		panelContentPlayer.getBtBack().addMouseListener(new handler());
		
		
		layout.putConstraint(SpringLayout.NORTH, panelContentPlayer, panelContentPlayer.getHEIGHT() / 4  , SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panelContentPlayer, panelContentPlayer.getWIDTH() / 4, SpringLayout.WEST, this);
		setLayout(layout);
		
		
		add(panelContentPlayer);
		setVisible(true);
		setResizable(false);
	}
	
	public PlayerView() {
		this(width, height);
	}

	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			clip.stop();
			if(e.getSource() == panelContentPlayer.getBtPlayer1()) {
				playerController.chosePlayerDecorator_1();
				
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer2()) {
				playerController.chosePlayerDecorator_2();
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer3()) {
				playerController.chosePlayerDecorator_3();
			}
			
			if(e.getSource() == panelContentPlayer.getBtBack()) {
				playerController.backMenuView();
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
			if(e.getSource() == panelContentPlayer.getBtPlayer1()) {
				ImageIcon iconPlayer1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\crown1.png");
				panelContentPlayer.getBtPlayer1().setIcon(iconPlayer1);
				panelContentPlayer.getBtPlayer1().setPreferredSize(new Dimension(120, 120));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer2()) {
				ImageIcon iconPlayer2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1_1.png");
				panelContentPlayer.getBtPlayer2().setIcon(iconPlayer2);
				panelContentPlayer.getBtPlayer2().setPreferredSize(new Dimension(120, 120));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer3()) {
				ImageIcon iconPlayer3 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman1.png");
				panelContentPlayer.getBtPlayer3().setIcon(iconPlayer3);
				panelContentPlayer.getBtPlayer3().setPreferredSize(new Dimension(120, 120));
			}
			
			if(e.getSource() == panelContentPlayer.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\back1.png");
				panelContentPlayer.getBtBack().setIcon(iconBack);
				panelContentPlayer.getBtBack().setPreferredSize(new Dimension(120, 120));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentPlayer.getBtPlayer1()) {
				ImageIcon iconPlayer1 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\crown.png");
				panelContentPlayer.getBtPlayer1().setIcon(iconPlayer1);
				panelContentPlayer.getBtPlayer1().setPreferredSize(new Dimension(105, 105));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer2()) {
				ImageIcon iconPlayer2 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\headSnake_1.png");
				panelContentPlayer.getBtPlayer2().setIcon(iconPlayer2);
				panelContentPlayer.getBtPlayer2().setPreferredSize(new Dimension(105, 105));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer3()) {
				ImageIcon iconPlayer3 = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\cloak_superman.png");
				panelContentPlayer.getBtPlayer3().setIcon(iconPlayer3);
				panelContentPlayer.getBtPlayer3().setPreferredSize(new Dimension(105, 105));
			}
			
			if(e.getSource() == panelContentPlayer.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\back.png");
				panelContentPlayer.getBtBack().setIcon(iconBack);
				panelContentPlayer.getBtBack().setPreferredSize(new Dimension(105, 105));
			}
		}
		
	}
}
