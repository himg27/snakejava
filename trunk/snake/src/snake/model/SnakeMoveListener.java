package snake.model;

import snake.model.exceptions.MoveBackException;
import snake.model.exceptions.OutOfBoardBoundsException;

public interface SnakeMoveListener {
	public void move(SnakeDirection direction) throws MoveBackException, OutOfBoardBoundsException;
}

