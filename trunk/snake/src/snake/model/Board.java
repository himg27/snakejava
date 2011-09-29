package snake.model;

public class Board {
	private int cols;
	private int rows;
	private Snake snakeObj;
	private final static int INIT_SNAKE_SIZE = 4;
	
	public Board(int c, int r) {
		cols = c;
		rows = r;
		snakeObj = new Snake(INIT_SNAKE_SIZE);
		snakeObj.addSnakeMoveListener(new SnakeMoveListenerImpl(snakeObj));
	}
	
	public int getColumns() {
		return cols;
	}
	
	public int getRows() {
		return rows;
	}
	
	public Snake getSnake() {
		return snakeObj;
	}
}
