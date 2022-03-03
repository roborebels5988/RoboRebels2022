// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AutoCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.TransformDownCommand;
import frc.robot.commands.TransformUpCommand;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.IntakeOuttake;
import frc.robot.subsystems.Transform;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final DriveTrain m_drivetrain = new DriveTrain();
  private final IntakeOuttake m_IntakeOuttake = new IntakeOuttake();
  private final Transform m_Transform = new Transform();

  private final AutoCommand m_autoCommand = new AutoCommand(m_drivetrain, m_IntakeOuttake, m_Transform);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    final XboxController m_xbox = new XboxController(0);
    final JoystickButton A = new JoystickButton(m_xbox, 1);
    final JoystickButton B = new JoystickButton(m_xbox, 2);
    final POVButton UpPOV = new POVButton(m_xbox, 0);
    final POVButton DownPOV = new POVButton(m_xbox, 180);

    B.whileHeld(new IntakeCommand(m_IntakeOuttake));
    A.whileHeld(new ShootCommand(m_IntakeOuttake));
    UpPOV.whenHeld(new TransformUpCommand(m_Transform));
    DownPOV.whenHeld(new TransformDownCommand(m_Transform));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
