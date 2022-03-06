// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private static final MotorController leftFrontPWMVictorSPX = new PWMVictorSPX(Constants.DRIVETRAIN_LEFT_FRONT_SPARKMAX);
  private static final MotorController leftRearPWMVictorSPX = new PWMVictorSPX(Constants.DRIVETRAIN_LEFT_BACK_SPARKMAX);
  private static final MotorController rightFrontPWMVictorSPX = new PWMVictorSPX(Constants.DRIVETRAIN_RIGHT_FRONT_SPARKMAX);
  private static final MotorController rightRearPWMVictorSPX = new PWMVictorSPX(Constants.DRIVETRAIN_RIGHT_BACK_SPARKMAX);

  private static MotorControllerGroup leftMotors = new MotorControllerGroup(leftFrontPWMVictorSPX, leftRearPWMVictorSPX);
  private static MotorControllerGroup rightMotors = new MotorControllerGroup(rightFrontPWMVictorSPX, rightRearPWMVictorSPX);

  public final DifferentialDrive m_robotDrive = new DifferentialDrive(leftMotors, rightMotors);

  public DriveTrain() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
