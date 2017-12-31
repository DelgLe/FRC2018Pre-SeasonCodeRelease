package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTurn90 extends CommandGroup {

    public AutoTurn90() {
    	//addSequential(new ResetDriveEncoders());//DO NOT RESET THE NAVX DURING AN AUTO COMMAND IT WILL NOT FUNCTION PROPERLY!
    	addSequential(new WaitCommand(1.0)); 
    	addSequential(new LEDsOn());
    	addSequential(new WaitCommand(.25));
    	addSequential(new PIDNavXTurn(90));
        addSequential(new WaitCommand(.1));
        addSequential(new LEDsOff());
    }
}
