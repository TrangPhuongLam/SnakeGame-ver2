package abstractSnakeGame;

import java.awt.Graphics;
import java.util.Random;

import javax.swing.ImageIcon;

import controller.ScreenGameController;

public abstract class Food {
	protected int xFood, yFood, screenWidth = 4, screenHeight = 4, unit_size = 4;
	protected ScreenGameController controller;
	protected Random random;
	
	public Food(int screenWidth, int screenHeight, int unit_size) {
		// TODO Auto-generated constructor stub
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
		this.unit_size = unit_size;
		
		random = new Random();
		randomFood();
	}
	
	
	
	public void randomFood(){
		int sumOfSquareWidth = screenWidth / unit_size;
		int sumOfSquareHeight = screenHeight / unit_size;
		xFood = random.nextInt((int)(sumOfSquareWidth)) * unit_size;
		yFood = random.nextInt((int)(sumOfSquareHeight)) * unit_size;
	}
	/**---------- implement randomFood example -----------------
	appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;
	appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;
 * 
 * @param g
 */
	
	public abstract void paintFood(Graphics g);
	/**------------- implement paintFood ------------
		g.drawImage(iconFood.getImage(), xFood, yFood, 
			iconFood.getIconWidth(), iconFood.getIconHeight(), null);
 * 
 */

	public int getxFood() {
		return xFood;
	}

	public void setxFood(int xFood) {
		this.xFood = xFood;
	}

	public int getyFood() {
		return yFood;
	}

	public void setyFood(int yFood) {
		this.yFood = yFood;
	}
	
}
