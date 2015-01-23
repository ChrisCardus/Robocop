package rp.systems;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Robot {
	private DifferentialPilot pilot;
	private TouchSensor sensor;
	
	public Robot(DifferentialPilot pilot) {
		this.pilot = pilot;
		this.sensor = new TouchSensor(SensorPort.S1);;
		
		
	}
	
	public void forward(){
		pilot.forward();
	}
	
	public void turn() {
		pilot.travel(-5.0);
		pilot.rotate(190);
	}

	public void stop() {
		pilot.stop();
	}
	
	public boolean bump(){
		return sensor.isPressed();
	}
}