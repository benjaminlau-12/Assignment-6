package cs3500.animator.view;

import cs3500.animator.model.helpers.Canvas;
import cs3500.animator.model.shapes.IShape;
import java.util.List;

public interface IView {
  /**
   * Renders the given output depends on with view the user is selecting.
   *
   * @param shapes given IReadOnlyShapes that are from the model
   */
  void render(List<IShape> shapes);

  /**
   *
   * @param canvas
   */
  void setCanvas(Canvas canvas);

  /**
   * Converts the rendering information into a string.
   *
   * @return the output information in a string form
   */
  String getText();

  /**
   *
   * @return
   */
  int getTick();
}
