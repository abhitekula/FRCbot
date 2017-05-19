package org.usfirst.frc.team1923.robot.commands;

import org.usfirst.frc.team1923.robot.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class SetDriveMode extends InstantCommand {
	
	private boolean tank;

    public SetDriveMode(boolean tank) {
        super();
        this.tank=tank;
    	requires(Robot.driveSubsys);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.driveSubsys.setTank(tank);
    }

}
