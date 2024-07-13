// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class ElevatorSubsystem extends SubsystemBase {
  /** Creates a new ElevatorSubsystem. */

  private final VictorSP StraightElevator = new VictorSP(MotorConstants.PrimaryElevator);
  private final VictorSP AngledElevator = new VictorSP(MotorConstants.SecondaryElevator);

  public ElevatorSubsystem() {}

  public void Straight(double speed){
    StraightElevator.set(speed);
  }

  public void Angled(double speed){
    AngledElevator.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}