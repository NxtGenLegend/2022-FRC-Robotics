package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.FeederSubsystem;

public class FeederCommand extends CommandBase {
    private FeederSubsystem Feeder;
    private double Speed;

    public FeederCommand(FeederSubsystem feeder, double speed){
        this.Feeder = feeder;
        this.Speed = speed;
        addRequirements(feeder);
    }

    @Override
    public void initialize(){
    }

    @Override
    public void execute(){
        Feeder.feeding(Speed);
    }

    @Override
    public void end (boolean interrupted){
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}