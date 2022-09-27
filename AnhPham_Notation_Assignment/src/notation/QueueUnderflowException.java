package notation;

public class QueueUnderflowException extends Exception {
	public QueueUnderflowException(){
		super("This queue is empty.");
	}
}
