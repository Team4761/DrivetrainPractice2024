package frc.robot.subsystems.skrrrIt;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkAbsoluteEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

public class SkrrrItDriveModule {
    
    // skrrrotate rotates the wheel (crazy). skrrree moves the wheel.
    CANSparkMax skrrrotate;
    CANSparkMax skrrree;

    // Encoders tell us how many rotations the motor has done
    SparkAbsoluteEncoder skrrrotato;
    SparkAbsoluteEncoder skrrretato;

    // skrrrinventor is for movement. coolerSkrrrinventor is for turning the wheels.
    // PLEASE FOR THE LOVE OF GOD TUNE THESE
    // As a reminder, P = speed based off of distance, I = speed based on time, D = speed based on current speed
    PIDController skrrrinventor = new PIDController(1, 0, 0);
    // Same as a normal PID controller, but it has a max speed (and it's cooler).
    // Max speed = 180 degrees / second. Max acceleration = 360 degrees / second.
    ProfiledPIDController coolerSkrrrinventor = new ProfiledPIDController(1, 0, 0, new TrapezoidProfile.Constraints(Units.degreesToRadians(180), Units.degreesToRadians(360)));


    /**
     * 
     * @param skrrrotateID CAN ID
     * @param skrrreeID CAN ID
     */
    public SkrrrItDriveModule(int skrrrotateID, int skrrreeID) {
        skrrrotate = new CANSparkMax(skrrrotateID, MotorType.kBrushless);
        skrrree = new CANSparkMax(skrrreeID, MotorType.kBrushless);

        // Good luck.
        skrrrotato = skrrrotate.getAbsoluteEncoder();
        skrrretato = skrrree.getAbsoluteEncoder();

        final double GEAR_RATIO = 10;
        final double TICKS_PER_ROTATION = 4096;
        final double CIRCUMFERENCE_OF_WHEEL = 0.20; // in meters
        // Make skrrrotato give distance travelled in meters when read.
        skrrrotato.setPositionConversionFactor(Units.degreesToRadians(360) / GEAR_RATIO / TICKS_PER_ROTATION);
        skrrrotato.setVelocityConversionFactor(Units.degreesToRadians(360) / GEAR_RATIO / TICKS_PER_ROTATION);

        skrrretato.setPositionConversionFactor(CIRCUMFERENCE_OF_WHEEL / GEAR_RATIO / TICKS_PER_ROTATION);
        skrrretato.setVelocityConversionFactor(CIRCUMFERENCE_OF_WHEEL / GEAR_RATIO / TICKS_PER_ROTATION);
    }
}
