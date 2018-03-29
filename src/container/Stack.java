package container;
import java.util.*;

public class Stack<A> implements Container<A> {
	private java.util.Stack<A> s;
	
	/**
	 * Create a new Stack object
	 */
	public Stack(){
		s = new java.util.Stack<A>();
	}
	
	/**
	 * Remove an item from the stack
	 * @return The removed item
	 */
	public A remove() {
		// TODO Auto-generated method stub
		return s.pop();
	}

	/**
	 * Add an item to the stack
	 * @param a The item to be added
	 */
	@Override
	public void add(Object a) {
		// TODO Auto-generated method stub
		s.push((A) a);
	}

	/**
	 * Check if the queue is empty
	 * @return Whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return s.empty();
	}
}
