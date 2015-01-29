package rp.systems;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.DifferentialPilot;

public class Robot {
	private DifferentialPilot pilot;
	private TouchSensor touch;
	private RangeFinder sonic;

	public Robot(boolean reverse) {
		this.pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A, Motor.B,
				reverse);
		this.touch = new TouchSensor(SensorPort.S1);
		this.sonic = new UltrasonicSensor(SensorPort.S4);
	}

	public void forward() {
		pilot.forward();
	}

	public void followLeft() {
		if (sonic.getRange() < 10) {
			pilot.arcForward(sonic.getRange());
		} else if (sonic.getRange() > 12 && sonic.getRange() < 30) {
			pilot.arcForward(-50);
		} else if (sonic.getRange() > 30) {
			pilot.travel(5);
			pilot.rotate(-90);
			pilot.travel(5);
		} else {
			pilot.setTravelSpeed(6);
			pilot.forward();
		}
	}

	public void turn(int distance, int angle) {
		pilot.travel(distance);
		pilot.rotate(angle);
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

	public boolean bump() {
		return touch.isPressed();
	}

	public float getRange() {
		return sonic.getRange();
	}

	public void travel(int i) {
		pilot.travel(i);
	}

	public void setTravelSpeed(int speed) {
		pilot.setTravelSpeed(speed);
	}
}