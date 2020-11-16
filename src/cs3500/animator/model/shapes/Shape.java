package cs3500.animator.model.shapes;

import cs3500.animator.model.helpers.RGB;
import cs3500.animator.model.helpers.TimeLapse;
import java.util.TreeMap;

/**
 * Represents a general shape class of undefined type. A Shape currently one of an ellipse or a
 * rectangle. A Shape cannot have 0 area.
 */
public class Shape implements IShape {

  // represents the color composition of this Shape object.
  protected RGB rgb = new RGB(0, 0, 0);
  // represents the x and y coordinate of this Shape object on the animation canvas.
  protected int x;
  protected int y;
  // represents the height and width of this Shape object.
  protected int width;
  protected int height;
  //
  protected TreeMap<TimeLapse, double[]> commands;
  // represents the name of this Shape object
  private String name;

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
  public Shape(String name, int x, int y, int height, int width, int r, int g, int b) {
    this.name = name;
    this.setPosition(x, y);
    this.setSize(width, height);
    this.setColor(r, g, b);
  }

  @Override
  public void setColor(int r, int g, int b) {
    if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
      throw new IllegalArgumentException("The color composition input(s) is invalid.");
    }
    this.rgb = new RGB(r, g, b);
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
    return this.rgb.getR();
  }

  @Override
  public int getG() {
    return this.rgb.getG();
  }

  @Override
  public int getB() {
    return this.rgb.getB();
  }

  @Override
  public ShapeTypes getShapeType() {
    return ShapeTypes.RECTANGLE;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String textToString() {
    StringBuilder builder = new StringBuilder();
    for (TimeLapse t : this.commands.keySet()) {
      builder.append(commandToString(t) + "\n");
    }
    return builder.toString();
  }

  @Override
  public String SVGToString(int tick) {
    StringBuilder builder = new StringBuilder();
    /*if (commands.size() > 0) {
      builder.append(String.format("<%s id=\"%s\" %s fill=\"%s\" visibility=\"hidden\">\n",
          shapeString(), this.name, shapeProp(true),
          colorTag(true)));

      builder.append(String.format("<animate attributeType=\"xml\" begin=\"%1$,.2fs\" dur=\"%2$,.2fs\"" +
              " attributeName=\"visibility\" from=\"visible\" to=\"hidden\"/>\n",
          getShapeFirstTime() / (double) tick, getShapeLastTime() / (double) tick));
      for (Interval i : commands.keySet()) {
        builder.append(intervalTag(i, tick));
      }
    } else {
     builder.append(String.format("<%s id=\"%s\" %s fill=\"%s\" visibility=\"hidden\">\n",
          shapeString(), this.name, shapeProp(false),
          colorTag(false)));
    }
    builder.append(String.format("</%s>\n", shapeString()));
    return builder.toString();*/
    return null;
  }

  /**
   * Returns a String that describes the command of a specific time interval t.
   *
   * @param t The time interval of the command.
   * @return The String that describes the command happening during the interval.
   */
  private String commandToString(TimeLapse t) {
    if (t.getStart() < 0 || t.getEnd() < 0 || t.getEnd() < t.getStart()) {
      throw new IllegalArgumentException("The input interval is invalid.");
    }
    double[] shapeInfo = this.commands.get(t);
    StringBuilder state = new StringBuilder("motion " + this.name + " ");
    for (double d : shapeInfo) {
      state.append(Math.round(d) + " ");
    }
    return state.toString();
  }
}
