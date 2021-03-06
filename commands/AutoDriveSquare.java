package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoDriveSquare extends CommandGroup {

    public AutoDriveSquare() {
    	//addSequential(new ResetDriveEncoders()); //DO NOT RESET THE NAVX DURING AN AUTO COMMAND IT WILL NOT FUNCTION PROPERLY!
    	addSequential(new WaitCommand(0.25));
    	addSequential(new LEDsOn());
    	addSequential(new PIDDriveStraight(.25, 0, 90));
    	addSequential(new PIDNavXTurn(90));
    	addSequential(new PIDDriveStraight(.25, 0, 90));
    	addSequential(new PIDNavXTurn(90));
    	addSequential(new PIDDriveStraight(.25, 0, 90));
    	addSequential(new PIDNavXTurn(90));
    	addSequential(new PIDDriveStraight(.25, 0, 90));
    	addSequential(new PIDNavXTurn(90));
    	addSequential(new LEDsOff());
    	addSequential(new WaitCommand(.2));
    }
}
