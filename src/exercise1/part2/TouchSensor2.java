package exercise1.part2;

import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;

public class TouchSensor2 extends RobotProgrammingDemo {

	private boolean pressed = false;

	public TouchSensor2() {
		super();
	}

	@Override
	public void run() {
		Robot robocop = new Robot(false);

		SensorPort.S1.addSensorPortListener(new SensorPortListener() {

			@Override
			public void stateChanged(SensorPort aSource, int aOldValue,
					int aNewValue) {
				if (aNewValue <= (aOldValue - 600)) {
					pressed = true;
				}
			}
		});

		while (m_run = true) {
			robocop.forward();
			if (pressed) {
				pressed = false;
				robocop.turn180();
			}
		}
	}

	public static void main(String[] args) {
		RobotProgrammingDemo demo = new TouchSensor2();
		demo.run();
	}

}
