package cs3500.animator.model.commands;

import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.IShape;

/**
 * Represents a Command to change the width of a shape. Takes in a new width value of the shape
 * while the shape's all other characteristics remain the same.
 */
public class Width extends Command {

  private final int width;

  /**
   * Constructor of the Width Command class.
   *
   * @param shape The shape to be commanded.
   * @param time  The time interval of the command.
   * @param width The new width of the shape.
   */
  public Width(IShape shape,
      TimeLapse time, int width) {
    super(shape, time, CommandTypes.WIDTH);
    this.width = width;
  }
}
