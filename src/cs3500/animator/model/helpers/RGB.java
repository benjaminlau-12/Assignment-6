package cs3500.animator.model.helpers;

/**
 *
 */
public class RGB {

  private final int r;
  private final int g;
  private final int b;

  /**
   *
   * @param r
   * @param g
   * @param b
   */
  public RGB(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  /**
   *
   * @return
   */
  public int getR(){
    return this.r;
  }

  /**
   *
   * @return
   */
  public int getG(){
    return this.g;
  }

  /**
   *
   * @return
   */
  public int getB(){
    return this.b;
  }
}
