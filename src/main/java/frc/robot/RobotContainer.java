// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.*;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.JoystickConstants;
import frc.robot.Constants.SpeedConstants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Joystick DriveStick = new Joystick(Constants.JoystickConstants.PrimaryStick);
  private final Joystick SystemsStick = new Joystick(Constants.JoystickConstants.SecondaryStick);
  
  private final DriveSubsystem RobotDrive = new DriveSubsystem();
  private final ElevatorSubsystem Elevator = new ElevatorSubsystem();
  private final ShooterSubsystem Shooter = new ShooterSubsystem();
  private final IntakeSubsystem Intake = new IntakeSubsystem();
  private final FeederSubsystem Feeder = new FeederSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings

    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    new JoystickButton(DriveStick, JoystickConstants.Brake).whenPressed(() -> RobotDrive.arcadeDrive(0, 0));
    new JoystickButton(DriveStick, JoystickConstants.Boost).whenPressed(() -> RobotDrive.SetMax(1)).whenReleased(() -> RobotDrive.SetMax(0.8));
    new JoystickButton(DriveStick, JoystickConstants.Intake).whenPressed(new IntakeCommand(Intake, SpeedConstants.IntakeSpeed)).whenReleased(new IntakeCommand(Intake, 0));
    new JoystickButton(DriveStick, JoystickConstants.Outtake).whenPressed(new IntakeCommand(Intake, -SpeedConstants.IntakeSpeed)).whenReleased(new IntakeCommand(Intake, 0));
    new JoystickButton(SystemsStick, JoystickConstants.StraightElevatorUp).whenPressed(new StraightElevatorCommand(Elevator, SpeedConstants.ElevatorSpeed)).whenReleased(new StraightElevatorCommand(Elevator, 0));
    new JoystickButton(SystemsStick, JoystickConstants.StraightElevatorDown).whenPressed(new StraightElevatorCommand(Elevator, -SpeedConstants.ElevatorSpeed)).whenReleased(new StraightElevatorCommand(Elevator, 0));
    new JoystickButton(SystemsStick, JoystickConstants.AngledElevatorUp).whenPressed(new AngledElevatorCommand(Elevator, SpeedConstants.ElevatorSpeed)).whenReleased(new AngledElevatorCommand(Elevator, 0));
    new JoystickButton(SystemsStick, JoystickConstants.AngledElevatorDown).whenPressed(new AngledElevatorCommand(Elevator, -SpeedConstants.ElevatorSpeed)).whenReleased(new AngledElevatorCommand(Elevator, 0));
    new JoystickButton(SystemsStick, JoystickConstants.FeedIn).whenPressed(new FeederCommand(Feeder, SpeedConstants.FeedSpeed)).whenReleased(new FeederCommand(Feeder, 0));
    new JoystickButton(SystemsStick, JoystickConstants.FeedOut).whenPressed(new FeederCommand(Feeder, -SpeedConstants.FeedSpeed)).whenReleased(new FeederCommand(Feeder, 0));
    
    new JoystickButton(SystemsStick, JoystickConstants.Shoot).whenPressed(new ShooterCommand(Shooter, -SpeedConstants.TrajectoryModel)).whenReleased(new ShooterCommand(Shooter, 0));

    RobotDrive.setDefaultCommand(new DriveCommand (RobotDrive, () -> DriveStick.getY()*0.8, () -> DriveStick.getZ()*0.8));
    //Elevator.setDefaultCommand(new StraightElevatorCommand (Elevator, false, false));
    //Elevator.setDefaultCommand(new AngledElevatorCommand (Elevator, false, false));
    //Intake.setDefaultCommand(new IntakeCommand (Intake, false, false));
    //Feeder.setDefaultCommand(new FeederCommand (Feeder, false, false));
    //Shooter.setDefaultCommand(new ShooterCommand (Shooter, false));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
    //m_autoCommand;
  }
}
