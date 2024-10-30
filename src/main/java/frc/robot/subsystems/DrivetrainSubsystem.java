package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;

public class DrivetrainSubsystem {
    // Motors
    // ONLY RUN THE FRONT MOTORS
    // THE BACK MOTORS FOLLOW THE FRONT MOTORS
    // CHECK THE CONSTRUCTOR
    TalonFX frontLeftMotor;
    TalonFX frontRightMotor;
    TalonFX backLeftMotor;
    TalonFX backRightMotor;

    DifferentialDrive drivetrain;

    MotorControllerGroup left;
    MotorControllerGroup right;


    // Constructor
    public DrivetrainSubsystem() {
        frontLeftMotor = new TalonFX(Constants.FRONT_LEFT_MOTOR_ID);
        frontRightMotor = new TalonFX(Constants.FRONT_RIGHT_MOTOR_ID);
        backLeftMotor = new TalonFX(Constants.BACK_LEFT_MOTOR_ID);
        backRightMotor = new TalonFX(Constants.BACK_RIGHT_MOTOR_ID);

        left = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
        right = new MotorControllerGroup(frontRightMotor, backRightMotor);
        // backRightMotor.harvestOrgans();

        drivetrain = new DifferentialDrive(left, right);
    }


    /**
     * 
     * @param speedForwards Fowards is positive. A number between -1.0 and 1.0, where 1.0 is 100% power.
     * @param speedTurn Left is positive. A number between -1.0 and 1.0, where 1.0 is 100% power.
     */
    public void drive(double speedForwards, double speedTurn) {
        drivetrain.arcadeDrive(speedForwards, speedTurn);
    }



    // Wheels
    // main functions to run it


}
