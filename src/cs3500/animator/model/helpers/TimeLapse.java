package cs3500.animator.model.helpers;

/**
 *
 */
public class TimeLapse {
  private final int start;
  private final int end;

  /**
   *
   * @param start
   * @param end
   */
  public TimeLapse(int start, int end){
    this.start = start;
    this.end = end;
  }

  /**
   *
   * @return
   */
  public int getStart(){
    return this.start;
  }

  /**
   *
   * @return
   */
  public int getEnd(){
    return this.end;
  }
}
