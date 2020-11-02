package cs3500.animator.model;


/**
 * Represents a command inputed by the user. Stores the information of a shape before and after a
 * command is processed.
 */
public class Command implements Comparable {

  protected int start;
  protected int startX;
  protected int startY;
  protected int startWidth;
  protected int startHeight;
  protected int startR;
  protected int startG;
  protected int startB;

  protected int end;
  protected int endX;
  protected int endY;
  protected int endWidth;
  protected int endHeight;
  protected int endR;
  protected int endG;
  protected int endB;

  /**
   * The constructor of the Command class.
   *
   * @param start       The starting time of this command.
   * @param startX      The starting x position of the shape.
   * @param startY      The starting y position of the shape.
   * @param startWidth  The starting width of the shape.
   * @param startHeight The starting height of the shape.
   * @param startR      The starting red composition of the shape.
   * @param startG      The starting green composition of the shape.
   * @param startB      The starting blue composition of the shape.
   * @param end         The ending time of this command.
   * @param endX        The ending x position of the shape.
   * @param endY        The ending y position of the shape.
   * @param endWidth    The ending width of the shape.
   * @param endHeight   The ending height of the shape.
   * @param endR        The ending red composition of the shape.
   * @param endG        The ending green composition of the shape.
   * @param endB        The ending blue composition of the shape.
   */
  public Command(int start, int startX, int startY, int startWidth, int startHeight, int startR,
      int startG, int startB, int end, int endX, int endY, int endWidth, int endHeight, int endR,
      int endG, int endB) {
    if (start < 0 || end < 0) {
      throw new IllegalArgumentException("Time cannot be negative.");
    }
    this.start = start;
    this.startX = startX;
    this.startY = startY;
    this.startWidth = startWidth;
    this.startHeight = startHeight;
    this.startR = startR;
    this.startG = startG;
    this.startB = startB;

    this.end = end;
    this.endX = endX;
    this.endY = endY;
    this.endWidth = endWidth;
    this.endHeight = endHeight;
    this.endR = endR;
    this.endG = endG;
    this.endB = endB;
  }

  /**
   * The constructor of the Command class that only takes in the starting values and the ending x
   * and y.
   *
   * @param start       The starting time of this command.
   * @param startX      The starting x position of the shape.
   * @param startY      The starting y position of the shape.
   * @param startWidth  The starting width of the shape.
   * @param startHeight The starting height of the shape.
   * @param startR      The starting red composition of the shape.
   * @param startG      The starting green composition of the shape.
   * @param startB      The starting blue composition of the shape.
   * @param end         The ending time of this command.
   * @param endX        The ending x position of the shape.
   * @param endY        The ending y position of the shape.
   */
  public Command(int start, int startX, int startY, int startWidth, int startHeight, int startR,
      int startG, int startB, int end, int endX, int endY) {
    new Command(start, startX, startY, startWidth, startHeight, startR, startG, startB, end, endX,
        endY, startWidth, startHeight, startR, startG, startB);
  }

  /**
   * The constructor of the Command class that only takes in the starting values and the ending
   * rgb.
   *
   * @param start       The starting time of this command.
   * @param startX      The starting x position of the shape.
   * @param startY      The starting y position of the shape.
   * @param startWidth  The starting width of the shape.
   * @param startHeight The starting height of the shape.
   * @param startR      The starting red composition of the shape.
   * @param startG      The starting green composition of the shape.
   * @param startB      The starting blue composition of the shape.
   * @param end         The ending time of this command.
   */
  public Command(int start, int startX, int startY, int startWidth, int startHeight, int startR,
      int startG, int startB, int end, int endR, int endG, int endB) {
    new Command(start, startX, startY, startWidth, startHeight, startR, startG, startB, end, startX,
        startY, startWidth, startHeight, endR, endG, endB);
  }

  /**
   * The constructor of the Command class that only takes in the starting values and the ending
   * height/width.
   *
   * @param start       The starting time of this command.
   * @param startX      The starting x position of the shape.
   * @param startY      The starting y position of the shape.
   * @param startWidth  The starting width of the shape.
   * @param startHeight The starting height of the shape.
   * @param startR      The starting red composition of the shape.
   * @param startG      The starting green composition of the shape.
   * @param startB      The starting blue composition of the shape.
   * @param end         The ending time of this command.
   * @param command     The string that indicates if this command changes the height or width.
   */
  public Command(int start, int startX, int startY, int startWidth, int startHeight, int startR,
      int startG, int startB, int end, int endWidthHeight, String command) {
    switch (command) {
      case "width":
        new Command(start, startX, startY, startWidth, startHeight, startR, startG, startB, end,
            startX,
            startY, endWidthHeight, startHeight, startR, startG, startB);
        break;
      case "height":
        new Command(start, startX, startY, startWidth, startHeight, startR, startG, startB, end,
            startX,
            startY, startWidth, endWidthHeight, startR, startG, startB);
        break;
      default:
        break;
    }
  }

  /**
   * Returns the starting time of this command.
   *
   * @return the starting time of this command.
   */
  public int getStart() {
    return this.start;
  }

  /**
   * Returns the starting x value of the shape.
   *
   * @return the starting x value of the shape.
   */
  public int getStartX() {
    return this.startX;
  }

  /**
   * Returns the starting y value of the shape.
   *
   * @return the starting y value of the shape.
   */
  public int getStartY() {
    return this.startY;
  }

  /**
   * Returns the starting width of the shape.
   *
   * @return the starting width of the shape.
   */
  public int getStartWidth() {
    return this.startWidth;
  }

  /**
   * Returns the starting height of the shape.
   *
   * @return the starting height of the shape.
   */
  public int getStartHeight() {
    return this.startHeight;
  }

  /**
   * Returns the starting r value of the shape.
   *
   * @return the starting r value of the shape.
   */
  public int getStartR() {
    return this.startR;
  }

  /**
   * Returns the starting g value of the shape.
   *
   * @return the starting g value of the shape.
   */
  public int getStartG() {
    return this.startG;
  }

  /**
   * Returns the starting b value of the shape.
   *
   * @return the starting b value of the shape.
   */
  public int getStartB() {
    return this.startB;
  }

  /**
   * Returns the ending time of this command.
   *
   * @return the ending time of this command.
   */
  public int getEnd() {
    return this.end;
  }

  /**
   * Returns the ending x value of the shape.
   *
   * @return the ending x value of the shape.
   */
  public int getEndX() {
    return this.endX;
  }

  /**
   * Returns the ending y value of the shape.
   *
   * @return the ending y value of the shape.
   */
  public int getEndY() {
    return this.endY;
  }

  /**
   * Returns the ending width of the shape.
   *
   * @return the ending width of the shape.
   */
  public int getEndWidth() {
    return this.endWidth;
  }

  /**
   * Returns the ending height of the shape.
   *
   * @return the ending height of the shape.
   */
  public int getEndHeight() {
    return this.endHeight;
  }

  /**
   * Returns the ending r value of the shape.
   *
   * @return the ending r value of the shape.
   */
  public int getEndR() {
    return this.endR;
  }

  /**
   * Returns the ending g value of the shape.
   *
   * @return the ending g value of the shape.
   */
  public int getEndG() {
    return this.endG;
  }

  /**
   * Returns the ending b value of the shape.
   *
   * @return the ending b value of the shape.
   */
  public int getEndB() {
    return this.endB;
  }

  @Override
  public int compareTo(Object o) {
    return 0;
  }
}
