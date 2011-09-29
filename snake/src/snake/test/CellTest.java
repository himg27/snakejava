package snake.test;

import junit.framework.TestCase;

import org.junit.Test;

import snake.model.BoardPosition;
import snake.model.SnakeCell;

public class CellTest extends TestCase {

	@Test
	public void testFillArray() {
		SnakeCell cell = new SnakeCell();
		cell.MoveTo(5, 6);
		assertEquals(cell.getX(), 5);
		assertEquals(cell.getY(), 6);
		
		BoardPosition old = cell.MoveTo(10, 20);
		assertEquals(old.getX(), 5);
		assertEquals(old.getY(), 6);
		assertEquals(cell.getX(), 10);
		assertEquals(cell.getY(), 20);		
		
		BoardPosition newPos = new BoardPosition();
		newPos.setX(100);
		newPos.setY(150);
		old = cell.MoveTo(newPos);
		assertEquals(old.getX(), 10);
		assertEquals(old.getY(), 20);
		assertEquals(cell.getX(), 100);
		assertEquals(cell.getY(), 150);	
	}
}
