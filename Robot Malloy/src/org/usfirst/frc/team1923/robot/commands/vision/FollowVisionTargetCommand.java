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

public class FollowVisionTargetCommand extends Command {

    public double power, turn;
    boolean feeder = false, aligned;
    public double stoppingDist;

    public FollowVisionTargetCommand() {
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

        if (Robot.visionSubsys.gearTurn < -1) {
            power = 0;
            turn = 0;
            Robot.visionSubsys.found = false;
        } else {
            if (Robot.visionSubsys.dist >= 30) {
                power = 0.4;
            } else {
                power = 0.2;
            }

            Robot.visionSubsys.found = true;
            turn = Robot.visionSubsys.gearTurn;
        }

        SmartDashboard.putNumber("Power", power);
        Robot.driveSubsys.ArcadeDrive(power, turn);


        SmartDashboard.putBoolean("Found: ", Robot.visionSubsys.found);
    }

    @Override
    protected boolean isFinished() {
        return Robot.visionSubsys.dist <= stoppingDist;
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
