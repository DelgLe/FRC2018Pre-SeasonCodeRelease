package org.usfirst.frc.team2906.robot.commands;

import org.usfirst.frc.team2906.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoDriveStraight extends CommandGroup {

    public AutoDriveStraight() {
    	//addSequential(new ResetDriveEncoders());
    	addSequential(new WaitCommand(0.25)); //DO NOT RESET THE NAVX DURING AN AUTO COMMAND IT WILL NOT FUNCTION PROPERLY! MUST MANUALLY DO IT EVERYTIME FOR ACCURACY!
    	addSequential(new LEDsOn());
    	addSequential(new PIDDriveStraight(.15, 0, 20));
    	addSequential(new WaitCommand(0.25));
    	addSequential(new LEDsOff());
    }
}
