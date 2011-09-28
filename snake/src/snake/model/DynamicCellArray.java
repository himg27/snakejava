package snake.model;

class DynamicCellArray {
	private SnakeCell[] cells;
	
	public DynamicCellArray(int initSize) {
		cells = new SnakeCell[initSize];
		for (int i=0; i<initSize; ++i)
			cells[i] = new SnakeCell();
	}
	
	public SnakeCellIterator iterator() {
		return new SnakeCellIteratorImpl(cells); //TODO optimize
	}
	
}
