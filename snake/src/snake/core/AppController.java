package snake.core;

import snake.model.Board;
import snake.ui.MainWindow;

public class AppController {
	private MainWindow win;
	private Board board;
	
	public AppController(int c, int r) {	
		board = new Board(c, r);
		win = new MainWindow(board);
	}
	
}
