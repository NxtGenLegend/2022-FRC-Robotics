package frc.robot;

// the date is 16th March and Aarav is absent

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final class JoystickConstants {
        public static final int PrimaryStick = 0;
        public static final int Brake = 1;
        public static final int Boost = 2;
        public static final int Intake = 3;
        public static final int Outtake = 4;

        public static final int SecondaryStick = 1;
        public static final int StraightElevatorUp = 8;
        public static final int StraightElevatorDown = 7;
        public static final int AngledElevatorUp = 10;
        public static final int AngledElevatorDown = 9;
        public static final int FeedIn = 4;
        public static final int FeedOut = 6;
        public static final int Shoot = 1;

        // Add New Joystick Axis For US (POV)
    }

    public final class MotorConstants{
        public static final int LeftFront = 1;
        public static final int LeftBack = 2;
        public static final int RightFront = 3;
        public static final int RightBack = 4;

        public static final int Shooter = 7;
        public static final int Feeder = 5;
        public static final int Intake = 8;

        public static final int PrimaryElevator = 1;
        public static final int SecondaryElevator = 2;

    }

    public final class SpeedConstants{
        public static final double DriveSpeed = 0.8;

        public static final double IntakeSpeed = 0.5;
        public static final double FeedSpeed = 0.5;

        public static final double TrajectoryModel = 1;

        public static final double ElevatorSpeed = 0.4;
    }
}
