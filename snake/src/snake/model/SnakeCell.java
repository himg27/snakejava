package snake.model;

public class SnakeCell {

	private BoardPosition pos;
	
	public SnakeCell() {
		pos = new BoardPosition();
	}
	
	/**
	 * @return old cell's position
	 * */
	public BoardPosition MoveTo(int x, int y) {
		BoardPosition old = new BoardPosition(pos);		
		pos.setX(x);
		pos.setY(y);		
		return old;
	}
	
	public BoardPosition MoveTo(BoardPosition newPos) {
		return MoveTo(newPos.getX(), newPos.getY()); 
	}
	
	public int getX() {
		return pos.getX();
	}
	
	public int getY() {
		return pos.getY();
	}

}
