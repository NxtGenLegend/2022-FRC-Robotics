package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    
    private DriveSubsystem RobotDrive;
    private DoubleSupplier LeftSpeed;
    private DoubleSupplier RightSpeed;

    public DriveCommand(DriveSubsystem robotDrive, DoubleSupplier leftspeed, DoubleSupplier rightspeed){
        this.RobotDrive = robotDrive;
        this.LeftSpeed = leftspeed;
        this.RightSpeed = rightspeed;
        addRequirements(robotDrive);
    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        double LSpeed = LeftSpeed.getAsDouble();
        double RSpeed = RightSpeed.getAsDouble();
        RobotDrive.arcadeDrive(LSpeed, RSpeed);
    }

    @Override
    public void end (boolean interrupted){
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}