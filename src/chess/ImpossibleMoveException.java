package chess;

public class ImpossibleMoveException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImpossibleMoveException(String errorMessage) {
		super(errorMessage);
	}
}
