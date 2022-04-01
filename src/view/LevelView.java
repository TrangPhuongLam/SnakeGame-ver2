package view;

import java.awt.Dimension;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.LevelController;
import panel.PanelBgLevel;
import panel.PanelContentLevel;
import panel.PanelMap_1;
import volumeState.OnVolume;


public class LevelView extends JFrame{

	private PanelBgLevel panelBgLevel;
	private static PanelContentLevel panelContentLevel ;
	private LevelController levelController;
	static  int width = 300, height = 400;
	private Clip clip = OnVolume.getInstance().clipSound("D:\\git\\SnakeGame_ver2\\src\\data\\sound.wav");
	private String playerDecoratorName = "playerDecorator1";
	
	public LevelView(int width, int height) {
		clip.start();

		levelController = new LevelController(this);
		
		
		setTitle("Level");
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set border layout
		SpringLayout layout = new SpringLayout();

		//------------- Panel Background Level --------------
		panelBgLevel = new PanelBgLevel();
		
		setContentPane(panelBgLevel);

		// ----------------- Panel Content Level -----------------
		panelContentLevel = new PanelContentLevel();
//		this.width = panelContentLevel.getWIDTH() * 2;
//		this.height = panelContentLevel.getHEIGHT() + 100;
		panelContentLevel.getBtMap1().addMouseListener(new handler());
		panelContentLevel.getBtMap2().addMouseListener(new handler());
		panelContentLevel.getBtMap3().addMouseListener(new handler());
		panelContentLevel.getBtBack().addMouseListener(new handler());
		
		
		layout.putConstraint(SpringLayout.NORTH, panelContentLevel, this.height / 5, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, panelContentLevel, this.width / 4, SpringLayout.WEST, this);
		setLayout(layout);
		
		
		add(panelContentLevel);
		setVisible(true);
		setResizable(false);
	}
	
	public LevelView() {
		this(width, height);
	}
	
	public LevelView(String playerDecoratorName) {
		this(width, height);
		this.playerDecoratorName = playerDecoratorName;
		this.levelController.setPlayerDecoratorName(this.playerDecoratorName);
	}
	
	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			clip.stop();
			if(e.getSource() == panelContentLevel.getBtMap1()) {
				levelController.map1();
			}
			
			if(e.getSource() == panelContentLevel.getBtMap2()) {
				levelController.map2();
			}
			
			if(e.getSource() == panelContentLevel.getBtMap3()) {
				levelController.map3();
			}
			
			if(e.getSource() == panelContentLevel.getBtBack()) {
				levelController.backMenuView();
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
			if(e.getSource() == panelContentLevel.getBtMap1()) {
				ImageIcon iconMap1 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\easy1.png");
				panelContentLevel.getBtMap1().setIcon(iconMap1);
				panelContentLevel.getBtMap1().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentLevel.getBtMap2()) {
				ImageIcon iconMap2 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\normal1.png");
				panelContentLevel.getBtMap2().setIcon(iconMap2);
				panelContentLevel.getBtMap2().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentLevel.getBtMap3()) {
				ImageIcon iconMap3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\hard1.png");
				panelContentLevel.getBtMap3().setIcon(iconMap3);
				panelContentLevel.getBtMap3().setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == panelContentLevel.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\GameSnake\\src\\data\\back1.png");
				panelContentLevel.getBtBack().setIcon(iconBack);
				panelContentLevel.getBtBack().setPreferredSize(new Dimension(105, 30));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentLevel.getBtMap1()) {
				ImageIcon iconMap1 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\easy.png");
				panelContentLevel.getBtMap1().setIcon(iconMap1);
				panelContentLevel.getBtMap1().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentLevel.getBtMap2()) {
				ImageIcon iconMap2 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\normal.png");
				panelContentLevel.getBtMap2().setIcon(iconMap2);
				panelContentLevel.getBtMap2().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentLevel.getBtMap3()) {
				ImageIcon iconMap3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\hard.png");
				panelContentLevel.getBtMap3().setIcon(iconMap3);
				panelContentLevel.getBtMap3().setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == panelContentLevel.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\GameSnake\\src\\data\\back.png");
				panelContentLevel.getBtBack().setIcon(iconBack);
				panelContentLevel.getBtBack().setPreferredSize(new Dimension(105, 30));
			}
		}
		
	}

}
