// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class FeederSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */

  private final WPI_TalonSRX feeder = new WPI_TalonSRX(MotorConstants.Feeder);

  public FeederSubsystem() {}

  public void feeding(double Speed){
    feeder.set(Speed);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}