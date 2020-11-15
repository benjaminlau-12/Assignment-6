package cs3500.animator.model.shapes;

/**
 * Represents the shapes whose sizes are defined by radii.
 */
public class Ellipse extends Shape {

  // represents the x and y position of the center of the ellipse. For circles, cx = cy.
  int cx;
  int cy;

  /**
   * Constructor of the Rectangle Class. All units are in pixels.
   *
   * @param x  An int that represents the x coordinate of the Ellipses.
   * @param y  An int that represents the y coordinate of the Ellipse.
   * @param rx An int that represents the horizontal radius of the Ellipse.
   * @param ry An int that represents the vertical radius of the Ellipse.
   * @param cx An int that represents x position of the center of the Ellipse.
   * @param cy An int that represents y position of the center of the Ellipse.
   * @param r  The red level of the shape's color.
   * @param g  The green level of the shape's color.
   * @param b  The blue level of the shape's color.
   */
  public Ellipse(String name, int x, int y, int rx, int ry, int cx, int cy, int r, int g, int b) {
    super(name, x, y, rx, ry, r, g, b);
    if (cx < 0 || cy < 0) {
      throw new IllegalArgumentException("At least one of cx or cy is negative.");
    }
    this.cx = cx;
    this.cy = cy;
  }

  // The following methods are only for Assignment 5 testing purposes, and will likely be removed
  // for protection in later assignments.

  /**
   * Returns the x position of the center of the shape.
   *
   * @return the x position of the center of the shape.
   */
  public int getCx() {
    return this.cx;
  }

  /**
   * Returns the y position of the center of the shape.
   *
   * @return the y position of the center of the shape.
   */
  public int getCy() {
    return this.cy;
  }

  @Override
  public ShapeTypes getShapeType() {
    return ShapeTypes.ELLIPSE;
  }
}
