package cs3500.animator.model;

import cs3500.animator.model.commands.Color;
import cs3500.animator.model.commands.Height;
import cs3500.animator.model.commands.ICommand;
import cs3500.animator.model.commands.Move;
import cs3500.animator.model.commands.Width;
import cs3500.animator.model.helpers.Canvas;
import cs3500.animator.model.helpers.RGB;
import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.Ellipse;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.model.shapes.ShapeTypes;
import java.util.ArrayList;
import java.util.List;


/**
 * The model of the animation. Stores the commands from and the added shapes of the client. Includes
 * a toString() method that allows the user to view the animation in text.
 */
// Invariant: The width and height of the model is always positive.
//            The r, g, and b value of a shape will always be between 0 and 225.
public final class AnimationModel implements IAnimationModel {

  // A stub to represent a list of commands given to the model.
  // Represents the list of shapes within this model
  List<IShape> shapes;
  List<ICommand> commands;
  // int representing the size information of this model.
  private Canvas canvas;

  /**
   * Constructor of the AnimationModel class.
   *
   * @param x      The left-most x value of the canvas.
   * @param y      The top-most y value of the canvas.
   * @param width  The width of the canvas.
   * @param height The height of the canvas.
   */
  public AnimationModel(int x, int y, int width, int height) {
    this.setBounds(x, y, width, height);
  }

  public void addShape(String name, ShapeTypes shapeTypes, int x, int y, int width, int height,
      int r, int g, int b) {
    if (name == null || shapeTypes == null) {
      throw new IllegalArgumentException("Name and shape to be added cannot be null.");
    }
    IShape shape;
    switch (shapeTypes) {
      case ELLIPSE:
        shape = new Ellipse(name, x, y, width, height, r, g, b);
      case RECTANGLE:
        shape = new Rectangle(name, x, y, width, height, r, g, b);
        break;
      default:
        throw new IllegalArgumentException("The provided shape type is invalid.");
    }
    shapes.add(shape);
  }

  @Override
  public void removeShape(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name of the shape to be removed cannot be null.");
    }
    IShape shape = this.getShapeByName(name);
    if (shape == null) {
      throw new IllegalArgumentException("There is no shape with this name in the current list.");
    }
    shapes.remove(shape);
  }

  @Override
  public void moveShape(String name, int start, int end, int newX, int newY) {
    commandExceptions(name, start, end);
    ICommand command = new Move(this.getShapeByName(name), new TimeLapse(start, end), newX, newY);
    commands.add(command);
  }

  @Override
  public void changeColor(String name, int start, int end, int r, int g, int b) {
    commandExceptions(name, start, end);
    ICommand command = new Color(this.getShapeByName(name), new TimeLapse(start, end),
        new RGB(r, g, b));
    commands.add(command);
  }

  @Override
  public void changeWidth(String name, int start, int end, int width) {
    commandExceptions(name, start, end);
    ICommand command = new Width(this.getShapeByName(name), new TimeLapse(start, end), width);
    commands.add(command);
  }

  @Override
  public void changeHeight(String name, int start, int end, int height) {
    commandExceptions(name, start, end);
    ICommand command = new Height(this.getShapeByName(name), new TimeLapse(start, end), height);
    commands.add(command);
  }

  @Override
  public List<IShape> getShapes() {
    List<IShape> copy = new ArrayList<IShape>(shapes);
    return copy;
  }

  @Override
  public void setBounds(int x, int y, int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height values must be positive.");
    }
    this.canvas = new Canvas(x, y, width, height);
  }

  @Override
  public int getX() {
    return this.canvas.getBoundX();
  }

  @Override
  public int getY() {
    return this.canvas.getBoundY();
  }

  @Override
  public int getWidth() {
    return this.canvas.getBoundWidth();
  }

  @Override
  public int getHeight() {
    return this.canvas.getBoundHeight();
  }

  @Override
  public List<ICommand> getCommands() {
    return this.commands;
  }


  /**
   * Returns the IShape object in the list this.shapes if its name matches the given name.
   *
   * @param name The name of a shape to look for in the list of shapes.
   * @return The shape with the provided name or null if no such shape exists.
   */
  private IShape getShapeByName(String name) {
    for (IShape shape : shapes) {
      if (shape.getName().equals(name)) {
        return shape;
      }
    }
    return null;
  }

  /**
   * Checks for common exceptions in the inputs of new commands. Throw IllegalArgumentExceptions
   * accordingly.
   *
   * @param name  The name of the shape.
   * @param start The start time of the command.
   * @param end   The end time of the command.
   */
  private void commandExceptions(String name, int start, int end) {
    if (name == null) {
      throw new IllegalArgumentException("The shape name cannot be null.");
    }
    if (start < 0 || end < 0 || end < start) {
      throw new IllegalArgumentException("The input time interval is invalid.");
    }
    if (this.getShapeByName(name) == null) {
      throw new IllegalArgumentException(
          "The shape with the given name does not exist in the current model.");
    }
  }

  /**
   *
   */
  public static final class Builder extends AnimationBuilder<IAnimationModel> {
    // FILL IN HERE
  }
}
