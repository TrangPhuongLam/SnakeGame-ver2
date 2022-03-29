package factory;


import decorater.PlayerDecorator_1;
import decorater.PlayerDecorator_2;
import decorater.PlayerDecorator_3;
import interfaceSnakeGame.ShapePlayer;

public class PlayerDecoratorFactory {

	public ShapePlayer getPlayerDecorator(String playerDecoratorName, ShapePlayer playerDecorator) {
		if (playerDecoratorName.equalsIgnoreCase("playerDecorator1")) {
			return  new PlayerDecorator_1(playerDecorator);
		}else 
			if(playerDecoratorName.equalsIgnoreCase("playerDecorator2")){
			return new PlayerDecorator_2(playerDecorator);
		}else 
			if (playerDecoratorName.equalsIgnoreCase("playerDecorator3")) {
			return new PlayerDecorator_3(playerDecorator);
		}
	return new PlayerDecorator_1(playerDecorator);
	}
	
}
