package factory;

import abstractSnakeGame.PaintMapObserver;
import interfaceSnakeGame.ShapePlayer;
import observer.PaintMap_ver1;
import observer.PaintMap_ver2;
import observer.PaintMap_ver3;
import subject.PlayerChose;

public class PaintMapFactory {
	
	public PaintMapObserver getPaintMap(String paintMapName, PlayerChose playerChose, ShapePlayer player) {
		if (paintMapName.equalsIgnoreCase("PAINTMAP1")) {
			return new PaintMap_ver1(playerChose, player);
		}else 
			if (paintMapName.equalsIgnoreCase("PAINTMAP2")) {
				return new PaintMap_ver2(playerChose, player);
		}else 
			if (paintMapName.equalsIgnoreCase("PAINTMAP3")) {
				return new PaintMap_ver3(playerChose, player);
		}
		return new PaintMap_ver1(playerChose, player);
	}
}
