package snake.model;

import snake.model.collections.SnakeIterator;
import snake.model.exceptions.InvalidMoveDirectionException;
import snake.model.exceptions.OutOfBoardBoundsException;


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
		
		if (newX > bounds.getX() || newY > bounds.getY())
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
