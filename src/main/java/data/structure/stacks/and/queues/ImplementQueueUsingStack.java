package data.structure.stacks.and.queues;

import java.util.Stack;

/**
 *  This has two stacks. one is used to push elements. other is used to pop elements.
 *  Since we need FIFO for queue all elements needs to be pushed to another stack before taking out.
 *  But we can take advantage of the fact that element in popQueue are in order and only needs to be filled only when they are empty.
 *  This we have amortized time complexity of O(1) for both push and pop. 
 *  
 * @author Rishabh Agarwal
 * @param <T> : DataType of queue
 */
public class ImplementQueueUsingStack<T> {
	
	private Stack<T> pushStack = new Stack<>();
	private Stack<T> popStack = new Stack<>();
	
	public void offer(T t) {
		pushStack.push(t);
	}
	
	public T poll() {
		if( popStack.size() != 0 ) return popStack.pop();
		else if( pushStack.size() == 0) throw new ArrayIndexOutOfBoundsException("No element present.");  // both stacks are empty.
		
		while(pushStack.size() != 0) popStack.push( pushStack.pop() );
		return popStack.pop();
	}
	
	public T peek() {
		if( popStack.size() != 0 ) return popStack.peek();
		else if( pushStack.size() == 0) throw new ArrayIndexOutOfBoundsException("No element present.");  // both stacks are empty.
		
		while(pushStack.size() != 0) popStack.push( pushStack.pop() );
		return popStack.peek();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImplementQueueUsingStack [pushStack=").append(pushStack).append(", popStack=").append(popStack)
				.append("]");
		return builder.toString();
	}

}
