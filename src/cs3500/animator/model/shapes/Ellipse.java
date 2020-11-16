package cs3500.animator.model.shapes;

/**
 * Represents the shapes whose sizes are defined by radii.
 */
public class Ellipse extends Shape {

  /**
   * Constructor of the Rectangle Class. All units are in pixels.
   *
   * @param x  An int that represents the x coordinate of the Ellipses.
   * @param y  An int that represents the y coordinate of the Ellipse.
   * @param rx An int that represents the horizontal radius of the Ellipse.
   * @param ry An int that represents the vertical radius of the Ellipse.
   * @param r  The red level of the shape's color.
   * @param g  The green level of the shape's color.
   * @param b  The blue level of the shape's color.
   */
  public Ellipse(String name, int x, int y, int rx, int ry, int r, int g, int b) {
    super(name, x, y, rx, ry, r, g, b);
  }

  @Override
  public ShapeTypes getShapeType() {
    return ShapeTypes.ELLIPSE;
  }
}
