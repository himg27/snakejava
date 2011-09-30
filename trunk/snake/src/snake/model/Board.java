package snake.model;

import snake.core.SnakeMoveListenerImpl;

public class Board {
	private int cols;
	private int rows;
	private Snake snakeObj;
	private final static int INIT_SNAKE_SIZE = 4;
	
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
	
	public Snake getSnake() {
		return snakeObj;
	}
	
	public void reset() {
		snakeObj = SnakeFactory.CreateSnake(INIT_SNAKE_SIZE, true, new BoardPosition(rows, cols));
		snakeObj.setSnakeMoveListener(new SnakeMoveListenerImpl(snakeObj, new BoardPosition(rows, cols)));
	}
}
