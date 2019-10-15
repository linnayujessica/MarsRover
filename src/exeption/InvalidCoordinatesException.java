package exeption;

public class InvalidCoordinatesException extends Exception {
	/**
	 * rover's coordinates are invalid
	 */
	private static final long serialVersionUID = -9155672643636572455L;

	public InvalidCoordinatesException(String string) {
		 super(string);
	}
}
