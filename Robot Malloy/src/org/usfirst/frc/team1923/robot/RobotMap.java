package org.usfirst.frc.team1923.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	public static final int XBOX_CONTROLLER_PORT=0;
	
	public static final int RIGHT_DRIVE_TALON1=1;
	public static final int RIGHT_DRIVE_TALON2=2;
	public static final int RIGHT_DRIVE_TALON3=3;
	
	public static final int LEFT_DRIVE_TALON1=4;
	public static final int LEFT_DRIVE_TALON2=5;
	public static final int LEFT_DRIVE_TALON3=6;

	//Vision
	public static final double TURN_CONSTANT = 1000;
	public static final int IMG_WIDTH = 320;
	public static final int IMG_HEIGHT = 240;
	public static final String CAMERA_IP = "10.19.23.15";
	
	
}