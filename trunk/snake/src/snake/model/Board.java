package snake.model;

public class Board {
	private int cols;
	private int rows;
	
	public Board(int c, int r) {
		cols = c;
		rows = r;
	}
	
	public int getColumns() {
		return cols;
	}
	
	public int getRows() {
		return rows;
	}
}
