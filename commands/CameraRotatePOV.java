package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CameraRotatePOV extends Command {

	public CameraRotatePOV() {
		requires(Robot.camPiv);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.getJoystick2POV() == 0.0) {
			Robot.camPiv.stop();
		} else if (Robot.oi.getJoystick2POV() == 10.0) {
			Robot.camPiv.versaDrive(0.2);
		} else if (Robot.oi.getJoystick2POV() == -10.0) {
			Robot.camPiv.versaDrive(-0.2);
		} else if (Robot.oi.getJoystick2POV() == 0.25) {
			Robot.camPiv.versaDrive(0.5);
		} else if (Robot.oi.getJoystick2POV() == -0.25) {
			Robot.camPiv.versaDrive(-0.5);
		} else {
			Robot.camPiv.stop();
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
