package org.usfirst.frc.team1923.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1923.robot.OI;
import org.usfirst.frc.team1923.robot.Robot;

/**
 *
 */
public class JoystickDrive extends Command {
	public JoystickDrive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveSubsys);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		if(Robot.driveSubsys.getTank())
			Robot.driveSubsys.TankDrive(OI.xbox.getY(Hand.kLeft), OI.xbox.getY(Hand.kRight));
		else
			Robot.driveSubsys.ArcadeDrive(OI.xbox.getY(Hand.kLeft), OI.xbox.getX(Hand.kRight));
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.driveSubsys.disable();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
