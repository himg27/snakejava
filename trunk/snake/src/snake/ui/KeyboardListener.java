package snake.ui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import snake.core.exceptions.EatItselfException;
import snake.core.exceptions.InvalidMoveDirectionException;
import snake.core.exceptions.OutOfBoardBoundsException;
import snake.model.Snake;
import snake.model.SnakeDirection;

class KeyboardListener implements KeyListener {
	private Snake snakeObj;
	private Component parent;
	
	public KeyboardListener(Snake snake, Component comp) {
		snakeObj = snake;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		try {
			switch(arg0.getKeyCode()) {
			case KeyEvent.VK_DOWN: 
				snakeObj.move(SnakeDirection.DOWN); 
				break;
			case KeyEvent.VK_UP:
				snakeObj.move(SnakeDirection.UP);
				break;
			case KeyEvent.VK_LEFT:
				snakeObj.move(SnakeDirection.LEFT);
				break;
			case KeyEvent.VK_RIGHT:
				snakeObj.move(SnakeDirection.RIGHT);
				break;
			}
		} catch (EatItselfException eat) {
			JOptionPane.showMessageDialog(parent, "SUICIDE");
		} catch (InvalidMoveDirectionException e) {
			// TODO		
		} catch (OutOfBoardBoundsException e) {
			JOptionPane.showMessageDialog(parent, "Game over");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

}
