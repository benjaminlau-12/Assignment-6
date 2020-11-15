package cs3500.animator.model.commands;

import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.IShape;

/**
 *
 */
public class Move extends Command{

  private final int x;
  private final int y;

  /**
   *
   * @param shape
   * @param time
   * @param x
   * @param y
   */
  public Move(IShape shape, TimeLapse time, int x, int y) {
    super(shape, time, CommandTypes.MOVE);
    this.x = x;
    this.y = y;
  }
}
