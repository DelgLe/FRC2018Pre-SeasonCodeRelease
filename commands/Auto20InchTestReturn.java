package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class Auto20InchTestReturn extends CommandGroup {

    public Auto20InchTestReturn() {
    	//addSequential(new ResetDriveEncoders()); //DO NOT RESET THE NAVX DURING AN AUTO COMMAND IT WILL NOT FUNCTION PROPERLY!
    	addSequential(new WaitCommand(0.25));
    	addSequential(new LEDsOn());
    	addSequential(new PIDNavXTurn(180));
    	addSequential(new PIDDriveStraight(0.15, 0, 20));
    	addSequential(new PIDNavXTurn(180));
    	addSequential(new LEDsOff());
    	addSequential(new WaitCommand(.2));
    }
}
