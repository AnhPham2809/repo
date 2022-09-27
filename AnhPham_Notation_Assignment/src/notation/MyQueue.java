package notation;
import java.util.ArrayList;

/**
 * 
 * @author Anh Pham
 * @date 25th September 2022
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {
	
	private int queueSize;
	private ArrayList<T>queueList;
	int queueElements = 0;
	int firstElement = 0;
	int lastElement = 0;
	/**
	 * Constructors
	 */
	public MyQueue()
	{
		queueSize = 1000; 
		queueList = new ArrayList<T>(queueSize);
	}
	public MyQueue(int size) {
		queueSize = size;
		queueList = new ArrayList<T>(queueSize);
	}
	
	/**
	 * isEmpty()
	 * Checks if the queue is empty or not.
	 * @return true if it's empty, false if it's not.
	 */
	@Override
	public boolean isEmpty() {
		if (queueElements != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	/**
	 * isFull()
	 * Checks if the queue is full or not
	 * @return true if it's full, false if it's not
	 */
	@Override
	public boolean isFull() {
		if(queueElements == queueSize)
		{
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * dequeue()
	 * Delete the first element in the queue and returns it
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException if queue is empty
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {
		T elementDequeue;
		if(queueElements == 0) {
			throw new QueueUnderflowException();
		}
		else {
			elementDequeue = queueList.get(firstElement);
			firstElement++; //Moves first element to the one after first element gotten from above
			queueElements--; //Reduce the amount of elements in the queue by removing the first element from the list.
		}
		return elementDequeue;
	}
	/**
	 * size()
	 * @return the number of elements in the queue
	 */
	@Override
	public int size() {
		return queueElements;
	}
	/**
	 * enqueue()
	 * Adds an element to the end of the queue
	 * @param e , the element that is added to the end of the queue
	 * @return true if it was added, 
	 * @throws QueueOverflowException if the array list is fulled and can't be added anymore.
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if(queueElements == queueSize) {
			throw new QueueOverflowException();
		}
		else {
			queueList.add(lastElement, e);
			lastElement++;
			queueElements++;
			return true;
		}
		
		
	}
	/**
	 * toString()
	 * Returns the elements of the queue in a String with the start of the string being the first Element
	 * @return the queue in a string form.
	 */
	@Override
	public String toString() {
		String stringQueue = "";
		for(int i = 0; i < queueList.size(); i++) { //Should loop every element in the queue????
			stringQueue += queueList.get(i);
		}
		return stringQueue;
	}
	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String stringQueue = "";
		for(int i = 0; i < queueList.size(); i++) {
			if(i == queueList.size() - 1) { //Checks if it's the last element since delimiter should only be in between.
				stringQueue += queueList.get(i);
			}
			else {
			stringQueue += queueList.get(i)+delimiter;
			}
		}
		return stringQueue;
	}
	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
	  * list reference within your Queue, you will be allowing direct access to the data of
	  * your Queue causing a possible security breech.
	  * @param list elements to be added to the Queue
	  * @throws QueueOverflowException if queue is full
	 
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyQueue = new ArrayList<T>(list);
		queueList.addAll(copyQueue);
		queueElements = queueList.size();
		
	}
}
