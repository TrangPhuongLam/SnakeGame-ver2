package factory;

import abstractSnakeGame.Barrier;
import model.Mushroom;
import model.Swamp;
import model.Wall;

public class BarrierFactory {

	public Barrier getBarrier(String barrier, int screenWidth, int screenHeight, int unit_size) {
		if (barrier.equalsIgnoreCase("SWAMP")) {
			return new Swamp(screenWidth, screenHeight, unit_size);
			
		}else 
			if(barrier.equalsIgnoreCase("WALL")) {
				return new Wall(screenWidth, screenHeight, unit_size);
			
		}
		
		return new Swamp(screenWidth, screenHeight, unit_size);
	}
}
