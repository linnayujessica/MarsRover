package exeption;

public class InvalidPlateauException extends Exception {
	/**
	 * plateau is invalid
	 */
	private static final long serialVersionUID = -9155672643636572455L;

	public InvalidPlateauException(String string) {
		 super(string);
	}
}
