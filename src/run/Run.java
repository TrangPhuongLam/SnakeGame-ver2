package run;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import abstractSnakeGame.ScreenGame;
import controller.NavigationController;
import controller.PlayerController;
import controller.ScreenGameController;
import model.HighScore;
import panel.PanelMap_1;
import panel.PanelMap_2;
import panel.PanelMap_3;
import view.GameFrameView;
import view.HelpView;
import view.LevelView;
import view.MenuView;
import view.PlayerView;

public class Run {
	public static void main(String[] args) {
//		LevelView levelView = new LevelView();
//		HelpView helpView = new HelpView();
		MenuView menuView = new MenuView();
//		PlayerView playerView = new PlayerView();
//		GameFrameView gameFrameView = new GameFrameView(new PanelMap_3());
		
		
//		ScreenGame map1 = new PanelMap_1("playerDecorator3");
//		GameFrameView gameFrameView = new GameFrameView(map1);
		
		
	}
}
