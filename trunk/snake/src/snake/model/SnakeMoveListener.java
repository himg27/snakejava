package snake.model;

import snake.model.exceptions.MoveBackException;

public interface SnakeMoveListener {
	public void move(SnakeDirection direction) throws MoveBackException;
}

