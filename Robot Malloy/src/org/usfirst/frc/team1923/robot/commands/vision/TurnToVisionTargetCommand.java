package org.usfirst.frc.team1923.robot.commands.vision;

import org.usfirst.frc.team1923.robot.Robot;
import org.usfirst.frc.team1923.robot.RobotMap;

// import com.sun.webkit.Timer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This commands aligns the Robot with the peg or the feeder (depending on
 * boolean passed by constructor)
 *
 * @author Abhinav
 */

public class TurnToVisionTargetCommand extends Command {

    public double power, turn;
    boolean feeder = false, aligned;
    public double stoppingDist;

    public TurnToVisionTargetCommand() {
        requires(Robot.visionSubsys);
        requires(Robot.driveSubsys);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        // TODO: Change power value to account for distance

        Robot.visionSubsys.refresh();

        if (Robot.visionSubsys.turn < -1) {
            turn = 0;
            Robot.visionSubsys.found = false;
        } else {

            Robot.visionSubsys.found = true;
            turn = Robot.visionSubsys.turn;
        }

        SmartDashboard.putNumber("Power", power);

        Robot.driveSubsys.ArcadeDrive(0, turn);

        SmartDashboard.putBoolean("Found: ", Robot.visionSubsys.found);
        SmartDashboard.putBoolean("Aligned and Ready to Drop: ", aligned);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.driveSubsys.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
