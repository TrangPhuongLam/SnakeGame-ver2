package context;

import abstractSnakeGame.Barrier;
import interfaceSnakeGame.Collision;

public class CollisionContext {
	private Collision collision;

	public CollisionContext(Collision collision) {
		super();
		this.collision = collision;
	}
	
	public void excuteCollision(Barrier wall, Barrier swamp) {
		collision.collisionBody();
		collision.collisionWall(wall);
		collision.collisionSwamp(swamp);
	}
}
