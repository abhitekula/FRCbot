package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;
import org.usfirst.frc.team1923.robot.commands.JoystickDrive;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	private Talon right1, right2, right3;
	private Talon left1, left2, left3;
	
	public DriveSubsystem(){
		right1= new Talon(RobotMap.RIGHT_DRIVE_TALON1);
		right2= new Talon(RobotMap.RIGHT_DRIVE_TALON2);
		right3= new Talon(RobotMap.RIGHT_DRIVE_TALON3);
		
		left1= new Talon(RobotMap.LEFT_DRIVE_TALON1);
		left2= new Talon(RobotMap.LEFT_DRIVE_TALON2);
		left3= new Talon(RobotMap.LEFT_DRIVE_TALON3);
		
		right1.setInverted(true);
		right2.setInverted(true);
		right3.setInverted(true);

	}
	
	public void disable(){
		right1.disable();
		right2.disable();
		right3.disable();
		
		left1.disable();
		left2.disable();
		left3.disable();
	}
	
	public void TankDrive(double right, double left){
		right1.set(right);
		right2.set(right);
		right3.set(right);
		
		left1.set(left);
		left2.set(left);
		left3.set(left);
		
	}
	
	public void ArcadeDrive(double power, double turn){
		right1.set(power - turn);
		right2.set(power - turn);
		right3.set(power - turn);
		
		left1.set(power + turn);
		left2.set(power + turn);
		left3.set(power + turn);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new JoystickDrive());
	}
}
