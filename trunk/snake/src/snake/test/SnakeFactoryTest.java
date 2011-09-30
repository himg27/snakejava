package snake.test;

import static org.junit.Assert.*;

import org.junit.Test;

import snake.model.BoardPosition;
import snake.model.Snake;
import snake.model.SnakeCell;
import snake.model.SnakeFactory;
import snake.model.collections.SnakeIterator;

public class SnakeFactoryTest {

	@Test
	public void testHor() {
		final int SNAKE_SIZE = 5;
		final BoardPosition bounds = new BoardPosition(20, 20);
		Snake snakeHor = SnakeFactory.CreateSnake(SNAKE_SIZE, true, bounds);
		assertNotNull(snakeHor);
		assertEquals(snakeHor.getLength(), SNAKE_SIZE);
		
		int i=0;
		SnakeIterator it = snakeHor.iterator();
		while (it.hasNext()) {
			SnakeCell cell = it.next();
			assertEquals(cell.getX(), (bounds.getX() / 2) - i);
			assertEquals(cell.getY(), bounds.getY() / 2);			
			++i;
		}
	}

	@Test
	public void testVert() {
		final int SNAKE_SIZE = 5;
		final BoardPosition bounds = new BoardPosition(20, 20);
		Snake snakeHor = SnakeFactory.CreateSnake(SNAKE_SIZE, false, bounds);
		assertNotNull(snakeHor);
		assertEquals(snakeHor.getLength(), SNAKE_SIZE);
		
		int i=0;
		SnakeIterator it = snakeHor.iterator();
		while (it.hasNext()) {
			SnakeCell cell = it.next();
			assertEquals(cell.getX(), bounds.getX() / 2);
			assertEquals(cell.getY(), (bounds.getY() / 2)  - i);			
			++i;
		}
	}
}
