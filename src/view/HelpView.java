package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

import panel.PanelBgHelp;
import panel.PanelContentHelp;


public class HelpView extends JFrame{
	static MenuView menuView;
	private PanelBgHelp panelBgHelp;
	private PanelContentHelp panelContentHelp;
	static final int WIDTH = 530, HEIGHT = 646;

	public HelpView(int width, int height) {
		// TODO Auto-generated method stub
		setTitle("Help");
		setSize(new Dimension(width, height));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// set borderLayout.
		SpringLayout layout = new SpringLayout();

		//-------------- Panel Background Help -----------------
		panelBgHelp = new PanelBgHelp();
		
		setContentPane(panelBgHelp);
		
		
		//----------------- Panel Content Help ----------------------
		panelContentHelp = new PanelContentHelp();
		panelContentHelp.getBtBack().addMouseListener(new handler());
				
				
		layout.putConstraint(SpringLayout.SOUTH, panelContentHelp, 500, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.WEST, panelContentHelp, 200, SpringLayout.WEST, this);
		
		add(panelContentHelp);
		setLayout(layout);
		setVisible(true);
	}
	
	public HelpView() {
		this(WIDTH, HEIGHT);
	}
	private class handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentHelp.getBtBack()) {
				menuView = new MenuView();
//				menuView.setVisible(true);
//				dispose();
			}
		}

		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentHelp.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\GameSnake\\src\\data\\back1.png");
				panelContentHelp.getBtBack().setIcon(iconBack);
				panelContentHelp.getBtBack().setPreferredSize(new Dimension(120, 45));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == panelContentHelp.getBtBack()) {
				ImageIcon iconBack = new ImageIcon("D:\\git\\GameSnake\\src\\data\\back.png");
				panelContentHelp.getBtBack().setIcon(iconBack);
				panelContentHelp.getBtBack().setPreferredSize(new Dimension(105, 30));
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

	}

}
