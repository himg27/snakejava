package snake.model;

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
	
	public void move(SnakeDirection direction) {
		if (moveListener != null)
			moveListener.move(direction);
	}
	
	public void addSnakeMoveListener(SnakeMoveListener l) {
		moveListener = l;
	}
	
	public SnakeCellIterator iterator() {
		return cells.iterator();
	}
}
