package org.usfirst.frc.team2906.robot.subsystems;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class VisionLEDs extends Subsystem {

    Relay visionLEDs = RobotMap.visionLEDs;

    public void Lon(){
    	visionLEDs.set(Relay.Value.kForward);
    }
    
    public void Loff(){
    	visionLEDs.set(Relay.Value.kOff);
    } 
    
    public void initDefaultCommand() {	
    	Robot.leds.Loff();
    }
}
