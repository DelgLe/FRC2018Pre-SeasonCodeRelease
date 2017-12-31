package org.usfirst.frc.team2906.robot;

import org.usfirst.frc.team2906.robot.commands.LEDsOff;
import org.usfirst.frc.team2906.robot.commands.LEDsOn;
import org.usfirst.frc.team2906.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	
	public Joystick joystick1;
	public Joystick joystick2;
	
	public JoystickButton trigr1;
	public JoystickButton trigr2;
	public JoystickBase pov;
	
	public OI(){
		joystick1 = new Joystick(0);
		joystick2 = new Joystick(1);
		
		trigr1 = new JoystickButton(joystick1, 1);
		trigr1.whileHeld(new LEDsOn());
		trigr1.whenReleased(new LEDsOff());
		
		trigr2 = new JoystickButton(joystick2, 1);
		trigr2.whileHeld(new CameraRotatePOV());
		trigr2.whenReleased(new CameraStopRotation());
		//pov = new JoystickButton(joystick1,);
	}
	public Joystick getJoystick1() {
        return joystick1;
    }
   
    public double getJoystick1X(){
    	if(Math.abs(joystick1.getX())>RobotMap.sensitivity){
    		return -1*joystick1.getX();
    	} 
    	else {
    		return 0.0;
    	}
    }
    
    public double getJoystick1Y(){
    	if(Math.abs(joystick1.getY())>RobotMap.sensitivity){
    		return -1*joystick1.getY();
    	} 
    	else {
    		return 0.0;
    	}
    }
    
    public double getJoystick1R(){
    	if(Math.abs(joystick1.getRawAxis(2))>RobotMap.sensitivity){
    		return -1*joystick1.getRawAxis(2);
    	} 
    	else {
    		return 0.0;
    	}
    }
    
    public Joystick getJoystick2(){
    	return joystick2;
    }
    public double getJoystick2Y(){
    	if(Math.abs(joystick2.getY())>RobotMap.sensitivity){
    		return .4*joystick2.getY();
    	} 
    	else {
    		return 0.0;
    	}
    }
    public double getJoystick2X(){
    	if(Math.abs(joystick2.getY())>RobotMap.sensitivity){
    		return .4*joystick2.getY();
    	} 
    	else {
    		return 0.0;
    	}
    }
    	
    	public double getJoystick1POV(){
        	if(joystick1.getPOV(0) == 0){
        		return 1.0;
        	} else if(joystick1.getPOV(0) == 90){
        		return 90;
        	} else if(joystick1.getPOV(0) == 180){
        		return -1.0;
        	}else if(joystick1.getPOV(0) == 270){
        		return -90;
        	} else if(joystick1.getPOV(0) == -1){
        		return 0.0;
        	}
        	else{
        		return 0.0;
        	}
        }
    	
    	public double getJoystick2POV(){
        	if(joystick2.getPOV(0) == 270){
        		return -10.0;
        	} else if(joystick2.getPOV(0) == 90){
        		return 10.0;
        	} else if(joystick2.getPOV(0) == 45){
        		return 0.25;
        	}else if(joystick2.getPOV(0) == 315){
        		return -0.25;
        	} else if(joystick2.getPOV(0) == -1){
        		return 0.0;
        	}
        	else{
        		return 0.0;
        	}
        }
    }



