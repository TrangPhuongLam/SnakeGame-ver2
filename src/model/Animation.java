package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Animation {
	private Image[] images = new Image[0];
	private int sumOfImages = 0;
	private int currentImage = 0;
	private int width, height;
	
	public Animation(int widthImage, int heightImage) {
		// TODO Auto-generated constructor stub
		this.width = widthImage;
		this.height = heightImage;
	}
	
	public void paintAnimation(Graphics g, int xLocation, int yLocation) {
		Image resizeImage = resizeImage(images[currentImage], this.width, this.height).getImage();
		g.drawImage(resizeImage, xLocation, yLocation, this.width, this.height, null);
		
		updateCurrentImage();
		
	}
	
	public void addImage(Image image) {
		Image[] copyImage = images;
		images = new Image[sumOfImages + 1];
		
		//Copy Images
		for (int i = 0; i <sumOfImages; i++) {
			images[i] = copyImage[i];
		}
		
		//Add Image
		images[sumOfImages] = image;
				
		sumOfImages++;
	}
	
	public void updateCurrentImage() {
		currentImage++;
		if (currentImage >= sumOfImages) {
			currentImage = 0;
		}
	}
	
	public ImageIcon resizeImage(Image image, int width, int height) {
		Image imageResize = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(imageResize);	
		
		return icon;
	}
}
