package snake.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import snake.model.Board;
import snake.model.SnakeCell;
import snake.model.SnakeWasMovedListener;
import snake.model.collections.SnakeIterator;

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static int SIZE_COEF = 50;
	
	private Board board;
	private JButton[][] buttons;
	
	public MainWindow(Board board) {
		this.board = board;
		buttons = new JButton[board.getRows()][board.getColumns()];
		
		setTitle("Snake");
	    setSize(board.getColumns()*SIZE_COEF, board.getRows()*SIZE_COEF);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    initControls();
	    setVisible(true);
	}
	
	private void initControls() {
		setLayout(new GridLayout(board.getRows(), board.getColumns()));
		for (int r = 0; r < board.getRows(); ++r) {
			for (int c = 0; c < board.getColumns(); ++c) {
				buttons[r][c] = new JButton();
				buttons[r][c].setEnabled(false);
				add(buttons[r][c]);
			}
		}
		
        JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem newAction = new JMenuItem("New game");
        newAction.setAccelerator(KeyStroke.getKeyStroke("F2"));
        
        JMenuItem exitAction = new JMenuItem("Exit");
        exitAction.setAccelerator(KeyStroke.getKeyStroke("alt X"));
        
        fileMenu.add(newAction);
        fileMenu.addSeparator();
        fileMenu.add(exitAction);
        
        newAction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				newGame();
			}
		});
        
        exitAction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);				
			}
		});
        
	}
	
	private void newGame() {
		board.reset();
		addKeyListener(new KeyboardListener(board.getSnake()));
        board.getSnake().setSnakeAfterMoveListeners(new SnakeWasMovedListener() {
			@Override
			public void onSnakeMoved() {
				redrawSnake();
			}
		});
        
		redrawSnake();
	}
	
	private void redrawSnake() {
		for (int r = 0; r < board.getRows(); ++r) {
			for (int c = 0; c < board.getColumns(); ++c) {
				buttons[r][c].setText("");
			}
		}
		
		SnakeIterator it = board.getSnake().iterator();
		while (it.hasNext()) {
			SnakeCell cell = it.next();
			buttons[getInvertY(cell.getY())][cell.getX()].setText("s"); //y = cols
		}
	}
	
	private int getInvertY(int y) {
		return board.getRows() - y;
	}
}
