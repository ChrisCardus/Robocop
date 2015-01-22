package rp.systems;

import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.TouchSensor;

public class Robot {
	private DifferentialPilot pilot;
	private TouchSensor sensor;
	
	public Robot(DifferentialPilot pilot) {
		this.pilot = pilot;
	}
	
	public Robot(DifferentialPilot pilot, TouchSensor sensor) {
		this.pilot = pilot;
		this.sensor = sensor;
	}
	
	public void forward(){
		pilot.forward();
	}
	
	public void turn() {
		pilot.travel(-10.0);
		pilot.rotate(180);
	}

	public void stop() {
		pilot.stop();
	}
}