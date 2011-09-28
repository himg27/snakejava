package snake.ui;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import snake.model.Board;
import snake.model.Snake;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static int SIZE_COEF = 50;
	
	private Board board;
	private Snake snakeObj;
	
	public MainWindow(Board board, Snake snake) {
		this.board = board;
		snakeObj = snake;
		
		setTitle("Snake");
	    setSize(board.getColumns()*SIZE_COEF, board.getRows()*SIZE_COEF);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    initControls();
	    setVisible(true);
	}
	
	private void initControls() {
		setLayout(new GridLayout(board.getColumns(), board.getRows()));
		for (int r = 0; r < board.getRows(); ++r) {
			for (int c = 0; c < board.getColumns(); ++c) {
				JButton b = new JButton();
				b.setEnabled(false);
				add(b);
			}
		}
		
		addKeyListener(new KeyboardListener(snakeObj));
	}
	
	public void newGame(Snake snake) {
		snakeObj = snake;
	}
}
