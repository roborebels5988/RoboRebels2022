// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Transform extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  public Transform() {}
  public final MotorController TransformMotor = new PWMSparkMax(Constants.TRANSFORM_SPARKMAX);
  
  public DigitalInput toplimitSwitch = new DigitalInput(Constants.TRANSFORM_TOP_LIMIT_SWITCH);
  public DigitalInput bottomlimitSwitch = new DigitalInput(Constants.TRANSFORM_BOTTOM_LIMIT_SWITCH);

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
