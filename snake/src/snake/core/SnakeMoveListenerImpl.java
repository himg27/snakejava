package snake.core;

import snake.core.exceptions.InvalidMoveDirectionException;
import snake.core.exceptions.OutOfBoardBoundsException;
import snake.model.BoardPosition;
import snake.model.Snake;
import snake.model.SnakeCell;
import snake.model.SnakeDirection;
import snake.model.SnakeMoveListener;
import snake.model.collections.SnakeIterator;


public class SnakeMoveListenerImpl implements SnakeMoveListener {
	private Snake snakeObj;
	private BoardPosition bounds;
	
	public SnakeMoveListenerImpl(Snake snake, BoardPosition boardBounds ) {
		snakeObj = snake;
		bounds = boardBounds;
	}

	@Override
	public void onMove(SnakeDirection direction) throws InvalidMoveDirectionException, OutOfBoardBoundsException {
		SnakeIterator it = snakeObj.iterator();
		SnakeCell head = it.next();
		int oldX = head.getX();
		int oldY = head.getY();
		int newX = oldX;
		int newY = oldY;
		
		switch(direction) {
		case DOWN: 
			--newY;
			break;
		case UP:
			++newY;
			break;
		case LEFT:
			--newX;
			break;
		case RIGHT:
			++newX;
			break;
		}

		if (!snakeObj.isValidDirection(direction))
			throw new InvalidMoveDirectionException();
		
		if (newX > bounds.getX() - 1 || newY > bounds.getY() - 1 || newX < 0 || newY < 0)
			throw new OutOfBoardBoundsException();
		
		BoardPosition prev = head.MoveTo(newX, newY);
		while (it.hasNext()) {
			SnakeCell cur = it.next();
			
			if (!snakeObj.isValidDirection(direction))
				throw new InvalidMoveDirectionException();
			
			prev = cur.MoveTo(prev);
		}
	}

}
