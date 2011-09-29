package snake.model;

import snake.model.collections.DynamicCellArray;
import snake.model.collections.SnakeIterator;
import snake.model.exceptions.EatItselfException;
import snake.model.exceptions.MoveBackException;
import snake.model.exceptions.OutOfBoardBoundsException;

public class Snake {
	private DynamicCellArray cells;
	
	private SnakeMoveListener moveListener = null;
	
	public Snake(int initialSize) {
		cells = new DynamicCellArray(initialSize);
	}
	
	public void nomNom() {
		cells.add();
	}
	
	public void move(SnakeDirection direction) throws EatItselfException, MoveBackException, OutOfBoardBoundsException {
		if (moveListener != null)
			moveListener.move(direction);
	}
	
	public void setSnakeMoveListener(SnakeMoveListener l) {
		moveListener = l;
	}
	
	public SnakeIterator iterator() {
		return cells.iterator();
	}
	
	public int getLength() {
		return cells.getSize();
	}
	
	public boolean canMove(SnakeDirection direction) {
		return cells.canMove(direction);
	}
}
