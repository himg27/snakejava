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

public class MainWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final static int SIZE_COEF = 50;
	
	private Board board;
	
	public MainWindow(Board board) {
		this.board = board;
		
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
		
		addKeyListener(new KeyboardListener(board.getSnake()));
		
        JMenuBar menuBar = new JMenuBar();
        
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenuItem newAction = new JMenuItem("New game");
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
		// TODO: init the snake
	}
}
