package org.usfirst.frc.team2906.robot.subsystems;

import org.usfirst.frc.team2906.robot.Robot;
import org.usfirst.frc.team2906.robot.RobotMap;
import org.usfirst.frc.team2906.robot.commands.ArcadeSwing;
import org.usfirst.frc.team2906.robot.commands.DriveWithJoysticksArcade;
import org.usfirst.frc.team2906.robot.commands.DriveWithJoysticksMirror;

import com.ctre.CANTalon;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	private final DifferentialDrive driveWC = RobotMap.driveWC;

	WPI_TalonSRX left = RobotMap.driveLeft;
	WPI_TalonSRX right = RobotMap.driveRight;

	Encoder driveTrainEncoderLeft = RobotMap.driveTrainEncoderLeft;
	Encoder driveTrainEncoderRight = RobotMap.driveTrainEncoderRight;

	public DriveTrain() {
		driveTrainEncoderLeft.reset();
		driveTrainEncoderRight.reset();
	}

	public void resetRHardEnc() {
		driveTrainEncoderRight.reset();
	}

	public void resetLHardEnc() {
		driveTrainEncoderLeft.reset();
	}

	public void resetEncs() {
		driveTrainEncoderLeft.reset();
		driveTrainEncoderRight.reset();
	}

	public int getRSoftEnc() {
		return driveTrainEncoderRight.get() - RobotMap.driveTrainEncoderRightReset;
	}

	public int getLSoftEnc() {
		return driveTrainEncoderLeft.get() - RobotMap.driveTrainEncoderLeftReset;
	}

	public int getRHardEnc() {
		return driveTrainEncoderRight.get();
	}

	public int getLHardEnc() {
		return driveTrainEncoderLeft.get();
	}

	public void softResetR() {
		RobotMap.driveTrainEncoderRightReset = getRHardEnc();

	}

	public void softResetL() {
		RobotMap.driveTrainEncoderLeftReset = getLHardEnc();
	}

	public void drive(double RMotor, double LMotor) {
		right.set(RMotor);
		left.set(LMotor);
	}

	public void driveR(double RMotor) {
		right.set(-RMotor);
	}

	public void driveL(double LMotor) {
		left.set(LMotor);
	}

	public void stopR() {
		right.set(0);
	}

	public void stopL() {
		left.set(0);
	}

	public void stop() {
		left.set(0);
		right.set(0);
	}
	
	public void arcadeDrive(double xSpeed, double zRotate){
		driveWC.arcadeDrive(xSpeed, zRotate);
	}
	
	public void tankDrive(double left, double right){
		driveWC.tankDrive(left, right);
	}
	
	public void ArcadeSwingLeft(double swing){
		Robot.driveWC.driveL(swing);
		Robot.driveWC.stopR();
	}
	
	public void ArcadeSwingRight(double swing){
		Robot.driveWC.driveR(swing);
		Robot.driveWC.stopL();
	}
	
	public void mirrorDrive(double speedMultiplier){
		Robot.driveWC.driveL(speedMultiplier);
		Robot.driveWC.driveR(speedMultiplier);
	}
	
	public double getVoltageL(){
		return left.getMotorOutputVoltage();
	}
	
	public double getVoltageR(){
		return right.getMotorOutputVoltage();
	}

	public void initDefaultCommand() {
		//setDefaultCommand(new DriveWithJoysticksArcade());
		//setDefaultCommand(new DriveWithJoysticksTank());
		setDefaultCommand(new DriveWithJoysticksMirror());
	}

	public void checkCurrent() {

	}

}