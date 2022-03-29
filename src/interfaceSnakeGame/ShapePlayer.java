package interfaceSnakeGame;

import java.awt.Graphics;

public interface ShapePlayer {
public void paintSkin(Graphics g);
public int[] getXPlayer();
public int[] getYPlayer();
public int getUnit_size();
public int setUnit_size(int unit_size);
public int getBodyPlayer();
public int getGAME_UNIT();
public char getDirection();
public boolean getRunningPlayer();
public int getScreenWidth();
public int getScreenHeight();

}
