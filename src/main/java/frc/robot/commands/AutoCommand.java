// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeOuttake;
import frc.robot.subsystems.Transform;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  private final Timer m_timer = new Timer();

  public AutoCommand(DriveTrain dt, IntakeOuttake it, Transform tr) {
    addRequirements(it);
    addRequirements(tr);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_timer.get() >= 1){
      if (m_timer.get() <= 3) {
        DriveTrain.m_robotDrive.arcadeDrive(0.1, 0.7);
      }
      else{
        DriveTrain.m_robotDrive.arcadeDrive(0,0);
        }
    }
    else{
      DriveTrain.m_robotDrive.arcadeDrive(0,0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
