package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;

import frc.robot.Robot;

public class MoveCommand extends Command {
    double speedForwards;
    double speedTurn;

    long endTime;
    public MoveCommand(double speedForwards, double speedTurn) {
        this.speedForwards = speedForwards;
        this.speedTurn = speedTurn;
    }
    
    @Override
    public void initialize() {
        addRequirements(Robot.map.drivetrain);
        // 2 seconds
        endTime = System.currentTimeMillis() + 2000;
    }


    @Override
    public void execute() {
        Robot.map.drivetrain.drive(speedForwards, speedTurn);
    }


    @Override
    public void end(boolean isInterrupted) {
        // Stop the robot
        Robot.map.drivetrain.drive(0,0);
    }


    @Override
    public boolean isFinished() {
        if (System.currentTimeMillis() >= endTime) {
            return true;
        }
        return false;
    }
}
