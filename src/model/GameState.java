package model;

public class GameState {
	public static  boolean isPlaying = false;
	public static  boolean isGameOver = false;
	public static boolean isStartGame = false;
	
	public static boolean getPlaying() {
		return isPlaying;
	}
	public static void setPlaying(boolean isPlaying) {
		GameState.isPlaying = isPlaying;
	}
	public static boolean getgameOver() {
		return isGameOver;
	}
	public static void setIsgameOver(boolean isgameOver) {
		GameState.isGameOver = isgameOver;
	}
	public static boolean getStartGame() {
		return isStartGame;
	}
	public static void setStartGame(boolean isStartGame) {
		GameState.isStartGame = isStartGame;
	}
}
