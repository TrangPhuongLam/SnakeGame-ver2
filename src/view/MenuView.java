package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.MenuController;
import panel.PanelBgMenu;
import panel.PanelContentMenu;


public class MenuView extends JFrame{
	static LevelView levelView;
	static HelpView helpView;
	public MenuController menuController;
	private PanelBgMenu panelBgMenu;
	private PanelContentMenu panelContentMenu;
	static final int WIDTH = 530, HEIGHT = 646;

	public MenuView(int width, int height) {
//		Sound.playSound("D:\\git\\SnakeGame_ver2\\src\\data\\sound.wav");
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
		panelContentMenu.getBtHelp().addMouseListener(new handler());
		panelContentMenu.getBtScore().addMouseListener(new handler());
		panelContentMenu.getBtExit().addMouseListener(new handler());

		add(panelContentMenu, BorderLayout.CENTER);
		setVisible(true);
		
	}

	public MenuView() {
		this(WIDTH, HEIGHT);
	}
	
	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentMenu.getBtPlay()) {
				menuController.newGame();
			}
			
			if(e.getSource() == panelContentMenu.getBtLevel()) {
				levelView = new LevelView();
				dispose();
			}
			
			if(e.getSource() == panelContentMenu.getBtHelp()) {
				helpView = new HelpView();
				dispose();
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
				ImageIcon iconMap3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Level1.png");
				panelContentMenu.getBtLevel().setIcon(iconMap3);
				panelContentMenu.getBtLevel().setPreferredSize(new Dimension(120, 45));
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
				ImageIcon iconMap3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Level.png");
				panelContentMenu.getBtLevel().setIcon(iconMap3);
				panelContentMenu.getBtLevel().setPreferredSize(new Dimension(105, 30));
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
