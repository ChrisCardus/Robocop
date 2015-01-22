package exercise1.part2;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;

public class TouchSensor2 extends RobotProgrammingDemo {

	public TouchSensor2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		TouchSensor sensor = new TouchSensor(SensorPort.S1);
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A,
				Motor.B, true);
		
		Robot robocop = new Robot(pilot, sensor);
		
		while(m_run = true){
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotProgrammingDemo demo = new TouchSensor2();
		demo.run();
	}

}
