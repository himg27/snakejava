package snake.model;

import java.util.Arrays;

public class DynamicCellArray {
	private SnakeCell[] cells;
	
	public DynamicCellArray(int initSize) {
		cells = new SnakeCell[initSize];
		for (int i=0; i<initSize; ++i)
			cells[i] = new SnakeCell();
	}
	
	public SnakeCellIterator iterator() {
		return new SnakeCellIteratorImpl(cells);
	}
	
	public void add() {
		cells = Arrays.copyOf(cells, cells.length+1);
		SnakeCell newCell = new SnakeCell();
		cells[cells.length-1] = newCell;
		newCell.MoveTo(cells[cells.length-2].getX(), cells[cells.length-2].getY());
	}
	
	public int getSize() {
		return cells.length;
	}
	
	public boolean canMove(SnakeDirection direction) {
		SnakeCell head = cells[0];
		SnakeCell secondCell = cells[1];
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
	
}
