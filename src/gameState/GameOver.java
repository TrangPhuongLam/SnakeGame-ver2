package gameState;

import java.awt.Color;
import java.awt.Graphics;

import abstractSnakeGame.ScreenGame;
import interfaceSnakeGame.GameState;

public class GameOver implements GameState{
	private static GameOver instance = new GameOver();

	private GameOver() {
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
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 800, 800);
//		System.out.println("im in game over");
	}

	public static GameOver getInstance() {
		return instance;
	}
	
	

}
