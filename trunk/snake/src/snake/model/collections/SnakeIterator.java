package snake.model.collections;

import snake.model.SnakeCell;

public interface SnakeIterator {
	public boolean hasNext();
	public SnakeCell next();
}
