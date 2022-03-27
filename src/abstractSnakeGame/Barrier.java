package abstractSnakeGame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import controller.ScreenGameController;

public abstract class Barrier {
	protected int xBarrier, yBarrier, screenWidth = 4, screenHeight = 4, unit_size = 4;
	protected ScreenGameController controller;
	protected ImageIcon iconBarrierResize;
	protected Image imageBarrier, imageResize;
	protected Random random;
	
	public Barrier(int screenWidth, int screenHeight, int unit_size) {
		// TODO Auto-generated constructor stub
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.unit_size = unit_size;
		
		random = new Random();
	}
	
	public void randomBarrier(){
		int sumOfSquareWidth = screenWidth / unit_size;
		int sumOfSquareHeight = screenHeight / unit_size;
		xBarrier = random.nextInt((int)(sumOfSquareWidth)) * unit_size;
		yBarrier = random.nextInt((int)(sumOfSquareHeight)) * unit_size;
	}
	
	public void paintBarrier(Graphics g) {
		g.drawImage(iconBarrierResize.getImage(), xBarrier, yBarrier, 
				iconBarrierResize.getIconWidth(), iconBarrierResize.getIconHeight(), null);
	}
	
	public void resizeBarrier(ImageIcon icon) {
		imageBarrier = icon.getImage();
		imageResize = imageBarrier.getScaledInstance(unit_size, unit_size, Image.SCALE_SMOOTH);
		iconBarrierResize = new ImageIcon(imageResize);
	}


	public int getxBarrier() {
		return xBarrier;
	}

	public void setxBarrier(int xBarrier) {
		this.xBarrier = xBarrier;
	}

	public int getyBarrier() {
		return yBarrier;
	}

	public void setyBarrier(int yBarrier) {
		this.yBarrier = yBarrier;
	}
	
	
}
