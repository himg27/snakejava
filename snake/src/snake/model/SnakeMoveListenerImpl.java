package snake.model;

import snake.model.exceptions.MoveBackException;


public class SnakeMoveListenerImpl implements SnakeMoveListener {
	private Snake snakeObj;
	
	public SnakeMoveListenerImpl(Snake snake) {
		snakeObj = snake;
	}

	@Override
	public void move(SnakeDirection direction) throws MoveBackException {
		SnakeCellIterator it = snakeObj.iterator();
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
		
		BoardPosition prev = head.MoveTo(newX, newY);
		while (it.hasNext()) {
			SnakeCell cur = it.next();
			
			if (!snakeObj.canMove(direction))
				throw new MoveBackException();
			
			prev = cur.MoveTo(prev);
		}
	}

}
