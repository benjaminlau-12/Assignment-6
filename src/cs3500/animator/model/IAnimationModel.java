package cs3500.animator.model;

import cs3500.animator.model.commands.ICommand;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.ShapeTypes;
import java.util.List;

/**
 * Interface representing a animation model, for which enables the clients to add Shapes to the
 * animation.
 */
public interface IAnimationModel {

  /**
   * Adds an IShape object with a specific name to the list of shapes of the model.
   *
   * @param name
   * @param shapeTypes
   * @param x
   * @param y
   * @param width
   * @param height
   * @param r
   * @param g
   * @param b
   */
  void addShape(String name, ShapeTypes shapeTypes, int x, int y, int width, int height,
      int r, int g, int b);

  /**
   * Remove an IShape object with a specific name to the list of shapes of the model.
   *
   * @param name The name of the shape to be removed.
   */
  void removeShape(String name);

  /**
   * Add a command to an IShape object within this model. The command type can either be MOVE,
   * WIDTH, HEIGHT, or COLOR.
   *
   * @param shape The name of the shape to command.
   * @param start The start time of the command.
   * @param end   The end time of the command.
   * @param newX  The x destination of the shape
   * @param newY
   */
  void moveShape(String shape, int start, int end, int newX, int newY);

  /**
   * Changes the color of the shape from its current color to the input (r,g,b) color.
   *
   * @param name  The nae of the shape.
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param r     The red composition of the shape's color.
   * @param g     The green composition of the shape's color.
   * @param b     The blue composition of the shape's color.
   */
  void changeColor(String name, int start, int end, int r, int g, int b);

  /**
   * Changes the width of the shape from its current width to the input width.
   *
   * @param name  The name of the shape whose width is to be changed.
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param width The new width of the shape.
   */
  void changeWidth(String name, int start, int end, int width);

  /**
   * Changes the height of the shape from its current height to the input width.
   *
   * @param name  The name of the shape whose height is to be changed.
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param height The new height of the shape.
   */
  void changeHeight(String name, int start, int end, int height);

  /**
   * Returns a copy of the current shapes in the model.
   *
   * @return A Map(String, IShape) representing the current shapes in the model.
   */
  List<IShape> getShapes();

  /**
   * Set the bounds of the animation canvas.
   *
   * @param x      The left-most x value of the canvas.
   * @param y      The top-most y value of the canvas.
   * @param width  The width of the canvas.
   * @param height The height of the canvas.
   * @throws IllegalArgumentException If the width or height is non-positive.
   */
  void setBounds(int x, int y, int width, int height) throws IllegalArgumentException;

  /**
   * Returns the left-most value of the animation canvas.
   *
   * @return the left-most value of the animation canvas.
   */
  int getX();

  /**
   * Returns the top-most value of the animation canvas.
   *
   * @return the top-most value of the animation canvas.
   */
  int getY();

  /**
   * Returns the width of the animation canvas.
   *
   * @return the width value of the animation canvas.
   */
  int getWidth();

  /**
   * Returns the height of the animation canvas.
   *
   * @return the height value of the animation canvas.
   */
  int getHeight();

  /**
   * Returns the list of commands in this model.
   *
   * @return the list of commands in this model.
   */
  List<ICommand> getCommands();
}
