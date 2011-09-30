package snake.core;

import snake.model.Board;
import snake.ui.MainWindow;

public class AppController {
	
	public AppController(int c, int r) {	
		new MainWindow(new Board(c, r));
	}
	
}
