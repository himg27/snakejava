package snake.model;

import snake.core.exceptions.EatItselfException;
import snake.core.exceptions.InvalidMoveDirectionException;
import snake.core.exceptions.OutOfBoardBoundsException;
import snake.model.collections.DynamicCellArray;
import snake.model.collections.SnakeIterator;

public class Snake {
	private DynamicCellArray cells;
	
	private SnakeMoveListener moveListener = null;
	private SnakeWasMovedListener snakeMovedListener = null;
	
	public Snake(int initialSize) {
		cells = new DynamicCellArray(initialSize);
	}
	
	public void nomNom() {
		cells.add();
	}
	
	public void move(SnakeDirection direction) throws EatItselfException, InvalidMoveDirectionException, OutOfBoardBoundsException {
		if (moveListener != null) {
			moveListener.onMove(direction);
			if (snakeMovedListener != null) {
				snakeMovedListener.onSnakeMoved();
			}
		}
	}
	
	public void setSnakeMoveListener(SnakeMoveListener l) {
		moveListener = l;
	}
	
	public void setSnakeAfterMoveListeners(SnakeWasMovedListener l) {
		snakeMovedListener = l;
	}
	
	public SnakeIterator iterator() {
		return cells.iterator();
	}
	
	public int getLength() {
		return cells.getSize();
	}
	
	public boolean isValidDirection(SnakeDirection direction) {
		return cells.canMove(direction);
	}
}
