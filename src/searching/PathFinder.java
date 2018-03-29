package searching;

import java.util.ArrayList;
import java.util.List;

import maybe.Maybe;
import exercise3.Coordinate;
import exercise3.Node;
import rp.util.Arrays;
import search.test.SearchBFS;
/*
 * Links search to robot
*/
public class PathFinder {
	private SearchBFS search;
	
	public PathFinder(){
		this.search = new SearchBFS();
	}
	
	public Maybe<List<Node<Coordinate>>> findPath(Coordinate c1, Coordinate c2){
		return search.search(c1, c2);
	}
}