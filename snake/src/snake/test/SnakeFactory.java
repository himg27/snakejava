package snake.test;

import snake.model.Snake;
import snake.model.SnakeCell;
import snake.model.SnakeMoveListenerImpl;
import snake.model.collections.SnakeIterator;

class SnakeFactory {
	public static int DEFAULT_COORD_VALUE = 5;
	
	public static Snake CreateSnake(int size, boolean isHorisontal) {
		Snake snake = new Snake(size);
		snake.addSnakeMoveListener(new SnakeMoveListenerImpl(snake));
		
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
