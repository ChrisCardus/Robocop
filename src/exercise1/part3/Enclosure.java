package exercise1.part3;

import lejos.nxt.Button;
import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;

public class Enclosure extends RobotProgrammingDemo {

	public Enclosure() {
		super();
	}

	boolean advance = true;

	@Override
	public void run() {
		Robot robocop = new Robot(false);

		while (m_run) {
			robocop.followLeft();
			if (robocop.bump()) {
				robocop.travel(-3);
				if (robocop.getRange() > 30) {
					robocop.turn(0, -90);
				} else {
					robocop.turn(0, 90);
				}
			}
		}
	}

	public static void main(String[] args) {
		RobotProgrammingDemo demo = new Enclosure();
		System.out.println("Please press the orange button to start");
		Button.waitForAnyPress();
		System.out.print("Please press the escape button to stop.");
		demo.run();
	}

}
