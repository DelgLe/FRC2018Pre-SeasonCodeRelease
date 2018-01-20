package org.usfirst.frc.team2906.robot.subsystems;

import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pneumatics extends Subsystem {

	DoubleSolenoid pistonI;
	Solenoid pistonII;

	public void Extend() {
		
		pistonI.set(Value.kForward);
		pistonII.set(true);
	}

	public void Reverse() {
		
		pistonI.set(Value.kReverse);
		

	}

	public void off() {
		
		pistonI.set(Value.kOff);
		pistonII.set(false);
	}

	public void initDefaultCommand() {

		pistonI = RobotMap.pistonI;
		pistonII = RobotMap.pistonII;
	}

}
