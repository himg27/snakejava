package snake.model;

public class BoardPosition {
	private int x;
	private int y;
	
	public BoardPosition() {
		x = 0;
		y = 0;
	}
	
	public BoardPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public BoardPosition(BoardPosition copy) {
		x = copy.getX();
		y = copy.getY();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
