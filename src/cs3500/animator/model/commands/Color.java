package cs3500.animator.model.commands;

import cs3500.animator.model.helpers.RGB;
import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.IShape;

/**
 * Represents a Command to change the color of a shape. Takes in a new color/RGB content of the
 * shape while the shape's all other characteristics remain the same.
 */
public class Color extends Command {

  private final RGB rgb;

  /**
   * Constructor for the Color Command class.
   *
   * @param shape The shape to be commanded.
   * @param time  The time interval of the command.
   * @param rgb   The new RGB content of the shape.
   */
  public Color(IShape shape,
      TimeLapse time, RGB rgb) {
    super(shape, time, CommandTypes.COLOR);
    this.rgb = rgb;
  }
}
