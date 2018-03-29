package search.test;
import java.util.List;

import mapping.GridMap;
import maybe.Maybe;
import rp.robotics.mapping.MapUtils;
import rp.robotics.mapping.RPLineMap;
import exercise3.Coordinate;
import exercise3.Graph;
import exercise3.Node;
import exercise3.Predicate;

public class SearchBFS {
	private GridMap map;
	private Graph<Coordinate> graph;
	
	public SearchBFS(GridMap map){
		//create grid map and graph
		this.map = map;
		this.graph = new Graph<Coordinate>();
	
		//add nodes and successors to graph
		makeGraph();
	}
	
	public SearchBFS(){
		//Create LineMap and other parameters for grid map
		RPLineMap lineMap = MapUtils.create2015Map1();
		int xJunctions = 14;
		int yJunctions = 8;
		float junctionSeparation = 30;
		int xInset = 15;
		int yInset = 15;
		
		//Create grid map
		GridMap gm = new GridMap(lineMap, xInset, yInset, xJunctions, yJunctions, junctionSeparation);
		
		this.map = gm;
		this.graph = new Graph<Coordinate>();
		makeGraph();
	}
	
	private void makeGraph(){
		//Create node and add successors
		for(int x=0; x < map.getXSize(); x++){
			for(int y=0; y < map.getYSize(); y++){
				Coordinate p = new Coordinate(x, y);
				//add node
				graph.nodeWith(p);
				
				//add successors (if they are successors)
				addSuccessor(p, new Coordinate(x-1,y));
				addSuccessor(p, new Coordinate(x+1,y));
				addSuccessor(p, new Coordinate(x,y-1));
				addSuccessor(p, new Coordinate(x,y+1));
			}
		}
	}
	
	private void addSuccessor(Coordinate node, Coordinate s) {
		//check if s is connected to node
		if(map.isValidGridPosition(s.x, s.y)){
			if(map.isValidTransition(node.x, node.y, s.x, s.y)){
				//add the node with point s as a successor of node
				graph.nodeWith(node).addSuccessor(graph.nodeWith(s));
			}
		}
	}
	
	public Maybe<List<Node<Coordinate>>> search(Coordinate start, final Coordinate end){
		
		//make Predicate for BFS
		Predicate<Coordinate> p = new Predicate<Coordinate>(){
			public boolean holds(Coordinate a) {
				return a.equals(end);
			}
		};
	
		//do the search
		return graph.bfsPath(graph.nodeWith(start), p);
	}
}
