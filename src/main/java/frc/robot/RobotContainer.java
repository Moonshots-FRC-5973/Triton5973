// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// LOCAL IMPORTS
// import frc.robot.commands.SwerveCommand;
// import frc.robot.subsystems.SwerveDrive;
import frc.robot.commands.BallThrowerCommand;
import frc.robot.commands.BallThrowerOffCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.IntakeOffCommand;
import frc.robot.commands.ThrowerBackCommand;
import frc.robot.commands.ThrowerBackOffCommand;
// import frc.robot.commands.MechanumCommand;
import frc.robot.subsystems.BallThrower;
// import frc.robot.subsystems.MechanumDrive;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // these are private member variables (hence the "m_" and are not to be made static or public)
  //private final SwerveDrive m_drivetrain = new SwerveDrive();
  private final BallThrower m_thrower = new BallThrower();
  private final Intake m_intake = new Intake();
  // private final SwerveDrive m_drivetrain = new MechanumDrive();

  //private final AutoCommand m_autoCommand;
  private final Joystick m_xboxController = new Joystick(Constants.BIGBOI);

  // Static stuff hosted here for easy access 
  private final static Joystick bigJoystick = new Joystick(Constants.BIGBOI);
  

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // SETTING DEFAULT COMMANDS
    // m_drivetrain.setDefaultCommand(new SwerveCommand(m_drivetrain, m_xboxController));
    // m_drivetrain.setDefaultCommand(new MechanumCommand(m_drivetrain, m_xboxController));

  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //define + instantiate buttons
    final JoystickButton a = new JoystickButton(m_xboxController, Constants.A);
    final JoystickButton b = new JoystickButton(m_xboxController, Constants.B);
    final JoystickButton x = new JoystickButton(m_xboxController, Constants.X);
    final JoystickButton y = new JoystickButton(m_xboxController, Constants.Y);
    final JoystickButton lBump = new JoystickButton(m_xboxController, Constants.L_BUMP);
    final JoystickButton rBump = new JoystickButton(m_xboxController, Constants.R_BUMP);
    final JoystickButton select = new JoystickButton(m_xboxController, Constants.SELECT);
    final JoystickButton start = new JoystickButton(m_xboxController, Constants.START);
    final JoystickButton leftJoystick = new JoystickButton(m_xboxController, Constants.LEFT_JOYSTICK_BUTTON);
    final JoystickButton rightJoystick = new JoystickButton(m_xboxController, Constants.RIGHT_JOYSTICK_BUTTON);
    
    //assign buttons to commands
    a.whenPressed(new BallThrowerCommand(m_thrower));
    b.whenPressed(new BallThrowerOffCommand(m_thrower));
    x.whenPressed(new ThrowerBackCommand(m_thrower));
    y.whenPressed(new ThrowerBackOffCommand(m_thrower));
    lBump.whileHeld(new IntakeOffCommand(m_intake));
    rBump.whenPressed(new IntakeCommand(m_intake));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
    return null;
  }
}