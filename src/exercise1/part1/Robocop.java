package exercise1.part1;

import lejos.nxt.Button;
import lejos.nxt.ButtonListener;
import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;

public class Robocop extends RobotProgrammingDemo {

	private int direction;

	public Robocop() {
		super();
	}

	@Override
	public void run() {
		Robot robocop = new Robot(false);
		direction = -1;

		Button.LEFT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}

			public void buttonPressed(Button b) {
				direction = 0;
			}
		});

		Button.RIGHT.addButtonListener(new ButtonListener() {
			public void buttonReleased(Button b) {
			}

			public void buttonPressed(Button b) {
				direction = 1;
			}
		});

		Button.waitForAnyPress();
		while (m_run) {
			if (direction == 0) {
				robocop.left();
			} else if (direction == 1) {
				robocop.right();
			} else {
				robocop.stop();
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		System.out.println("I'm Robocop");

		RobotProgrammingDemo demo = new Robocop();
		demo.run();
	}

}
