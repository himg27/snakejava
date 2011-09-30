package snake.model;

import snake.model.collections.SnakeIterator;

public class SnakeFactory {
	public static Snake CreateSnake(int size, boolean isHorisontal, BoardPosition bounds) {
		Snake snake = new Snake(size);
		snake.setSnakeMoveListener(new SnakeMoveListenerImpl(snake, bounds));
		
		BoardPosition center = new BoardPosition(bounds.getX()/2, bounds.getY()/2);
		
		int x = center.getX();
		int y = center.getY();
		
		SnakeIterator it = snake.iterator();
		while (it.hasNext()) {
			SnakeCell cell = it.next();
			cell.MoveTo(x, y);
			if (isHorisontal) {
				--x;
			} else {
				--y;
			}		
		}
		
		return snake;
	}
	
}
