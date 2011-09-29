package snake.model.collections;

import snake.model.SnakeCell;

class SnakeCellIteratorImpl implements SnakeIterator {
	private int i = 0;
	private int length;
	private SnakeCell[] cellsRef;
	
	public SnakeCellIteratorImpl(SnakeCell[] cells) {
		length = cells.length;
		cellsRef = cells;
	}
	
	@Override
	public boolean hasNext() {
		return i < length;
	}

	@Override
	public SnakeCell next() {
		return cellsRef[i++];
	}

}
