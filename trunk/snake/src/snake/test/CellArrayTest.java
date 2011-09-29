package snake.test;


import org.junit.Test;

import snake.model.DynamicCellArray;
import snake.model.SnakeCell;
import snake.model.SnakeCellIterator;

import junit.framework.TestCase;

public class CellArrayTest extends TestCase {
	private DynamicCellArray arr = null;
	private final int ARR_SIZE = 5;
	
	@Test
	public void testDynamicCellArray() {
		assertEquals(arr.getSize(), ARR_SIZE);
	}

	@Test
	public void testIterator() {
		SnakeCellIterator it = arr.iterator();
		
		int i=0;
		while (it.hasNext()) {
			SnakeCell c = it.next();
			c.MoveTo(i*2, i*3);
			++i;
		}
		
		assertEquals(i, ARR_SIZE);
	}

	@Test
	public void testAdd() {
		arr.add();
		assertEquals(arr.getSize(), ARR_SIZE+1);
		
	}

	@Override
	protected void setUp() throws Exception {
		arr = new DynamicCellArray(5);
		super.setUp();
	}

}
