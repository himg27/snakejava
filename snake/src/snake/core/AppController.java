package snake.core;

import snake.model.Board;
import snake.ui.MainWindow;

public class AppController {
	private MainWindow win;
	private Board board;
	
	public AppController(int w, int h) {	
		board = new Board(w, h);
		win = new MainWindow(board);
	}
	
}
