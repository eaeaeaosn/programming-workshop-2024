// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
  /** Creates new TalonSRX motor */
  // TODO: Change motor id
  TalonSRX motorFrontLeft = new TalonSRX(0);
  TalonSRX motorFrontRight = new TalonSRX(1);
  TalonSRX motorBackLeft = new TalonSRX(2);
  TalonSRX motorBackRight = new TalonSRX(3);

  
  
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    //Set followers
    motorBackLeft.follow(motorFrontLeft);
    motorBackRight.follow(motorFrontRight);

    //Set Invert
    // TODO: Check inverted
    motorFrontLeft.setInverted(false);
    motorFrontRight.setInverted(false);

    //Set Brake mode
    motorFrontLeft.setNeutralMode(NeutralMode.Brake);
    motorFrontRight.setNeutralMode(NeutralMode.Brake);
  }

  /** Run motor according to joystick input values. */
  public void setSpeeds(double leftSpeeds, double rightSpeeds) {
    motorFrontLeft.set(ControlMode.PercentOutput, leftSpeeds);
    motorFrontRight.set(ControlMode.PercentOutput, rightSpeeds);
  }

  // Run arcade drive based on setSpeeds
  public void setArcadeSpeed(double forwardSpeed, double turningSpeed) {
    double leftSpeed = forwardSpeed + turningSpeed;
    double rightSpeed = forwardSpeed - turningSpeed;

    setSpeeds(leftSpeed, rightSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
