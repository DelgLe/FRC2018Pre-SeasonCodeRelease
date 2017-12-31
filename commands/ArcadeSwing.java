package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeSwing extends Command {

    public ArcadeSwing() {
        requires(Robot.driveWC);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(/*add nullifier here for when there is any other joystick value: Math.abs(Robot.oi.getJoystick1X() || Robot.oi.getJoystick1Y()) < 0.0) &&*/ Robot.oi.getJoystick1R()<(RobotMap.sensitivity*-1)) {
    		Robot.driveWC.ArcadeSwingLeft(Math.abs(Robot.oi.getJoystick1R()));
    		
    	} else if(/*add nullifier here for when there is any other joystick value: (math.abs(joy1X || joy1Y) < 0.0) &&*/Robot.oi.getJoystick1R()>RobotMap.sensitivity) {
    		Robot.driveWC.ArcadeSwingRight(Math.abs(Robot.oi.getJoystick1R()));
    		
    	}else {
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
