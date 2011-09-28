package snake.ui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import snake.model.Snake;
import snake.model.SnakeDirection;

class KeyboardListener implements KeyListener {
	private Snake snakeObj;
	
	public KeyboardListener(Snake snake) {
		snakeObj = snake;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
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
