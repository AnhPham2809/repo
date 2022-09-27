package notation;

import java.util.ArrayList;
/**
 * 
 * @author Anh Pham
 * @date 25th September 2022
 * @param <T>
 */
public class MyStack<T> implements StackInterface<T> {
	private int stackSize = 1000;
	private ArrayList<T>stackList;
	int stackElements = 0;


	public MyStack() {
		stackList = new ArrayList<T>(stackSize);
	}
	
	public MyStack(int size) {
		stackSize = size;
		stackList = new ArrayList<T>(stackSize);
	}
	/**
	 * isEmpty()
	 * Checks if the stack is empty or not.
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (stackElements == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * isFull()
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (stackElements == stackSize) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * pop()
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T pop() throws StackUnderflowException {
		T elementPop;
		if(stackElements==0) {
			throw new StackUnderflowException();
		}
		else {
			elementPop= stackList.get(stackElements -1);
			stackList.remove(stackElements-1);
			stackElements--;
			return elementPop;
		}
		
	}
	/**
	 * top()
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException if stack is empty
	 */
	@Override
	public T top() throws StackUnderflowException {
		if(stackElements == 0) {
			throw new StackUnderflowException();
		}
		else {
			return stackList.get(stackElements-1);
		}
		
	}
	/**
	 * size()
	 * @return the number of elements in the stack
	 */
	@Override
	public int size() {
		return stackElements;
		
	}
	/**
	 * push()
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException if stack is full
	 */
	@Override
	public boolean push(T e) throws StackOverflowException {
		if(stackElements >= stackSize) {
			throw new StackOverflowException();
		}
		else {
			stackList.add(e);
			stackElements++;
			return true;
		}
	}
	/**
	 * toString()
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
		String stringStack = "";
		for(int i = 0; i < stackList.size(); i++) { //Should loop every element in the stack
			stringStack += stackList.get(i);
		}
		return stringStack;
	}
	/**
	 * toString()
	 * @param delimiter
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String stringStack = "";
		for(int i = 0; i < stackList.size(); i++) {
			if(i == stackList.size() - 1) { //Checks if it's the last element since delimiter should only be in between.
				stringStack += stackList.get(i);
			}
			else {
			stringStack += stackList.get(i) + delimiter;
			}
		}
		return stringStack;

		
	}
	 /**
	  * fill()
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  * @throws StackOverflowException if stack gets full
	  */
	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copyStack = new ArrayList<T>(list);
		stackList.addAll(copyStack);
		stackElements = stackList.size();	
	}
		
	}


