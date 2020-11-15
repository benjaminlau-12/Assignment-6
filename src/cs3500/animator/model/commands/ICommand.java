package cs3500.animator.model.commands;

import cs3500.animator.model.shapes.IShape;

/**
 *
 */
public interface ICommand {

  /**
   * Executes a command on the shape it has.
   */
  void follow();

  /**
   * Gets this Command's shape.
   *
   * @return the shape the command is operated on.
   */
  IShape getShape();

  /**
   * Gets this Command's frame.
   *
   * @return the time frame in which the command is operated in.
   */
  int getStart();

  /**
   * Gets this Command's frame.
   *
   * @return the time frame in which the command is operated in.
   */
  int getEnd();

  /**
   * Gets the type of this Command.
   *
   * @return the type of command that is being executed.
   */
  CommandTypes getType();
}
