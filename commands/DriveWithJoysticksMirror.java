package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticksMirror extends Command {

    public DriveWithJoysticksMirror() {
    		requires(Robot.driveWC);
    	}

    	// Called just before this Command runs the first time
    	protected void initialize() {
    	}

    	// Called repeatedly when this Command is scheduled to run
    	protected void execute() {

    		if (Robot.oi.getJoystick1POV() == 0.0) {
    			Robot.driveWC.arcadeDrive(Robot.oi.getJoystick1X(), Robot.oi.getJoystick1Y());
    		/*}else if(Math.abs(Robot.oi.getJoystick1R()) <= RobotMap.rsensitivity) {
    			Robot.driveWC.arcadeDrive(Robot.oi.getJoystick1X(), Robot.oi.getJoystick1Y());
    		} else if (Robot.oi.getJoystick1R() > RobotMap.rsensitivity) {
    			Robot.driveWC.ArcadeSwingRight((Math.abs(Robot.oi.getJoystick1R()))*1*.25);
    		} else if (Robot.oi.getJoystick1R() < (RobotMap.rsensitivity*-1)){
    			Robot.driveWC.ArcadeSwingLeft((Math.abs(Robot.oi.getJoystick1R()))*-1*.25);*/
    		} else if (Robot.oi.getJoystick1POV() == 1.0){
    			Robot.driveWC.drive(-0.2, -0.2);
    		} else if (Robot.oi.getJoystick1POV() == -1.0){
    			Robot.driveWC.drive(0.2, 0.2);
    		} else if (Robot.oi.getJoystick1POV() == 90){
    			Robot.driveWC.drive(0.2, -.2);
    		} else if (Robot.oi.getJoystick1POV() == -90){	
    			Robot.driveWC.drive(-0.2, 0.2);
    		} else {
    			Robot.driveWC.stop();
    		}
    	}

    	// Make this return true when this Command no longer needs to run execute()
    	protected boolean isFinished() {
    		return false;
    	}

    	// Called once after isFinished returns true
    	protected void end() {
    	}

    	// Called when another command which requires one or more of the same
    	// subsystems is scheduled to run
    	protected void interrupted() {
    	}
    }