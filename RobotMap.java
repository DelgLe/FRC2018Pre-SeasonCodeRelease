package org.usfirst.frc.team2906.robot;

import org.usfirst.frc.team2906.robot.subsystems.Pneumatics;

import com.kauailabs.navx.frc.AHRS;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static DifferentialDrive driveWC;
	public static WPI_TalonSRX driveLeft;
	public static WPI_TalonSRX driveRight;
	public static WPI_TalonSRX leftSlave;
	public static WPI_TalonSRX rightSlave;
	public static VictorSP cameraPivot;
	public static Pneumatics pneumatics;
	public static Relay visionLEDs;
	public static AHRS navX;
	public static Compressor compressor;
	//public static ADXRS450_Gyro gyro;
	public static CameraServer cam1;
	public static DoubleSolenoid pistonI;
	public static Solenoid pistonII;
	
	public static final int kGyroPort = 0;
	
	public static Encoder driveTrainEncoderLeft;
	public static Encoder driveTrainEncoderRight;

	public static int driveTrainEncoderLeftReset = 0;
	public static int driveTrainEncoderRightReset = 0;
	
	public static final double sensitivity = 0.05;
	public static final double rsensitivity = .25;
	public static final double driveMAX = 1.0;
	
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
		
		driveLeft = new WPI_TalonSRX (4);
		driveRight = new WPI_TalonSRX (1);
		leftSlave = new WPI_TalonSRX(3);
		rightSlave = new WPI_TalonSRX(2);
		
		//rightSlave.follow(driveRight);
		SpeedControllerGroup m_right = new SpeedControllerGroup(driveRight, rightSlave);
		SpeedControllerGroup m_left = new SpeedControllerGroup(driveLeft, leftSlave);
		
		//leftSlave.follow(driveLeft);
		
		cameraPivot = new VictorSP(0);
		
		visionLEDs = new Relay(0);
		
		navX = new AHRS(SPI.Port.kMXP);
		
		driveTrainEncoderLeft = new Encoder(0, 1);
		driveTrainEncoderRight = new Encoder(2, 3);
		
		driveWC = new DifferentialDrive(m_left, m_right); 
		/*driveWC.setSafetyEnabled(false);
        driveWC.setExpiration(0.1);
        driveWC.setSensitivity(sensitivity);
        driveWC.setMaxOutput(driveMAX);
        driveWC.setInvertedMotor(DifferentialDrive.MotorType.kRearLeft, true);*/
        
        compressor = new Compressor(0);
        
        pistonI = new DoubleSolenoid(0, 0, 1);
        pistonII = new Solenoid(0, 2);
        
        CameraServer server1 = CameraServer.getInstance();
        server1.startAutomaticCapture();
	}
}
