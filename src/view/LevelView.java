package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import controller.LevelController;
import panel.PanelBgLevel;
import panel.PanelContentLevel;


public class LevelView extends JFrame{

	static MenuView menuView;
	private PanelBgLevel panelBgLevel;
	private static PanelContentLevel panelContentLevel = new PanelContentLevel();
	private LevelController levelController = new LevelController(this);
	static  int width = panelContentLevel.getWIDTH() * 2, height = panelContentLevel.getHEIGHT() + 100;

	public LevelView(int width, int height) {
		

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
	
	public LevelView(LevelController levelController) {
		this(width, height);
		this.levelController = levelController;
	}
	
	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentLevel.getBtMap1()) {
				levelController.Map1();
				dispose();
				
			}
			
			if(e.getSource() == panelContentLevel.getBtMap2()) {
				levelController.Map2();
				dispose();
			}
			
			if(e.getSource() == panelContentLevel.getBtMap3()) {
				levelController.Map3();
				dispose();
			}
			
			if(e.getSource() == panelContentLevel.getBtBack()) {
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
