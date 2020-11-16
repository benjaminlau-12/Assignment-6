package cs3500.animator.model.commands;

import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.IShape;

/**
 * Represents a Command to change the height of a shape. Takes in a new height value of the shape
 * while the shape's all other characteristics remain the same.
 */
public class Height extends Command {

  private final int height;

  /**
   * Constructor of the Height Command class.
   *
   * @param shape  The shape to be commanded.
   * @param time   The time interval of the command.
   * @param height The new height of the shape.
   */
  public Height(IShape shape,
      TimeLapse time, int height) {
    super(shape, time, CommandTypes.HEIGHT);
    this.height = height;
  }
}
