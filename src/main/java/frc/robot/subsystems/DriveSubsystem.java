// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;
import com.kauailabs.navx.frc.AHRS;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */

  private final WPI_TalonSRX FrontLeft = new WPI_TalonSRX(MotorConstants.LeftFront);
  private final WPI_TalonSRX BackLeft = new WPI_TalonSRX(MotorConstants.LeftBack);
  private final WPI_TalonSRX FrontRight = new WPI_TalonSRX(MotorConstants.RightFront);
  private final WPI_TalonSRX BackRight = new WPI_TalonSRX(MotorConstants.RightBack);

  private final AHRS NavX = new AHRS();

  private final MotorControllerGroup LeftGroup = new MotorControllerGroup(FrontLeft, BackLeft);
  private final MotorControllerGroup RightGroup = new MotorControllerGroup(FrontRight, BackRight);
  
  private final DifferentialDrive Drive = new DifferentialDrive(LeftGroup, RightGroup);

  public DriveSubsystem() {
    FrontLeft.configFactoryDefault();
    BackLeft.configFactoryDefault();
    FrontRight.configFactoryDefault();
    BackRight.configFactoryDefault();

    RightGroup.setInverted(true);
  }

  public void arcadeDrive(double leftSpeed, double rightSpeed){
    Drive.arcadeDrive(leftSpeed, rightSpeed);
  }

  public void SetMax(double Max){
    Drive.setMaxOutput(Max);
  }

  public double getHeading(){
    return NavX.getCompassHeading();
  }

  public double getXAngle(){
    return NavX.getRawGyroX();
  }

  public double getYAngle(){
    return NavX.getRawGyroY();
  }

  public double getZAngle(){
    return NavX.getRawGyroZ();
  }

  public double getPitch(){
    return NavX.getPitch();
  }

  public double getYaw(){
    return NavX.getYaw();
  }

  public double getRoll(){
    return NavX.getRoll();
  }
  
  public double getXAcceleration(){
    return NavX.getWorldLinearAccelX();
  }

  public double getYAcceleration(){
    return NavX.getWorldLinearAccelY();
  }

  public double getZAcceleration(){
    return NavX.getWorldLinearAccelZ();
  }

  public double getLeftVelocity(){
    return BackLeft.getSelectedSensorVelocity();
  }

  public double getRightVelocity(){
    return FrontRight.getSelectedSensorVelocity();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Compass Heading", this.getHeading());
    SmartDashboard.putNumber("X Axis", this.getXAngle());
    SmartDashboard.putNumber("Y Axis", this.getYAngle());
    SmartDashboard.putNumber("Z Axis", this.getYAngle());
    SmartDashboard.putNumber("FrontRight Velocity", this.getRightVelocity());
    SmartDashboard.putNumber("BackLeft Velocity", this.getLeftVelocity());
    SmartDashboard.putNumber("X Acceleration", this.getXAcceleration());
    SmartDashboard.putNumber("Y Acceleration", this.getYAcceleration());
    SmartDashboard.putNumber("Z Acceleration", this.getZAcceleration());
    SmartDashboard.putNumber("Pitch", this.getPitch());
    SmartDashboard.putNumber("Yaw", this.getYaw());
    SmartDashboard.putNumber("Roll", this.getRoll());
  }
}