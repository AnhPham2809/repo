package notation;

public class StackUnderflowException extends Exception {
	public StackUnderflowException(){
		super("This stack is empty.");
	}
}
