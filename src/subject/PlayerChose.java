package subject;

import java.util.ArrayList;

import abstractSnakeGame.PaintMapObserver;
import controller.ScreenGameController;

public class PlayerChose {
	private String playerDecoratorName = "playerDecorator2";
	private ArrayList<PaintMapObserver> paintMapObservers = new ArrayList<PaintMapObserver>();
	

	public PlayerChose() {
		super();
	}
	
	public void attach(PaintMapObserver map) {
		paintMapObservers.add(map);
	}
	
	public String getPlayerDecoratorName() {
		return playerDecoratorName;
	}

	public void setPlayerDecoratorName(String playerDecoratorName) {
		this.playerDecoratorName = playerDecoratorName;
		notifyPaintMap();
	}
	
	public void notifyPaintMap() {
		for(PaintMapObserver paintMap : paintMapObservers) {
			paintMap.updatePlayerDecorator();
		}
	}

}
