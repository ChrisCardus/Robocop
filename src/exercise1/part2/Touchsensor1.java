package exercise1.part2;

import lejos.nxt.Button;
import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;

public class Touchsensor1 extends RobotProgrammingDemo {

	public Touchsensor1() {
		super();
	}

	@Override
	public void run() {
		Robot robocop = new Robot(false);

		while (m_run = true) {
			robocop.forward();
			if (robocop.bump()) {
				robocop.turn180();
			}
			
		}
	}

	public static void main(String[] args) {
		RobotProgrammingDemo demo = new Touchsensor1();
		Button.waitForAnyPress();
		demo.run();
	}

}
