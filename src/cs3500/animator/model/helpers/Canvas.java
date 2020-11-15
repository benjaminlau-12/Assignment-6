package cs3500.animator.model.helpers;

/**
 *
 */
public class Canvas {

  private int boundX;
  private int boundY;
  private int boundWidth;
  private int boundHeight;

  /**
   *
   * @param x
   * @param y
   * @param width
   * @param height
   */
  public Canvas(int x, int y, int width, int height){
    this.boundX = x;
    this.boundY = y;
    this.boundWidth = width;
    this.boundHeight = height;
  }

  /**
   *
   * @return
   */
  public int getBoundX() {
    return boundX;
  }

  /**
   *
   * @return
   */
  public int getBoundY() {
    return boundY;
  }

  /**
   *
   * @return
   */
  public int getBoundWidth() {
    return boundWidth;
  }

  /**
   *
   * @return
   */
  public int getBoundHeight(){
    return boundHeight;
  }
}
