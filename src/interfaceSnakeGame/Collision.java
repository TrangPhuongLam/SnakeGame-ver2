package interfaceSnakeGame;

import abstractSnakeGame.Barrier;

public interface Collision {
	public void collisionBody();
	public void collisionWall(Barrier wall);
	public void collisionSwamp(Barrier swamp);
}
