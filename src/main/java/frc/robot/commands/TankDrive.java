// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class TankDrive extends CommandBase {
  public DriveTrain dt;
  public Joystick joy;

  /** Creates a new TankDrive. */
  public TankDrive(DriveTrain dt, Joystick j) {
    this.dt = dt;
    this.joy = j;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(dt);
  }

  // Called when the command is initially scheduled.
  //Every time the command is scheduled this would initialize the speed of the motor
  @Override
  public void initialize() {
    dt.tankDrive(0.0, 0.0);
  } 

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPowerRaw = joy.getRawAxis(1);
    // this gets the amount of power in the motor for the left

    double rightPowerRaw = joy.getRawAxis(5);

    dt.tankDrive(leftPowerRaw*-0.7, rightPowerRaw*-0.7);
    // this sets the power using the tank drive method
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    dt.tankDrive(0.0, 0.0);
    // this sets the speed to zero
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
    // it's never finished
  }
}
