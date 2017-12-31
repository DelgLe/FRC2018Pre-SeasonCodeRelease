package org.usfirst.frc.team2906.robot.subsystems;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraPivotPOV extends Subsystem {

    VictorSP versa = RobotMap.cameraPivot;

    public void rotateLeft(){
    	versa.set(-0.05);
    }
    
    public void rotateRight(){
    	versa.set(0.05);
    }
    
    public void stop(){
    	versa.set(0.0);
    }
    
    public void versaDrive(double speed){
    	versa.set(speed);
    }  
    
    public void initDefaultCommand() {
        Robot.camPiv.stop();
    }
    
}

