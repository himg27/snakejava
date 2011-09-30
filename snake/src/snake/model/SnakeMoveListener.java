package snake.model;

import snake.model.exceptions.InvalidMoveDirectionException;
import snake.model.exceptions.OutOfBoardBoundsException;

public interface SnakeMoveListener {
	public void onMove(SnakeDirection direction) throws InvalidMoveDirectionException, OutOfBoardBoundsException;
}

