package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class StraightElevatorCommand extends CommandBase {
    private ElevatorSubsystem Elevator;
    private double Speed;

    public StraightElevatorCommand(ElevatorSubsystem elevator, double speed){
        this.Elevator = elevator;
        this.Speed = speed;
        addRequirements(elevator);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){
        Elevator.Straight(Speed);
    }
        
    @Override
    public void end (boolean interrupted){
    }

    @Override
    public boolean isFinished(){
        return false;
    }
   
}