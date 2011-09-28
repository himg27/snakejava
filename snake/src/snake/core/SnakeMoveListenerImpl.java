package snake.core;

import snake.model.BoardPosition;
import snake.model.Snake;
import snake.model.SnakeCell;
import snake.model.SnakeCellIterator;
import snake.model.SnakeDirection;
import snake.model.SnakeMoveListener;

class SnakeMoveListenerImpl implements SnakeMoveListener {
	private Snake snakeObj;
	
	public SnakeMoveListenerImpl(Snake snake) {
		snakeObj = snake;
	}

	@Override
	public void move(SnakeDirection direction) {
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
		

		BoardPosition prev = head.MoveTo(newX, newY);
		while (it.hasNext()) {
			SnakeCell cur = it.next();
			prev = cur.MoveTo(prev);
		}
	}

}
