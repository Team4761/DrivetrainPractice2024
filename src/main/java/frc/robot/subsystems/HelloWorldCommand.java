package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;

public class HelloWorldCommand extends Command {
    
    @Override
    public void initialize() {
        System.out.println("Hello World");
    }


    @Override
    public boolean isFinished() {
        return true;
    }
}
