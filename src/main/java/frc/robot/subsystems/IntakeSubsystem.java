// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */

  private final WPI_TalonSRX intaker = new WPI_TalonSRX(MotorConstants.Intake);

  public IntakeSubsystem() {}

  public void intaking(double speed){
    intaker.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
