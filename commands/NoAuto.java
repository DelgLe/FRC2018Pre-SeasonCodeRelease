package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class NoAuto extends CommandGroup {

    public NoAuto() {
    	//addSequential(new ResetDriveEncoders()); //DO NOT RESET THE NAVX DURING AN AUTO COMMAND IT WILL NOT FUNCTION PROPERLY!
    	addSequential(new WaitCommand(0.1));
    	addSequential(new WaitCommand(0.1));
    	addSequential(new LEDsOn());
        addSequential(new WaitCommand(.1));
        addSequential(new LEDsOff());
        addSequential(new WaitCommand(0.25));
    	addSequential(new LEDsOn());
        addSequential(new WaitCommand(.1));
        addSequential(new LEDsOff());
    }
}
