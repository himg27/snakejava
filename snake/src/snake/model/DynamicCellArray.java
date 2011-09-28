package snake.model;

import java.util.Arrays;

class DynamicCellArray {
	private SnakeCell[] cells;
	
	public DynamicCellArray(int initSize) {
		cells = new SnakeCell[initSize];
		for (int i=0; i<initSize; ++i)
			cells[i] = new SnakeCell();
	}
	
	public SnakeCellIterator iterator() {
		return new SnakeCellIteratorImpl(cells);
	}
	
	public void addEmpty() {
		cells = Arrays.copyOf(cells, cells.length+1);
	}
	
	public int getSize() {
		return cells.length;
	}
	
}
