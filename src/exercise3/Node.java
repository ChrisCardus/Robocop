package exercise3;

import java.util.ArrayList;

//import java.util.HashSet;

public class Node<A> {
	private A nodeContent;
	//private HashSet<Node<A>> successors;
	private ArrayList<Node<A>> successors;
	private Node<A> parent;
	
	/**
	 * Create a new node
	 * @param The value of the node
	 */
	public Node(A a){
		this.nodeContent = a;
		//this.successors = new HashSet<Node<A>>();
		this.successors = new ArrayList<Node<A>>();
		this.parent = null;
	}
	
	public Node() {
		//this.successors = new HashSet<Node<A>>();
		this.successors = new ArrayList<Node<A>>();
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return nodeContent.toString();
	}
	
	/**
	 * Add a new successor the the node
	 * @param s the Node to be added
	 */
	public void addSuccessor(Node<A> s) {
		successors.add(s);
	}
	
	/**
	 * Check another node object is equal to this
	 * @param a The node to be compared to
	 * @return Whether or not the node is equal
	 */
	public boolean same(A a) {
		return content().equals(a);
	}
	
	/**
	 * Get the content of the node
	 * @return The node content
	 */
	public A content() {
		return nodeContent;
	}

	/**
	 * Get the successors of the node
	 * @return The successors of the node
	 */
	public ArrayList<Node<A>> successors() {
		return successors;
	}
	
	public Node<A> getParent() {
		return parent;
	}
	
	public void setParent(Node<A> parent) {
		this.parent = parent;
	}
}