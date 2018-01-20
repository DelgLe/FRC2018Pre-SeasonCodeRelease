
package org.usfirst.frc.team2906.robot;

import org.usfirst.frc.team2906.robot.commands.NoAuto;
import org.usfirst.frc.team2906.robot.commands.TestAuto;
import org.usfirst.frc.team2906.robot.subsystems.CameraPivotPOV;
import org.usfirst.frc.team2906.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2906.robot.subsystems.NavX;
import org.usfirst.frc.team2906.robot.subsystems.Pneumatics;
import org.usfirst.frc.team2906.robot.subsystems.VisionLEDs;
import org.usfirst.frc.team2906.robot.commands.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static DriveTrain driveWC;
	public static CameraPivotPOV camPiv;
	public static NavX navX;
	public static Pneumatics pneumatics;
	//public static gAngleSPI gyro;
	public static VisionLEDs leds;
	public static OI oi;

	Command autonomousCommand;
	Command NoAuto;
	Command TestAuto;
	Command AutoDriveStraight;
	Command AutoTurn90;
	Command AutoTurn180;
	Command AutoDriveTurnDrive;
	Command Auto20InchTest;
	Command Auto20InchTestReturn;

	SendableChooser<Command> autoChooser = new SendableChooser<>();

	final String noAuto = "No Auto";
	final String testAuto = "Test Auto";
	final String autoDriveStraight = "Drive Straight PID Auto";
	final String autoDriveSquare = "Drive Square Auto";
	final String autoTurn90 = "Turn 90 Degrees";
	final String autoTurn180 = "Turn 180 Degrees";
	final String autoDriveTurnDrive = "Drive Turn Drive";
	final String auto20InchTest = "Drive 20 Inches For Testable Data";
	final String auto20InchTestReturn = "Return To Start For Re-Test";

	//String[] autoChooserList = { noAuto, testAuto, autoDriveStraight, autoDriveSquare, autoTurn90, autoTurn180, autoDriveTurnDrive, auto20InchTest, auto20InchTestReturn };

	@Override
	public void robotInit() {
		RobotMap.init();

		driveWC = new DriveTrain();
		camPiv = new CameraPivotPOV();
		navX = new NavX();
		pneumatics = new Pneumatics();
		//gyro = new gAngleSPI();
		leds = new VisionLEDs();
		oi = new OI();

		NetworkTable table = NetworkTable.getTable("SmartDashboard");
		table.putStringArray("Auto List", autoChooserList);

		//autoChooser = new SendableChooser();
		autoChooser.addDefault("Default, No Auto", new NoAuto());
		autoChooser.addObject("Test Auto", new TestAuto());
		autoChooser.addObject("Drive Straight PID Auto", new AutoDriveStraight());
		autoChooser.addObject("Drive Square", new AutoDriveSquare());
		autoChooser.addObject("Turn 90", new AutoTurn90());
		autoChooser.addObject("Turn 180", new AutoTurn180());
		autoChooser.addObject("Drive Turn Drive", new AutoDriveTurnDrive());
		autoChooser.addObject("Drive 20 Inches For Testable Data", new Auto20InchTest());
		autoChooser.addObject("Return To Start For Re-Test", new Auto20InchTestReturn());

		SmartDashboard.putData("Auto mode", autoChooser);
		
		SmartDashboard.putData("TurnTeleTest", new AutoTurn90());
		
		NetworkTable table = NetworkTable.getTable("limelight");
		double targetOffsetAngle_Horizontal = table.getNumber("tx", 0);
		double targetOffsetAngle_Vertical = table.getNumber("ty", 0);
		double targetArea = table.getNumber("ta", 0);
		double targetSkew = table.getNumber("ts", 0);
		
		
	}

	@Override
	public void disabledInit() {
		Robot.driveWC.resetEncs();
		Robot.navX.resetNavX();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		Robot.driveWC.resetEncs();
	}

	@Override
	public void autonomousInit() {
		//Robot.driveWC.resetEncs();
		autonomousCommand = (Command) autoChooser.getSelected();
	    System.out.println("Auto selected: " + autoChooser.getSelected());
	    SmartDashboard.putNumber("navx angle", RobotMap.navX.getAngle());
	   

		

		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", driveWC.getLHardEnc());
		SmartDashboard.putNumber("Right Encoder", driveWC.getRHardEnc());
		SmartDashboard.putNumber("Left Voltage", driveWC.getVoltageL());
		SmartDashboard.putNumber("Right Voltage", driveWC.getVoltageR());
		SmartDashboard.putNumber("navx angle", RobotMap.navX.getAngle());
		SmartDashboard.putNumber("navx pitch", RobotMap.navX.getPitch());
		SmartDashboard.putNumber("navx roll", RobotMap.navX.getRoll());
		SmartDashboard.putNumber("navx yaw", RobotMap.navX.getYaw());
	}

	@Override
	public void teleopInit() {
		//Robot.driveWC.resetEncs();
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Left Encoder", driveWC.getLHardEnc());
		SmartDashboard.putNumber("Right Encoder", driveWC.getRHardEnc());
		SmartDashboard.putNumber("Left Voltage", driveWC.getVoltageL());
		SmartDashboard.putNumber("Right Voltage", driveWC.getVoltageR());
		SmartDashboard.putNumber("navx angle", RobotMap.navX.getAngle());
		SmartDashboard.putNumber("navx pitch", RobotMap.navX.getPitch());
		SmartDashboard.putNumber("navx roll", RobotMap.navX.getRoll());
		SmartDashboard.putNumber("navx yaw", RobotMap.navX.getYaw());
		SmartDashboard.putBoolean("Collission", Robot.navX.collisionDetection());
		SmartDashboard.putNumber("x velocity", Robot.navX.getXVelocity());
		SmartDashboard.putNumber("y velocity", Robot.navX.getYVelocity());
		SmartDashboard.putNumber("z velocity", Robot.navX.getZVelocity());
		//SmartDashboard.putNumber("Gyro angle", RobotMap.gAngle);

	}

	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
