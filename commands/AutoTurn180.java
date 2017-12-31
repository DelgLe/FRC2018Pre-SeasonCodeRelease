package org.usfirst.frc.team2906.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoTurn180 extends CommandGroup {

    public AutoTurn180() {
    	//DO NOT RESET THE NAVX DURING AN AUTO COMMAND IT WILL NOT FUNCTION PROPERLY!
    	addSequential(new WaitCommand(1.0)); 
    	addSequential(new LEDsOn());
    	addSequential(new WaitCommand(.25));
    	addSequential(new PIDNavXTurn(180));
        addSequential(new WaitCommand(.1));
        addSequential(new LEDsOff());
    }
}
