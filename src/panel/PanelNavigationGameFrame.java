package panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class PanelNavigationGameFrame extends JPanel{
	public JLabel labelScore, labelMaxScore;
	
	public PanelNavigationGameFrame(int width, int height) {
		// TODO Auto-generated constructor stub
		paintFrame(width, height);
	}
	
	public void paintFrame(int width, int height) {

		SpringLayout layoutN = new SpringLayout();
		this.setLayout(layoutN);
		this.setPreferredSize(new Dimension(width, height / 13));
		this.setBackground(new Color(0, 139, 69));

		labelScore = new JLabel("0");
		labelScore.setFont(labelScore.getFont().deriveFont(15.0f));
		labelScore.setForeground(Color.WHITE);

		labelMaxScore = new JLabel("0");
		labelMaxScore.setFont(labelMaxScore.getFont().deriveFont(15.0f));
		labelMaxScore.setForeground(Color.WHITE);

		ImageIcon iconApple = new ImageIcon("D:\\git\\GameSnake\\src\\data\\Apple.png");
		JLabel labelApple = new JLabel();
		labelApple.setIcon(iconApple);

		ImageIcon iconCup = new ImageIcon("D:\\git\\GameSnake\\src\\data\\cup.png");
		JLabel labelCup = new JLabel();
		labelCup.setIcon(iconCup);

//		ImageIcon iconVolume = new ImageIcon("D:\\git\\GameSnake\\src\\data\\volume.png");
//		JButton btVolume = new JButton(iconVolume);
//		btVolume.setPreferredSize(new Dimension(20, 16));
//		btVolume.setBackground(new Color(0, 139, 69));
//		btVolume.setBorderPainted(false);

		this.add(labelApple);
		this.add(labelScore);
		this.add(labelCup);
		this.add(labelMaxScore);
		// this.add(btVolume);

		layoutN.putConstraint(SpringLayout.WEST, labelApple, 5, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelApple, 5, SpringLayout.NORTH, this);
		layoutN.putConstraint(SpringLayout.WEST, labelScore, 30, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelScore, 10, SpringLayout.NORTH, this);
		layoutN.putConstraint(SpringLayout.WEST, labelCup, 100, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelCup, 5, SpringLayout.NORTH, this);
		layoutN.putConstraint(SpringLayout.WEST, labelMaxScore, 130, SpringLayout.WEST, this);
		layoutN.putConstraint(SpringLayout.NORTH, labelMaxScore, 10, SpringLayout.NORTH, this);
//		layoutN.putConstraint(SpringLayout.NORTH, btVolume, 12, SpringLayout.NORTH, this);
//		layoutN.putConstraint(SpringLayout.WEST, btVolume, 430, SpringLayout.WEST, this);

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}

}
