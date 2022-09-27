package notation;

public class InvalidNotationFormatException extends Exception {
	public InvalidNotationFormatException() {
		super("This format is invalid");
	}
}
