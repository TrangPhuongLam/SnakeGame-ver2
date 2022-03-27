package context;

import abstractSnakeGame.Food;
import interfaceSnakeGame.Eating;

public class EatingContext {
	private Eating eating;

	public EatingContext(Eating eating) {
		super();
		this.eating = eating;
	}
	
	public void excuteEating(Food apple, Food mushroom, Food energy) {
		eating.eatApple(apple);
		eating.eatMushroom(mushroom);
		eating.eatEnergy(energy);
		
	}
}
