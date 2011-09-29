package snake.model;

import snake.model.collections.SnakeIterator;
import snake.model.exceptions.MoveBackException;
import snake.model.exceptions.OutOfBoardBoundsException;


public class SnakeMoveListenerImpl implements SnakeMoveListener {
	private Snake snakeObj;
	private BoardPosition bounds;
	
	public SnakeMoveListenerImpl(Snake snake, BoardPosition boardBounds ) {
		snakeObj = snake;
		bounds = boardBounds;
	}

	@Override
	public void move(SnakeDirection direction) throws MoveBackException, OutOfBoardBoundsException {
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

		if (!snakeObj.canMove(direction))
			throw new MoveBackException();
		
		if (newX > bounds.getX() || newY > bounds.getY())
			throw new OutOfBoardBoundsException();
		
		BoardPosition prev = head.MoveTo(newX, newY);
		while (it.hasNext()) {
			SnakeCell cur = it.next();
			
			if (!snakeObj.canMove(direction))
				throw new MoveBackException();
			
			prev = cur.MoveTo(prev);
		}
	}

}
