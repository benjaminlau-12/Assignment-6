package cs3500.animator.model.shapes;

/**
 * The class that represents a rectangle, including squares. Inherit all methods from Shape.class.
 */
public class Rectangle extends Shape {

  /**
   * Constructor of the Rectangle Class. All units are in pixels.
   *
   * @param x      An int that represents the x coordinate of the Rectangle.
   * @param y      An int that represents the y coordinate of the Rectangle.
   * @param height An int that represents the height of the Rectangle.
   * @param width  An int that represents the width of the Rectangle.
   * @param r      The red level of the shape's color.
   * @param g      The green level of the shape's color.
   * @param b      The blue level of the shape's color.
   */
  public Rectangle(String name, int x, int y, int height, int width, int r, int g, int b) {
    super(name, x, y, height, width, r, g, b);
  }
}
