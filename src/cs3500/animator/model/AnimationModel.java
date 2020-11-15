package cs3500.animator.model;

import cs3500.animator.model.shapes.IShape;
import java.util.Map;
import java.util.TreeMap;

/**
 * The model of the animation. Stores the commands from and the added shapes of the client. Includes
 * a toString() method that allows the user to view the animation in text.
 */
// Invariant: The width and height of the model is always positive.
//            The r, g, and b value of a shape will always be between 0 and 225.
public final class AnimationModel implements IAnimationModel {

  /**
   *
   */
  public static final class Builder extends AnimationBuilder<IAnimationModel> {
    // FILL IN HERE
  }

  // A stub to represent a list of commands given to the model.
  // Represents the list of shapes within this model
  Map<String, IShape> shapes;
  Map<Command, String> commands;
  // Represents the current tick of this model.
  private int currentTick;
  // int representing the size information of this model.
  private int boundX;
  private int boundY;
  private int boundWidth = 1;
  private int boundHeight = 1;

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
    shapes = new TreeMap<String, IShape>();
    commands = new TreeMap<Command, String>();
  }

  @Override
  public void addShape(String name, IShape shape) {
    if (name == null || shape == null) {
      throw new IllegalArgumentException("Name and shape to be added cannot be null.");
    }
    if (this.shapes != null && this.shapes.containsKey(name)) {
      throw new IllegalArgumentException("This name is already taken.");
    }
    shapes.put(name, shape);
  }

  @Override
  public void removeShape(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name of the shape to be removed cannot be null.");
    }
    if (!this.shapes.containsKey(name)) {
      throw new IllegalArgumentException("There is no shape with this name in the model.");
    }
    shapes.remove(name);
  }

  @Override
  public Map<String, IShape> getShapes() {
    Map<String, IShape> copy = new TreeMap<>(shapes);
    return copy;
  }

  @Override
  public void setBounds(int x, int y, int width, int height) throws IllegalArgumentException {
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException("The width and height values must be positive.");
    }
    this.boundX = x;
    this.boundY = y;
    this.boundWidth = width;
    this.boundHeight = height;
  }

  @Override
  public void moveShape(int start, int end, String name, int toX, int toY) {
    commandExceptions(start, end, name);
    IShape shape = shapes.get(name);
    commands.put(new Command(start, shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(),
        shape.getR(), shape.getG(), shape.getB(), end, toX, toY), name);
    shape.setX(toX);
    shape.setY(toY);
  }

  @Override
  public void changeColor(int start, int end, String name, int r, int g, int b) {
    commandExceptions(start, end, name);
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("Invalid color input(s).");
    }
    IShape shape = shapes.get(name);
    commands.put(new Command(start, shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(),
        shape.getR(), shape.getG(), shape.getB(), end, r, g, b), name);
    shape.setColor(r, g, b);
  }

  @Override
  public void changeColor(int start, int end, String name, String color) {
    // We have yet implemented the String representation of colors. This might be useful for future
    // assignments.
  }

  @Override
  public void changeWidth(int start, int end, String name, int width) {
    commandExceptions(start, end, name);
    if (width < 0) {
      throw new IllegalArgumentException("Negative input width.");
    }
    IShape shape = shapes.get(name);
    commands.put(new Command(start, shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(),
        shape.getR(), shape.getG(), shape.getB(), end, width, "width"), name);
    shape.setWidth(width);
  }

  @Override
  public void changeHeight(int start, int end, String name, int height) {
    commandExceptions(start, end, name);
    if (height < 0) {
      throw new IllegalArgumentException("Negative input height.");
    }
    IShape shape = shapes.get(name);
    commands.put(new Command(start, shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight(),
        shape.getR(), shape.getG(), shape.getB(), end, height, "height"), name);
    shape.setHeight(height);
  }

  @Override
  public int getX() {
    return this.boundX;
  }

  @Override
  public int getY() {
    return this.boundY;
  }

  @Override
  public int getWidth() {
    return this.boundWidth;
  }

  @Override
  public int getHeight() {
    return this.boundHeight;
  }

  @Override
  public Map<Command, String> getCommands() {
    return this.commands;
  }

  /**
   * Prints out the specified Shape object's x and y positions, width, height, and color
   * compositions.
   *
   * @param shape The Shape object whose information is to be printed.
   * @return A String that includes all the needed information, as described above.
   */
  protected String shapeToString(IShape shape) {
    StringBuilder result = new StringBuilder();
    result.append(shape.getX() + " ")
        .append(shape.getY() + " ")
        .append(shape.getWidth() + " ")
        .append(shape.getHeight() + " ")
        .append(shape.getR() + " ")
        .append(shape.getG() + " ")
        .append(shape.getB() + " ");
    return result.toString();
  }

  /**
   * Throws IllegalArgumentExceptions if the start or end time is negative, if end time is less than
   * start time, or if a shape with the given name does not exist in the list.
   *
   * @param start The starting time of a command.
   * @param end   The ending time of a command.
   * @param name  The name of the shape within the command.
   */
  protected void commandExceptions(int start, int end, String name) {
    if (start < 0 || end < 0) {
      throw new IllegalArgumentException("The given time value(s) cannot be negative.");
    }
    if (end < start) {
      throw new IllegalArgumentException("The given time interval cannot be negative.");
    }
    if (shapes.get(name) == null) {
      throw new IllegalArgumentException("The shape with the given name is not found.");
    }
  }
}
