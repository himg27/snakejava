package snake.model.test;


import org.junit.Test;

import snake.model.BoardPosition;
import snake.model.Snake;
import snake.model.SnakeCell;
import snake.model.SnakeCellIterator;
import snake.model.SnakeDirection;
import snake.model.SnakeMoveListenerImpl;
import snake.model.exceptions.EatItselfException;
import snake.model.exceptions.MoveBackException;

import junit.framework.TestCase;


/**
 * Snake's position was horizontal by init
 * */
public class MoveSnakeTest extends TestCase {
	private Snake snake;
	private static int SNAKE_LENGTH = 10;
	
	private BoardPosition oldHeadPos;
	private BoardPosition oldTailPos;
	
	@Test
	public void testMoveUp() {
		try {
			snake.move(SnakeDirection.UP);
		} catch (EatItselfException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		} catch (MoveBackException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		
		SnakeCellIterator it = snake.iterator();
		SnakeCell head = it.next();
		
		assertEquals(head.getX(), oldHeadPos.getX());
		assertEquals(head.getY(), oldHeadPos.getY()+1);
		
		SnakeCell tail = null;
		while (it.hasNext()) {
			tail = it.next();
		}
		
		assertEquals(tail.getX(), oldTailPos.getX()+1);
		assertEquals(tail.getY(), oldTailPos.getY());
	}
	
	@Test
	public void testMoveDown() {
		try {
			snake.move(SnakeDirection.DOWN);
		} catch (EatItselfException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		} catch (MoveBackException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		
		SnakeCellIterator it = snake.iterator();
		SnakeCell head = it.next();
		
		assertEquals(head.getX(), oldHeadPos.getX());
		assertEquals(head.getY(), oldHeadPos.getY()-1);
		
		SnakeCell tail = null;
		while (it.hasNext()) {
			tail = it.next();
		}
		
		assertEquals(tail.getX(), oldTailPos.getX()+1);
		assertEquals(tail.getY(), oldTailPos.getY());
	}
	
	@Test
	public void testMoveLeft() {
		MoveBackException eMoveBack = null;
		try {
			snake.move(SnakeDirection.LEFT);
		} catch (EatItselfException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		} catch (MoveBackException e) {
			eMoveBack = e;
		}
		
		assertNotNull(eMoveBack);
	}

	@Test
	public void testMoveRight() {
		try {
			snake.move(SnakeDirection.RIGHT);
		} catch (EatItselfException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		} catch (MoveBackException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
		
		SnakeCellIterator it = snake.iterator();
		SnakeCell head = it.next();
		
		assertEquals(head.getX(), oldHeadPos.getX()+1);
		assertEquals(head.getY(), oldHeadPos.getY());
		
		SnakeCell tail = null;
		while (it.hasNext()) {
			tail = it.next();
		}
		
		assertEquals(tail.getX(), oldTailPos.getX()+1);
		assertEquals(tail.getY(), oldTailPos.getY());
	}

	@Override
	protected void setUp() throws Exception {
		snake = new Snake(SNAKE_LENGTH);
		snake.addSnakeMoveListener(new SnakeMoveListenerImpl(snake));
		
		int x = snake.getLength();
		final int y = 5;
		SnakeCellIterator it = snake.iterator();
		while (it.hasNext()) {
			SnakeCell cell = it.next(); 
			cell.MoveTo(x, y);
			if (x == snake.getLength()) {
				oldHeadPos = new BoardPosition(cell.getX(), cell.getY());
			} 
			else if (x == 1) {
				oldTailPos = new BoardPosition(cell.getX(), cell.getY());
			}
			
			--x;
		}
		
		super.setUp();
	}

}
