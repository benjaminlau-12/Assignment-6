package cs3500.animator.view;

import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.ShapeTypes;
import java.util.List;

public class TextualView extends AnimationView {

  /**
   *
   */
  public TextualView() {
  }

  @Override
  public void render(List<IShape> shapes) {
    this.builder.append(String.format("canvas %s", this.canvas.toString()));

    for (IShape s : shapes) {
      this.builder.append("shape ").append(s.getName());
      if (s.getShapeType() == ShapeTypes.ELLIPSE) {
        this.builder.append(" Ellipse\n");
      } else {
        this.builder.append(" Rectangle\n");
      }
      this.builder.append(s.textToString());
      this.builder.append("\n");
    }
  }

  @Override
  public int getTick() {
    return 0;
  }
}
