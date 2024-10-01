// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();

  // Creates the Xbox controller to drive the robot
  XboxController mainController = new XboxController(0);  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /** Use this method to define your trigger->command mappings. */
  private void configureBindings() {
    // Put any trigger->command mappings here.

    // Run motor with setSpeeds command
    m_driveSubsystem.setDefaultCommand(
      m_driveSubsystem.run(() -> m_driveSubsystem.setSpeeds(
        mainController.getLeftX(), 
        mainController.getRightX()
        )
      )
    );
  }

  // Deadband command to eliminate drifting
  // TODO: test deadband value
  public static double deadBand(double value, double tolerance) {
    if(value < tolerance && value > -tolerance) {
      return 0;
    } else {
      return value;
    }
  }
  
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new Command() {};
  }
}
