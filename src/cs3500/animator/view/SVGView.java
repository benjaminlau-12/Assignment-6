package cs3500.animator.view;

import cs3500.animator.model.IAnimationModel;
import cs3500.animator.model.shapes.IShape;
import java.util.List;

/**
 *
 */
public class SVGView extends AnimationView{
  private final int tick;

  /**
   *
   * @param tick
   */
  public SVGView(int tick){
    this.tick = tick;
  }

  /**
   *
   * @param shapes
   */
  @Override
  public void render(List<IShape> shapes) {
    builder.append(String.format("<svg width=\"%d\" height=\"%d\" version=\"1.1\""
            + " xmlns=\"http://www.w3.org/2000/svg\">\n",
        canvas.getBoundWidth() + canvas.getBoundX(),
        canvas.getBoundHeight() + canvas.getBoundY()));

    for (IShape s : shapes) {
      builder.append(s.SVGToString(this.tick));
    }
    builder.append("</svg>");
  }

  @Override
  public int getTick() {
    return 0;
  }
}
