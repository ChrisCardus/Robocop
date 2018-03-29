package searching;

import lejos.nxt.Button;
import exercise3.*;

public class RobotSearchTest {

	public static void main(String[] args) {
		System.out.println("Press a key");
		Button.waitForAnyPress();
		System.out.println("...");
		PathFinder path = new PathFinder();
		
		Coordinate c1 = new Coordinate(0, 0), c2 = new Coordinate(0, 2);
		System.out.println();
		System.out.println("0, 0 to 0, 2");
		System.out.println(path.findPath(c1, c2));
		System.out.println("...");
		Button.waitForAnyPress();
		
		c1 = new Coordinate(11, 0);
		c2 = new Coordinate(6, 3);
		System.out.println();
		System.out.println("11, 0 to 6, 3");
		System.out.println(path.findPath(c1, c2));
		System.out.println("...");
		Button.waitForAnyPress();
	}
}