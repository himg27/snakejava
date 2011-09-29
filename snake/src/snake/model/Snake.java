package snake.model;

import snake.model.exceptions.EatItselfException;
import snake.model.exceptions.MoveBackException;

public class Snake {
	private DynamicCellArray cells;
	
	private SnakeMoveListener moveListener = null;
	
	public Snake(int initialSize) {
		cells = new DynamicCellArray(initialSize);
	}
	
//TODO	
//	public void nom() {
//		++size;
//	}
	
	public void move(SnakeDirection direction) throws EatItselfException, MoveBackException {
		if (moveListener != null)
			moveListener.move(direction);
	}
	
	public void addSnakeMoveListener(SnakeMoveListener l) {
		moveListener = l;
	}
	
	public SnakeCellIterator iterator() {
		return cells.iterator();
	}
	
	public int getLength() {
		return cells.getSize();
	}
	
	public boolean canMove(SnakeDirection direction) {
		return cells.canMove(direction);
	}
}
