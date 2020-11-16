package cs3500.animator.model.commands;

import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.IShape;

/**
 * Represents a Command to move the position of a shape. Takes in a (x,y) coordinate of the shape
 * while the shape's all other characteristics remain the same.
 */
public class Move extends Command {

  private final int x;
  private final int y;

  /**
   * The constructor of the Move Command class.
   *
   * @param shape The shape to be commanded.
   * @param time  The time interval of the command.
   * @param x     The new x position of the shape.
   * @param y     The new y position of the shape.
   */
  public Move(IShape shape, TimeLapse time, int x, int y) {
    super(shape, time, CommandTypes.MOVE);
    this.x = x;
    this.y = y;
  }
}
