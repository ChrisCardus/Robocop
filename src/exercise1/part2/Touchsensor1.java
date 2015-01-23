package exercise1.part2;

import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Button;

public class Touchsensor1 extends RobotProgrammingDemo {

	public Touchsensor1() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		TouchSensor sensor = new TouchSensor(SensorPort.S1);
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A,
				Motor.B, false);
		
		Robot robocop = new Robot(pilot);

		Button.waitForAnyPress();
		while(m_run = true){
			robocop.forward();
			if(robocop.bump()){
				robocop.turn();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotProgrammingDemo demo = new Touchsensor1();
		demo.run();
	}

}
