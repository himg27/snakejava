package snake.model;

import snake.core.exceptions.InvalidMoveDirectionException;
import snake.core.exceptions.OutOfBoardBoundsException;

public interface SnakeMoveListener {
	public void onMove(SnakeDirection direction) throws InvalidMoveDirectionException, OutOfBoardBoundsException;
}

