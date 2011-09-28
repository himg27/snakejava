package snake.core;

import snake.model.Board;
import snake.model.Snake;
import snake.ui.MainWindow;

public class AppController {
	private MainWindow win;
	private Snake snakeObj;
	private Board board;
	private final static int INIT_SNAKE_SIZE = 4;
	
	public AppController(int w, int h) {
		snakeObj = new Snake(INIT_SNAKE_SIZE);
		snakeObj.addSnakeMoveListener(new SnakeMoveListenerImpl(snakeObj));
		
		board = new Board(w, h);
		win = new MainWindow(board, snakeObj);
	}
	
}
