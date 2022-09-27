package notation;

public class StackOverflowException extends Exception {
	public StackOverflowException(){
		super("This stack is full.");
	}
}
