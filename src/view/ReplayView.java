package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ReplayView extends JFrame{
	private JButton btReplay, btHome;
	private JPanel panelReplay;
	private ImageIcon iconReplay, iconHome;
	private int width = 400, height = 200;
	
	public ReplayView() {
		// TODO Auto-generated constructor stub
		setTitle("Replay");
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//--------------- Pannel Replay ----------------
		iconReplay = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\normal.png");
		btReplay = new JButton();
		btReplay.setIcon(iconReplay);
		btReplay.setContentAreaFilled(false);
		btReplay.setBorderPainted(false);
		btReplay.setFocusable(false);
		btReplay.setPreferredSize(new Dimension(105, 40));
		
		iconHome = new ImageIcon("D:\\git\\SnakeGame_ver2\\src\\data\\hard.png");
		btHome = new JButton();
		btHome.setIcon(iconHome);
		btHome.setContentAreaFilled(false);
		btHome.setBorderPainted(false);
		btHome.setFocusable(false);
		btHome.setPreferredSize(new Dimension(105, 40));
		
		panelReplay = new JPanel();
		panelReplay.setLayout(new GridLayout(1, 2));
		panelReplay.setPreferredSize(new Dimension(width, height));
		
		panelReplay.add(btReplay);
		panelReplay.add(btHome);
		
		add(panelReplay);
		
		
		btReplay.addMouseListener(new HandlerReplayView());
		btHome.addMouseListener(new HandlerReplayView());
		
		setResizable(false);
		setVisible(true);
	}
	
	
	
	public class HandlerReplayView implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			if(e.getSource() == btReplay) {
				ImageIcon iconMap2 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\normal1.png");
				btReplay.setIcon(iconMap2);
				btReplay.setPreferredSize(new Dimension(120, 45));
			}
			
			if(e.getSource() == btHome) {
				ImageIcon iconMap3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\hard1.png");
				btHome.setIcon(iconMap3);
				btHome.setPreferredSize(new Dimension(120, 45));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == btReplay) {
				ImageIcon iconMap2 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\normal.png");
				btReplay.setIcon(iconMap2);
				btReplay.setPreferredSize(new Dimension(105, 30));
			}
			
			if(e.getSource() == btHome) {
				ImageIcon iconMap3 = new ImageIcon("D:\\git\\GameSnake\\src\\data\\hard.png");
				btHome.setIcon(iconMap3);
				btHome.setPreferredSize(new Dimension(105, 30));
			}
		}
		
	}
}
