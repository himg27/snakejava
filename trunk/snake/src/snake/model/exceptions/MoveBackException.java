package snake.model.exceptions;

public class MoveBackException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MoveBackException() {
		super("Can't move back");
	}
}
