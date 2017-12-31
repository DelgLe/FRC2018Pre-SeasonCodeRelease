package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PIDDriveStraight extends Command {

	double motorSpeed = .15;
	double direction = 0;
	double currentAngle = 0;
	double distance = 0;
	double error = 0;
	double errorB = 0;
	double pAdjustment = 0;
	double iAdjustment = 0;
	double dAdjustment = 0;
	double lastError = 0;
	double PIDAdjustment = 0;

	public PIDDriveStraight(double motorSpeed, double direction, double distance) {
		this.motorSpeed = -1 * motorSpeed;
		this.direction = direction;
		this.distance = distance * RobotMap.encoderCountsLeftToIn;
		requires(Robot.driveWC);
	}

	protected void initialize() {
		Robot.driveWC.resetEncs();
		Robot.navX.resetNavX();
		dAdjustment = 0;
		if (motorSpeed > 0) {
			// iAdjustment = 0.25;
			// practiceBotForward();
		} else {
			// practiceBotBack();
		}
		iAdjustment = 0;
		pAdjustment = 0;
		error = 0;
		lastError = 0;
		PIDAdjustment = 0;
		errorB = 0;
	}

	protected void execute() {
		currentAngle = Robot.navX.getNavXAngle();
		error = direction - currentAngle;
		pAdjustment = (direction - currentAngle) * RobotMap.PIDDriveStraightP * RobotMap.PIDDriveStraightGainMultiplier;
		iAdjustment = iAdjustment + (error * RobotMap.PIDDriveStraightI * RobotMap.PIDDriveStraightGainMultiplier);
		dAdjustment = (error - lastError) * RobotMap.PIDDriveStraightD * RobotMap.PIDDriveStraightGainMultiplier;
		lastError = error;
		PIDAdjustment = pAdjustment + iAdjustment + dAdjustment;
		SmartDashboard.putNumber("d-error", error);
		SmartDashboard.putNumber("distance error", lastError);
		SmartDashboard.putNumber("travel distance", this.distance);
		SmartDashboard.putNumber("Integral", iAdjustment);
		Robot.driveWC.driveR(-(motorSpeed) - PIDAdjustment);
		Robot.driveWC.driveL(motorSpeed - PIDAdjustment);
		SmartDashboard.putNumber("IAdjustment", iAdjustment);

		/*if (error < -.5 && .5 < error) {
			Robot.driveWC.driveR(-(motorSpeed) - PIDAdjustment);
			Robot.driveWC.driveL(motorSpeed + PIDAdjustment); // .5//))))

		} else if (-.5 < error && error < .5) {
			
			Robot.driveWC.drive(-(motorSpeed*.25), (motorSpeed*.25));

		}*/

		/*
		 * if (error < 0.2) { //negative angle (less than target) errorB = -1;
		 * Robot.driveWC.driveR(-(motorSpeed) - PIDAdjustment);
		 * Robot.driveWC.driveL(-motorSpeed + (PIDAdjustment*0.1));
		 * 
		 * } else if (error > -0.2) { //positive angle (more than target) errorB
		 * = 1; Robot.driveWC.driveL(-motorSpeed - PIDAdjustment);
		 * Robot.driveWC.driveR(-motorSpeed + (PIDAdjustment*0.1));
		 * 
		 * } else{ errorB = 0;
		 */

		/*
		 * if((Math.abs(Robot.driveWC.getLSoftEnc()) < ((Math.abs(distance))))){
		 * Robot.driveWC.driveR(-(0.1)); Robot.driveWC.driveL(0.1);
		 * 
		 * }else{ Robot.driveWC.driveR(-(0.0)); Robot.driveWC.driveL(0.0); } }
		 */
		SmartDashboard.putNumber("PID Adjustment", PIDAdjustment);
		SmartDashboard.putNumber("errorB", errorB);
		SmartDashboard.putBoolean("Collission", Robot.navX.collisionDetection());
		SmartDashboard.putNumber("x velocity", Robot.navX.getXVelocity());
		SmartDashboard.putNumber("y velocity", Robot.navX.getYVelocity());
		SmartDashboard.putNumber("z velocity", Robot.navX.getZVelocity());

	}

	protected boolean isFinished() {
		return (Math.abs(Robot.driveWC.getLSoftEnc()) > ((Math.abs(distance /*- .5*/)))); // &&
																							// (Math.abs(Robot.driveWC.getLSoftEnc())
																							// <
																							// ((Math.abs(distance
																							// +
																							// .5)))));
	}

	protected void end() {
		SmartDashboard.putNumber("i", iAdjustment);
		Robot.driveWC.stop();
	}

	protected void interrupted() {
		end();
	}
}