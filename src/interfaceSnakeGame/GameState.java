package interfaceSnakeGame;

import java.awt.Graphics;

import abstractSnakeGame.ScreenGame;

public interface GameState {
	public boolean doAction(ScreenGame screenGame);
	public void paintState(Graphics g);
}
