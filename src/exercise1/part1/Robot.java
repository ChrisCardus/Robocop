package exercise1.part1;

import lejos.robotics.navigation.DifferentialPilot;

public class Robot {
	private DifferentialPilot pilot;

	public Robot(DifferentialPilot pilot) {
		this.pilot = pilot;
	}
	
	public void left() {
		pilot.arcForward(10.0);
	}

	public void right() {
		pilot.arcForward(-10.0);
	}

	public void stop() {
		pilot.stop();
	}
}