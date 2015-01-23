package exercise1.part2;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import lejos.nxt.TouchSensor;
import lejos.robotics.navigation.DifferentialPilot;
import rp.systems.Robot;
import rp.systems.RobotProgrammingDemo;

public class TouchSensor2 extends RobotProgrammingDemo {

	private boolean pressed = false;
	
	public TouchSensor2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f, Motor.A,
				Motor.B, false);
		Robot robocop = new Robot(pilot);
		
		SensorPort.S1.addSensorPortListener(new SensorPortListener(){
	
			@Override
			public void stateChanged(SensorPort aSource, int aOldValue,
					int aNewValue) {
				// TODO Auto-generated method stub
				if(aNewValue <= (aOldValue - 600)){
					pressed = true;
				}
			}
		} );
				
		while(m_run = true){
			robocop.forward();
			if(pressed){
				robocop.turn();
				pressed = false;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotProgrammingDemo demo = new TouchSensor2();
		demo.run();
	}

}
