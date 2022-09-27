package notation;

public class QueueOverflowException extends Exception {
	public QueueOverflowException(){
		super("This queue is full.");
	}
}
