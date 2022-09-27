package notation;
/**
 * 
 * @author Anh Pham
 * @date 25th September 2022
 */
public class Notation {
	
	/**
	 * convertInfixToPostfix()
	 * @param infix
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException if invalid
	 * @throws QueueOverflowException 
	 * @throws StackOverflowException 
	 * @throws StackUnderflowException 
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException, QueueOverflowException, StackOverflowException, StackUnderflowException{
		MyStack<String> postfixStack = new MyStack<String>(20);
		MyQueue<String> postfixQueue = new MyQueue<String>(20);
		char[] element = infix.toCharArray();
		
		for(int i = 0; i < element.length; i++) { //read the infix expressions loop
			if(element[i]==' ') { //Checks space and skip it
				continue;
			}
			
			if(Character.isDigit(element[i])) { //Checks operand (numerical single digit) and copy it into the postfix queue
				postfixQueue.enqueue(String.valueOf(element[i]));
			}
			
			if(element[i]=='(') { //Checks if it's a left "(" and push it into the stack if it is.
				postfixStack.push(String.valueOf(element[i]));
			}
			
			if(element[i]=='+'||element[i]=='-') { //Checks operators + - 
				if(!postfixStack.isEmpty()) { //Make sure its not empty
					while(postfixStack.top().equals("+")||
						  postfixStack.top().equals("-")||
						  postfixStack.top().equals("*")||
						  postfixStack.top().equals("/")) {
						postfixQueue.enqueue(postfixStack.pop());
					}
				}
				postfixStack.push(String.valueOf(element[i]));
			}
			
			
			if(element[i]=='*'||element[i]=='/') { //Checkes operators * /
				if(!postfixStack.isEmpty()) { //Make sure its not empty
					while(postfixStack.top().equals("*")||
						  postfixStack.top().equals("/")) {
						postfixQueue.enqueue(postfixStack.pop());
					}
				}
				postfixStack.push(String.valueOf(element[i]));
			}
			
			
			if(element[i]==')') {
				while(!postfixStack.isEmpty() && !postfixStack.top().equals("(")) {
					postfixQueue.enqueue(postfixStack.pop());
				}
				if(postfixStack.isEmpty()) {
					throw new InvalidNotationFormatException();
				}
				if(postfixStack.top().equals("(")) {
					postfixStack.pop();
				}
			}
		}
		while(!postfixStack.isEmpty() && !postfixStack.top().equals("(")) {
			postfixQueue.enqueue(postfixStack.pop());
		}
		return postfixQueue.toString();
	}

	/**
	 * convertPostfixToInfix()
	 * @param postfix
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException if invalid
	 * @throws StackOverflowException 
	 * @throws StackUnderflowException 
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException{
		String infix;
		String firstStack;
		MyStack<String> infixStack = new MyStack<String>(10);
		char[] element= postfix.toCharArray();
		
		for(int i = 0; i < element.length; i++) { // Read the postfix expressions loop
			if(element[i]==' ') { //Checks space and skip it
				continue;
			}
			if(Character.isDigit(element[i])) { //Checks operand (numerical single digit)
				infixStack.push(String.valueOf(element[i]));
			}
			if(element[i]=='+'||element[i]=='-'||element[i]=='*'||element[i]=='/') { //Checks if its an operator
				if(infixStack.size() < 2) { //"If it's less than 2 values, throw an error"
					throw new InvalidNotationFormatException();
				}
				else {
					firstStack = infixStack.pop(); // pop first value
					infix="(" + infixStack.pop()+element[i]+firstStack+")"; // pop second value and put it all in infix string and "( )"
					infixStack.push(infix); // Push it back to the stack
				}
			}
		}
		if(infixStack.size() > 1) { //Should check if there is only one value since infix String was pushed in above.
			throw new InvalidNotationFormatException();
		}
		return infixStack.toString();
	}
	
	/**
	 * evaluatePostfixExpression()
	 * Evaluates the postfix expression from string to double
	 * @param postfixExpr
	 * @return the evaluation of the postfix expression as a double
	 *  @throws InvalidNotationFormatException if invalid
	 * @throws StackOverflowException 
	 * @throws StackUnderflowException 
	 */
public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException, StackOverflowException, StackUnderflowException {
	String a;
	String b;
	double result = 0;
	MyStack<String> postfixStack = new MyStack<String>(10);
	char[] element = postfixExpr.toCharArray();
	
	for(int i=0; i<element.length;i++) {
		if(element[i] == ' ') {
			continue;
		}
		if(Character.isDigit(element[i]) || element[i]=='(') {
			postfixStack.push(String.valueOf(element[i]));
		}
		else {
			if(postfixStack.size() < 2) {
				throw new InvalidNotationFormatException();
			}
			else {
				b = postfixStack.pop();
				a = postfixStack.pop();
				result = calculation(a, b, element[i]);
				postfixStack.push(Double.toString(result));
				}
				
			}
		}
	if(postfixStack.size() > 1) {
		throw new InvalidNotationFormatException();
	}
	
	return result;
}

/**
 * calculation()
 * Calculates two number in the string and give back the result.
 * @param String a transfer to Double num1 using parseDouble 
 * @param String b transfer to Double num2 using parseDouble
 * @param element just for the loop
 * @return result , the result of the calculation
 */
private static double calculation(String a, String b, char element) {
	double result = 0;
	double num1;
	double num2;
	num1 = Double.parseDouble(a);
	num2 = Double.parseDouble(b);
	switch(element) {
	case '+':
		result = num1 + num2;
		break;
	case '-':
		result = num1 - num2;
		break;
	case '*':
		result = num1 * num2;
		break;
	case '/':
		result = num1 / num2;
		break;
		default:
			System.out.println("Invalid Operator");
	}
	return result;
}



}
