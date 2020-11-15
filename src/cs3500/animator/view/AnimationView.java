package cs3500.animator.view;

import cs3500.animator.model.helpers.Canvas;
import cs3500.animator.model.shapes.IShape;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 */
public abstract class AnimationView extends JFrame implements IView{

  protected List<IShape> shapes;
  protected Canvas canvas;
  protected StringBuilder builder = new StringBuilder();

  @Override
  public void setCanvas(Canvas canvas) {
    this.canvas = canvas;
  }

  @Override
  public String getText() {
    return this.builder.toString();
  }

  @Override
  public abstract void render(List<IShape> shapes);

  @Override
  public abstract int getTick();
}
