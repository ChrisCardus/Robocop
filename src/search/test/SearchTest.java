package search.test;

import java.util.LinkedList;
import java.util.List;


import java.util.Random;


import ilist.IList;
import mapping.GridMap;
import maybe.Just;
import maybe.Maybe;

import org.testng.Assert;

import rp.robotics.mapping.MapUtils;
import rp.robotics.mapping.RPLineMap;
import exercise3.Coordinate;
import exercise3.Node;

public class SearchTest {

	public static void main(String[] args) {
		RPLineMap lineMap = MapUtils.create2015Map1();
		int xJunctions = 14;
		int yJunctions = 8;
		float junctionSeparation = 30;
		int xInset = 15;
		int yInset = 15;
		GridMap gm = new GridMap(lineMap, xInset, yInset, xJunctions, yJunctions, junctionSeparation);
		Random generator = new Random();
		
		//Perform tests using 20 random searches
		for(int i = 0; i < 20; i++){
			SearchBFS search = new SearchBFS(gm);
			Coordinate c1 = new Coordinate(generator.nextInt(xJunctions), generator.nextInt(yJunctions));
			Coordinate c2 = new Coordinate(generator.nextInt(xJunctions), generator.nextInt(yJunctions));
			Maybe<List<Node<Coordinate>>> list = search.search(c1, c2);
			System.out.println(c1 + " to " + c2 + " has path : " + list);
			test(gm, list, c1, c2);
		}
		
		
		
	}
	public static void test(GridMap gm, Maybe<List<Node<Coordinate>>> list, Coordinate c1, Coordinate c2){
		if(list.size() == 0){
			//check for no path
			int x1 = c1.x, y1 = c1.y, x2 = c2.x, y2 = c2.y;
			Assert.assertTrue(gm.isObstructed(x1, y1) || gm.isObstructed(x2, y2));
		} else {
			//checking if there is a path
			List<Node<Coordinate>> path = new LinkedList<Node<Coordinate>>();
			path = list.fromMaybe();
			
			//Check each transition is valid
			for(int i = 0; i < path.size() - 1; i++) {
				Node<Coordinate> n1 = path.get(i);
				Node<Coordinate> n2 = path.get(i + 1);
				int x1 = n1.content().x, y1 = n1.content().y, 
						x2 = n2.content().x, y2 = n2.content().y;
				Assert.assertTrue(gm.isValidTransition(x1, y1, x2, y2));
			}
		}
	}
}