package snake.model;

public class SnakeCell {
	private int x;
	private int y;

	public SnakeCell() {
		x = 0;
		y = 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void MoveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
