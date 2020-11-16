package cs3500.animator.model.shapes;

/**
 * Interface that represents varying shapes of designated sizes and colors. This interface includes
 * methods that will allow the client to change the color, position, and size of a certain shape. A
 * Shape currently one of an ellipse or a rectangle. A Shape cannot have 0 area.
 */
public interface IShape {

  /**
   * Set the shape to a certain color, as given by the input.
   *
   * @param r The red level of the shape's color.
   * @param g The green level of the shape's color.
   * @param b The blue level of the shape's color.
   */
  void setColor(int r, int g, int b);

  /**
   * Set the top-left corner of the shape to a certain position on the animation canvas.
   *
   * @param x The horizontal distance of the shape from the top-left corner of the canvas.
   * @param y The vertical distance of the shape from the top-left corner of the canvas.
   */
  void setPosition(int x, int y);

  /**
   * Set the x-value of the shape's position while its y-value remains unchanged.
   *
   * @param x The horizontal distance of the shape from the top-left corner of the canvas.
   */
  void setX(int x);

  /**
   * Set the y-value of the shape's position while its x-value remains unchanged.
   *
   * @param y The vertical distance of the shape from the top-left corner of the canvas.
   */
  void setY(int y);

  /*-
   * Set the shape to the given width and height.
   *
   * @param width The width of the shape.
   * @param height The height of the shape.
   * @throws IllegalArgumentException If one of the two arguments are negative or if both arguments
   *                                  are zero.
   */
  void setSize(int width, int height) throws IllegalArgumentException;

  /*-
   * Set the shape to the given width while the height remains unchanged.
   *
   * @param width The width of the shape.
   * @throws IllegalArgumentException If the given width is negative or if the height is already set
   *                                  to  zero.
   */
  void setWidth(int width) throws IllegalArgumentException;

  /*-
   * Set the shape to the given height while the width remains unchanged.
   *
   * @param height The height of the shape.
   * @throws IllegalArgumentException If the given height is negative or if the width is already set
   *                                  to  zero.
   */
  void setHeight(int height) throws IllegalArgumentException;

  /**
   * Returns the x position of the shape.
   *
   * @return the x position of the shape.
   */
  int getX();

  /**
   * Returns the y position of the shape.
   *
   * @return the y position of the shape.
   */
  int getY();

  /**
   * Returns the width position of the shape.
   *
   * @return the width of the shape.
   */
  int getWidth();

  /**
   * Returns the height position of the shape.
   *
   * @return the height of the shape.
   */
  int getHeight();

  /**
   * Returns the red composition of the shape.
   *
   * @return the int representing the red composition of the shape.
   */
  int getR();

  /**
   * Returns the green composition of the shape.
   *
   * @return the int representing the green composition of the shape.
   */
  int getG();

  /**
   * Returns the blue composition of the shape.
   *
   * @return the int representing the blue composition of the shape.
   */
  int getB();

  /**
   * Returns the shape type, either ShapeTypes.RECTANGLE or ShapeTypes.ELLIPSE, of this Shape.
   *
   * @return the shape type, either ShapeTypes.RECTANGLE or ShapeTypes.ELLIPSE, of this Shape.
   */
  ShapeTypes getShapeType();

  /**
   * Returns the name of the shape.
   *
   * @return The name of the shape.
   */
  String getName();

  /**
   * Returns a String that describes the properties of this shape (name, width, height, x-position,
   * y-position, color).
   *
   * @return A String that describes the properties of this shape.
   */
  String textToString();

  /**
   * Returns a String that describes the properties of this shape (name, width, height, x-position,
   * y-position, color) in SVG format.
   *
   * @param tick The tick of the canvas of animatoin.
   * @return A String that describes the properties of this shape in SVG format.
   */
  String SVGToString(int tick);
}
