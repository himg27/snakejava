package snake.core.exceptions;

public class InvalidMoveDirectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidMoveDirectionException() {
		super("Can't move back");
	}
}
