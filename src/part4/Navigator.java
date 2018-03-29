package part4;
import java.util.ArrayList;
import java.util.List;

import part1.Correct;
import part2.Path;
import part2.behaviours.Junction;
import exercise3.Coordinate;
import exercise3.Node;
import lejos.nxt.Button;
import lejos.robotics.subsumption.Arbitrator;
import lejos.robotics.subsumption.Behavior;
import lejos.util.Delay;
import maybe.Maybe;
import rp.Robot;
import rp.RobotProgrammingDemo;
import searching.PathFinder;


public class Navigator extends RobotProgrammingDemo {

	public Navigator() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void run() {
		//create robot
		Robot chenatron5 = new Robot();
		chenatron5.lightsOn();
		Delay.msDelay(3000);
		
		//Sets the initial values of both the light sensors.
		chenatron5.setInit(chenatron5.getLightLeft(), chenatron5.getLightRight());
		
		System.out.println("...");
		
		//Search
		PathFinder pathFinder = new PathFinder();
		Coordinate c1 = new Coordinate(11, 0), c2 = new Coordinate(6, 3);
		Maybe<List<Node<Coordinate>>>  solution = pathFinder.findPath(c1, c2);
		List<Node<Coordinate>> s = new ArrayList<Node<Coordinate>>();
		
		//check there is a path
		if(solution.size() == 0){
			System.out.println("No path found");
			Button.waitForAnyPress();
			System.exit(0);
		}
		
		s = solution.fromMaybe();
		
		//Create PathController
		int heading = PathController.minusX;
		PathController test = new PathController((ArrayList)s, heading);
		//convert path
		ArrayList<Integer> turns = test.turns();
		
		System.out.println("Press to go");
		Button.waitForAnyPress();
		
		
		//Create Array with behaviours from GridNavigator
		Path path = new Path(chenatron5, turns);
		Behavior junction = new Junction(chenatron5, path);
		Behavior correct = new Correct(chenatron5);
		Behavior[] bArray = {correct, junction};
		Arbitrator arby = new Arbitrator(bArray);
		arby.start();
	}

	public static void main(String[] args) {
		RobotProgrammingDemo demo = new Navigator();
		System.out.println("Navigator");
		System.out.println("Push button to start");
		Button.waitForAnyPress();
		demo.run();
	}

}
