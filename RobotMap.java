package org.usfirst.frc.team2906.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static RobotDrive driveWC;
	public static CANTalon driveLeft;
	public static CANTalon driveRight;
	public static CANTalon leftSlave;
	public static CANTalon rightSlave;
	public static VictorSP cameraPivot;
	public static Relay visionLEDs;
	public static AHRS navX;
	//public static ADXRS450_Gyro gyro;
	public static CameraServer cam1;
	
	public static final int kGyroPort = 0;
	
	public static Encoder driveTrainEncoderLeft;
	public static Encoder driveTrainEncoderRight;

	public static int driveTrainEncoderLeftReset = 0;
	public static int driveTrainEncoderRightReset = 0;
	
	public static final double sensitivity = 0.05;
	public static final double rsensitivity = .25;
	public static final double driveMAX = 0.2;
	
	public static final double PIDNavxTurnGainMultiplier = 0.1;
	public static final double PIDNavxTurnP = 0.5;
	public static final double PIDNavxTurnI = 0.03;
	public static final double PIDNavxTurnD = 0.5;
	
	public static final double PIDDriveStraightGainMultiplier = 0.03; //.03
	public static final double PIDDriveStraightP = 0.45; //.45 //1.0 (12/23)
	public static final double PIDDriveStraightI = 0.015; //.015 //1.0 (12/23)
	public static final double PIDDriveStraightD = 0.011; //.011 //3.0 (12/23) //8.0(12/23-2)
	
	
	public static final double encoderCountsLeftToIn = 27.851497;//27.675; //29.07(12/23) //27.851497(12-24)
	public static final double encoderCountsRightToIn = 27.851497;
	
	public static void init(){
		
		driveLeft = new CANTalon (4);
		driveRight = new CANTalon (1);
		leftSlave = new CANTalon(3);
		rightSlave = new CANTalon(2);
		
		rightSlave.changeControlMode(TalonControlMode.Follower);
		rightSlave.set(1);
		
		leftSlave.changeControlMode(TalonControlMode.Follower);
		leftSlave.set(4);
		
		cameraPivot = new VictorSP(0);
		
		visionLEDs = new Relay(0);
		
		navX = new AHRS(SPI.Port.kMXP);
		
		driveTrainEncoderLeft = new Encoder(0, 1);
		driveTrainEncoderRight = new Encoder(2, 3);
		
		driveWC = new RobotDrive(driveLeft, driveRight);
		driveWC.setSafetyEnabled(false);
        driveWC.setExpiration(0.1);
        driveWC.setSensitivity(sensitivity);
        driveWC.setMaxOutput(driveMAX);
        driveWC.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        
        CameraServer server1 = CameraServer.getInstance();
        server1.startAutomaticCapture();
	}
}
