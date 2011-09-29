package snake.model.collections;

import snake.model.SnakeCell;
import snake.model.SnakeDirection;

public class DynamicCellArray extends BaseDynamicArray<SnakeCell> {
	
	public DynamicCellArray(int initSize) {
		elements = new SnakeCell[initSize];
		for (int i=0; i<initSize; ++i)
			elements[i] = new SnakeCell();
	}
	
	public SnakeIterator iterator() {
		return new SnakeCellIteratorImpl(elements);
	}
	
	public boolean canMove(SnakeDirection direction) {
		SnakeCell head = elements[0];
		SnakeCell secondCell = elements[1];
		boolean res = false;
		
		switch(direction) {
		case DOWN:
			res = head.getY() - 1 != secondCell.getY();
			break;
		case UP:
			res = head.getY() + 1 != secondCell.getY();
			break;
		case LEFT:
			res = head.getX() - 1 != secondCell.getX();
			break;
		case RIGHT:
			res = head.getX() + 1 != secondCell.getX();
			break;
		}
		
		return res;
	}


	@Override
	protected SnakeCell createElement() {
		return new SnakeCell();
	}
	
}
