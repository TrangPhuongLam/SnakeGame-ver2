package gameState;

import java.awt.Color;
import java.awt.Graphics;

import abstractSnakeGame.ScreenGame;
import interfaceSnakeGame.GameState;

public class PauseGame implements GameState{
	private static PauseGame instance = new PauseGame();

	private PauseGame() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean doAction(ScreenGame screenGame) {
		// TODO Auto-generated method stub
		screenGame.setState(this);
		return false;
	}

	@Override
	public void paintState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.fillRect(0, 0, 800, 800);
		System.out.println("im in pause game");
	}

	public static PauseGame getInstance() {
		return instance;
	}
	
	
}
