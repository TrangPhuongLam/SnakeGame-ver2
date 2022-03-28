package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SpringLayout;

import controller.LevelController;
import controller.PlayerChoseController;
import controller.PlayerController;
import controller.ScreenGameController;
import panel.PanelBgLevel;
import panel.PanelBgPlayer;
import panel.PanelContentLevel;
import panel.PanelContentPlayer;

public class PlayerView extends JFrame{
	static MenuView menuView;
	private PanelBgPlayer panelBgPlayer;
	private PanelContentPlayer panelContentPlayer;
	private ScreenGameController screenGameController;
	private PlayerController playerController;
	static final int WIDTH = 300, HEIGHT = 350;
	
	public PlayerView(int width, int height) {
		// TODO Auto-generated constructor stub
//		playerController = new PlayerController();
//		screenGameController = new ScreenGameController();
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
		
		
		layout.putConstraint(SpringLayout.NORTH, panelContentPlayer, 65, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panelContentPlayer, 90, SpringLayout.WEST, this);
		setLayout(layout);
		
		
		add(panelContentPlayer);
		setVisible(true);
		setResizable(false);
	}
	
	public PlayerView() {
		this(WIDTH, HEIGHT);
	}

	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentPlayer.getBtPlayer1()) {
//				screenGameController.getPlayerController().setPlayerDecoratorName("playerDecorator3");
				System.out.println("1");
				PlayerChoseController choseController = new PlayerChoseController();
				System.out.println("2");
				String player1 = choseController.getPlayerDecorator_1();
				System.out.println("3");
				LevelController levelController = new LevelController(player1);
				System.out.println("4");
				LevelView levelView = new LevelView(levelController);
				
				dispose();
				
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer2()) {
				playerController.setPlayerDecoratorName("playerDecorator2");
				dispose();
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer3()) {
				playerController.setPlayerDecoratorName("playerDecorator3");
				dispose();
			}
			
			if(e.getSource() == panelContentPlayer.getBtBack()) {
				menuView = new MenuView();
//				menuView.setVisible(true);
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
			if(e.getSource() == panelContentPlayer.getBtPlayer1()) {
				ImageIcon iconPlayer1 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\easy1.png");
				panelContentPlayer.getBtPlayer1().setIcon(iconPlayer1);
				panelContentPlayer.getBtPlayer1().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer2()) {
				ImageIcon iconPlayer2 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\normal1.png");
				panelContentPlayer.getBtPlayer2().setIcon(iconPlayer2);
				panelContentPlayer.getBtPlayer2().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer3()) {
				ImageIcon iconPlayer3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\hard1.png");
				panelContentPlayer.getBtPlayer3().setIcon(iconPlayer3);
				panelContentPlayer.getBtPlayer3().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentPlayer.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\GameSnake\\src\\data\\back1.png");
				panelContentPlayer.getBtBack().setIcon(iconBack);
				panelContentPlayer.getBtBack().setPreferredSize(new Dimension(105, 30));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentPlayer.getBtPlayer1()) {
				ImageIcon iconPlayer1 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\easy.png");
				panelContentPlayer.getBtPlayer1().setIcon(iconPlayer1);
				panelContentPlayer.getBtPlayer1().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer2()) {
				ImageIcon iconPlayer2 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\normal.png");
				panelContentPlayer.getBtPlayer2().setIcon(iconPlayer2);
				panelContentPlayer.getBtPlayer2().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentPlayer.getBtPlayer3()) {
				ImageIcon iconPlayer3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\hard.png");
				panelContentPlayer.getBtPlayer3().setIcon(iconPlayer3);
				panelContentPlayer.getBtPlayer3().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentPlayer.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\GameSnake\\src\\data\\back.png");
				panelContentPlayer.getBtBack().setIcon(iconBack);
				panelContentPlayer.getBtBack().setPreferredSize(new Dimension(105, 30));
			}
		}
		
	}
}
