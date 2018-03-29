package container;

import java.util.LinkedList;
import java.util.Set;

public class Queue<A> implements Container<A> {

	private LinkedList<A> q;
	
	/**
	 * Create a new Queue object
	 */
	public Queue(){
		q = new LinkedList<A>();
	}
	
	/**
	 * Remove an item from the queue
	 * @return The removed item
	 */
	public A remove() {
		return q.remove(0);
	}

	/**
	 * Add an item to the queue
	 * @param a The item to be added
	 */
	public void add(Object a) {
		q.add((A) a);
	}

	/**
	 * Check if the queue is empty
	 * @return Whether the queue is empty
	 */
	public boolean isEmpty() {
		return q.isEmpty();
	}
	
	public void addAll(Set<A> c){
		q.addAll(c);
	}

}
