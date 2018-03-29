package part4;
import java.util.ArrayList;

import lejos.nxt.Button;
import rp.Robot;
import exercise3.Coordinate;
import exercise3.Node;

public class PathController{
	public static final int plusY = 1, plusX = 2,
			minusY = -1, minusX = -2;
	private ArrayList<Node<Coordinate>> path;
	private ArrayList<Integer> turns;
	private int heading;
	private int currentHeading;

	public PathController(ArrayList<Node<Coordinate>> path, int heading){
		this.path = path;
		this.turns = new ArrayList<Integer>();
		this.heading = heading;
		this.currentHeading = heading;
		convertPath();
	}
	
	public ArrayList<Integer> turns(){
		return turns;
	}
	
	public void convertPath() {
		//For every transition, convert that transition into a turn
		for(int i = 1; i < path.size()-1; i++){
			turns.add(nextTurn(path.get(i).content(), path.get(i+1).content()));
		}
	}
	
	public int nextTurn(Coordinate c1, Coordinate c2){
		//get next heading
		int needed = neededHeading(c1, c2);
		
		//Update heading and hold former one
		int oldHeading = currentHeading;
		currentHeading = needed;
		
		//Find needed turn based on oldHeading a needed one.
		if(oldHeading == needed){
			return Robot.STRAIGHT;
		} else if(oldHeading == plusX){
			if(needed == plusY){
				return Robot.LEFT;
			} else{
				return Robot.RIGHT;
			}
		} else if(oldHeading == plusY){
			if(needed == plusX){
				return Robot.RIGHT;
			} else{
				return Robot.LEFT;
			}
		} else if(oldHeading == minusX){
			if(needed == plusY){
				return Robot.RIGHT;
			} else{
				return Robot.LEFT;
			}
		} else if(oldHeading == minusY){
			if(needed == plusX){
				return Robot.LEFT;
			} else{
				return Robot.RIGHT;
			}
		} else {
			return Robot.STRAIGHT;
		}
	}

	//Get needed heading when moving between two coordinates
	public int neededHeading(Coordinate current, Coordinate next){
		int x1 = current.x, x2 = next.x, y1 = current.y, y2 = next.y;
		
		if (x1-x2 > 0){
			return minusX;
		} else if(x1-x2 < 0) {
			return plusX;
		} else if(y1-y2 > 0){
			return minusY;
		} else if(y1-y2 < 0) {
			return plusY;
		}
		return heading;
	}
}
