package factory;

import abstractSnakeGame.Food;
import model.Apple;
import model.Energy;
import model.Mushroom;

public class FoodFactory {

	public Food getFood(String food, int screenWidth, int screenHeight, int unit_size) {
		if (food.equalsIgnoreCase("APPLE")) {
			return new Apple(screenWidth, screenHeight, unit_size);
		}else 
			if (food.equalsIgnoreCase("MUSHROOM")) {
				return new Mushroom(screenWidth, screenHeight, unit_size);
		}else 
			if (food.equalsIgnoreCase("ENERGY")) {
				return new Energy(screenWidth, screenHeight, unit_size);
		}
		return new Apple(screenWidth, screenHeight, unit_size);
	}
}
