package cs3500.animator.model.shapes;

/**
 * Represents a general shape class of undefined type. A Shape currently one of an ellipse or a
 * rectangle. A Shape cannot have 0 area.
 */
public class Shape implements IShape {

  // represents the color composition of this Shape object.
  protected int r = 0;
  protected int g = 0;
  protected int b = 0;
  // represents the x and y coordinate of this Shape object on the animation canvas.
  protected int x;
  protected int y;
  // represents the height and width of this Shape object.
  protected int width;
  protected int height;

  /**
   * Constructor of the Shape class. All units are in pixels.
   *
   * @param x      An int that represents the x coordinate of the Shape.
   * @param y      An int that represents the y coordinate of the Shape.
   * @param height An int that represents the height of the Shape.
   * @param width  An int that represents the width of the Shape.
   * @param r      The red level of the shape's color.
   * @param g      The green level of the shape's color.
   * @param b      The blue level of the shape's color.
   */
  public Shape(int x, int y, int height, int width, int r, int g, int b) {
    this.setPosition(x, y);
    this.setSize(width, height);
    this.setColor(r, g, b);
  }

  @Override
  public void setColor(int r, int g, int b) {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("The color composition input(s) is invalid.");
    }
    this.r = r;
    this.g = g;
    this.b = b;
  }

  @Override
  public void setPosition(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void setSize(int width, int height) throws IllegalArgumentException {
    if (width < 0 || height < 0) {
      throw new IllegalArgumentException("At least one of width or height is negative.");
    }
    if (width == 0 && height == 0) {
      throw new IllegalArgumentException("Cannot create a shape with 0 area.");
    }
    this.width = width;
    this.height = height;
  }

  @Override
  public void setWidth(int width) throws IllegalArgumentException {
    if (width < 0) {
      throw new IllegalArgumentException("The given width is negative.");
    }
    if (width == 0 && height == 0) {
      throw new IllegalArgumentException("Height is already 0. Cannot create a shape with 0 area.");
    }
    this.width = width;
  }

  @Override
  public void setHeight(int height) throws IllegalArgumentException {
    if (height < 0) {
      throw new IllegalArgumentException("The given height is negative.");
    }
    if (width == 0 && height == 0) {
      throw new IllegalArgumentException("Width is already 0. Cannot create a shape with 0 area.");
    }
    this.height = height;
  }

  // The following methods are only for Assignment 5 testing purposes, and will likely be removed
  // for protection in later assignments.

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

  @Override
  public int getHeight() {
    return this.height;
  }

  @Override
  public int getR() {
    return this.r;
  }

  @Override
  public int getG() {
    return this.g;
  }

  @Override
  public int getB() {
    return this.b;
  }

  @Override
  public String getShapeType() {
    return "rectangle";
  }
}
