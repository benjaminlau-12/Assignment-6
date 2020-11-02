package cs3500.animator.model;

import cs3500.animator.model.shapes.IShape;
import java.util.Map;

/**
 * Interface representing a animation model, for which enables the clients to add Shapes to the
 * animation.
 */
public interface IAnimationModel {

  /**
   * Adds an IShape object with a specific name to the list of shapes of the model.
   *
   * @param name  The name of the shape.
   * @param shape A Shape to be linked to the given name.
   */
  void addShape(String name, IShape shape);

  /**
   * Remove an IShape object with a specific name to the list of shapes of the model.
   *
   * @param name The name of the shape to be removed.
   */
  void removeShape(String name);

  /**
   * Returns a copy of the current shapes in the model.
   *
   * @return A Map(String, IShape) representing the current shapes in the model.
   */
  Map<String, IShape> getShapes();

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
   * Moves the designated shape from its current location to the specified location (toX, toY).
   *
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param name  The name of the shape.
   * @param toX   The x value of the destination.
   * @param toY   The y value of the destination.
   */
  void moveShape(int start, int end, String name, int toX, int toY);


  /**
   * Changes the color of the shape from its current color to the input (r,g,b) color.
   *
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param name  The nae of the shape.
   * @param r     The red composition of the shape's color.
   * @param g     The green composition of the shape's color.
   * @param b     The blue composition of the shape's color.
   */
  void changeColor(int start, int end, String name, int r, int g, int b);

  /**
   * Changes the color of the shape from its current color to the designated color, represented by a
   * String.
   *
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param name  The nae of the shape.
   * @param color The String representing the new color of the shape.
   */
  void changeColor(int start, int end, String name, String color);

  /**
   * Changes the width of the shape from its current width to the input width.
   *
   * @param start The starting time of this motion.
   * @param end   The ending time of this motion.
   * @param name  The nae of the shape.
   * @param width The new width of the shape.
   */
  void changeWidth(int start, int end, String name, int width);

  /**
   * Changes the height of the shape from its current height to the input width.
   *
   * @param start  The starting time of this motion.
   * @param end    The ending time of this motion.
   * @param name   The nae of the shape.
   * @param height The new height of the shape.
   */
  void changeHeight(int start, int end, String name, int height);

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
}
