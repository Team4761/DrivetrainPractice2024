package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants;

public class DrivetrainSubsystem {
    // Motors
    // ONLY RUN THE FRONT MOTORS
    // THE BACK MOTORS FOLLOW THE FRONT MOTORS
    // CHECK THE CONSTRUCTOR
    CANSparkMax frontLeftMotor;
    CANSparkMax frontRightMotor;
    CANSparkMax backLeftMotor;
    CANSparkMax backRightMotor;

    DifferentialDrive drivetrain;


    // Constructor
    public DrivetrainSubsystem() {
        frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
        frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
        backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
        backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);
        backLeftMotor.follow(frontLeftMotor);
        backRightMotor.follow(frontRightMotor);

        drivetrain = new DifferentialDrive(frontLeftMotor, frontRightMotor);
    }


    /**
     * 
     * @param speedForwards A number between -1.0 and 1.0, where 1.0 is 100% power.
     * @param speedTurn A number between -1.0 and 1.0, where 1.0 is 100% power.
     */
    public void drive(double speedForwards, double speedTurn) {
        drivetrain.arcadeDrive(speedForwards, speedTurn);
    }



    // Wheels
    // main functions to run it


}
