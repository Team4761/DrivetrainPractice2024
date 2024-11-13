package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;

public class GoodbyeWorldCommand extends Command {
    
    @Override
    public void initialize() {
        System.out.println("Goodbye World");
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}
