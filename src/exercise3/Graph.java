package exercise3;

import ilist.IList;
import ilist.Nil;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;

import maybe.Just;
import maybe.Maybe;
import maybe.Nothing;
import container.Container;
import container.Queue;
import container.Stack;

public class Graph<A> {
	ArrayList<Node<A>> allNodes;
	ArrayList<A> nodeContent;
	
	/**
	 * Create a graph object
	 */
	public Graph() {
		//nodes = new HashMap<A,Node<A>>();
		allNodes = new ArrayList<Node<A>>();
		nodeContent = new ArrayList<A>();
	}
	
	/**
	 * Get the size of the graph
	 * @return The size of the graph
	 */
	public int size(){
		return allNodes.size();
	}
	
	/**
	 * Get the with content passed to method.
	 * If the node does not exist then it is added first
	 * @param c The content of the node
	 * @return The node
	 */
	/*public Node<A> nodeWith(A c) { 
	    Node<A> node;
	    if (nodes.containsKey(c)) {
	      node = nodes.get(c);
	    } else {
	      node = new Node<A>(c);
	      nodes.put(c,node);
	    }
	    return node;
	  }*/
	
	public Node<A> nodeWith(A c){
		addNode(c);
		return allNodes.get(nodeContent.indexOf(c));
	}
	
	public void addNode(A c){
		if(!nodeContent.contains(c)){
			nodeContent.add(c);
			allNodes.add(new Node<A>(c));
		}
	}

	/**
	 * Get the map of nodes in the graph
	 * @return nodes
	 */
	/*public Map<A,Node<A>> nodes() {
	    return nodes;
	}*/
	
	/**
	 * Performs bfs on the graph to find a path
	 * @param x The starting node of the path/search
	 * @param p The predicate the goal node has a meet.
	 * @return The path (object of Just of type IList) or an object of Nothing (if there is no path).
	 */
	public Maybe<List<Node<A>>> bfsPath(Node<A> x, Predicate<A> p){
		//Key = Destination. Value = Origin (Will keep track of all paths in tree)
		//Map<Node<A>, Node<A>> paths = new HashMap<Node<A>, Node<A>>();
		
		//Initialise nodes to not visited
		//Map<A, Boolean> visited = new HashMap<A, Boolean>();
		ArrayList<Node<A>> visited = new ArrayList<Node<A>>();
		//for (A key : nodes.keySet()) {
		  //  visited.put(key, false);
		//}
		
		Queue<Node<A>> q = new Queue<Node<A>>();
		q.add(x);
		while(!q.isEmpty()){
			Node<A> node = q.remove();
				//check if visited
				if(!visited.contains(node)) {
					visited.add(node);
					//check if node meets predicate
					if(p.holds(node.content())){
						//make ilist, set head as end node
						List<Node<A>> path = new ArrayList<Node<A>>();
						//while there is a key/destination which is this value/origin (Starts with goal node)
						while(node.getParent() != null){
							//add current node to the path
							path.add(0, node);
							//get the next origin (of the current key).
							node = node.getParent();
						}
						path.add(0, x);
						return new Just<List<Node<A>>>(path);
					} else {
						//Add successors to queue and paths
						//Iterator<Node<A>> iter = node.successors().iterator();
						//while (iter.hasNext()) {
						for(Node<A> destination : node.successors()){
							//Node<A> destination = iter.next();
							//Add to queue
						    q.add(destination);
						    //Add to paths if not visited (avoid being trapped in loops when tracking solution)
						    if(!visited.contains(destination)){
						    	Node<A> origin = node;
						    	//Sets iter.next() as keys. Current node as value for all successors.
						    	destination.setParent(origin);
						    //}
						    }
						}
					}
				}
			}
			return new Nothing<List<Node<A>>>();
	}
}