package snake.model;

import snake.model.collections.SnakeIterator;

public class SnakeFactory {
	public static int DEFAULT_COORD_VALUE = 5;
	
	public static Snake CreateSnake(int size, boolean isHorisontal, BoardPosition bounds) {
		Snake snake = new Snake(size);
		snake.setSnakeMoveListener(new SnakeMoveListenerImpl(snake, bounds));
		
		int x = DEFAULT_COORD_VALUE;
		int y = DEFAULT_COORD_VALUE;
		
		if (isHorisontal) {
			x = snake.getLength();
		} else {
			y = snake.getLength();
		}
		
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
