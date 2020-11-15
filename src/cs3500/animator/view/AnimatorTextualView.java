package cs3500.animator.view;

import cs3500.animator.model.Command;
import cs3500.animator.model.IAnimationModel;
import cs3500.animator.model.shapes.IShape;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

public class AnimatorTextualView implements ITextualView {

  //
  private Appendable out;
  //
  private IAnimationModel model;

  /**
   * Constructor for TextView that takes the model to convert into a string.
   *
   * @param model is the model for which the TextView will create a constructor for.
   */
  public AnimatorTextualView(IAnimationModel model) {
    this.model = model;
    out = new StringWriter();
  }

  @Override
  public String getText() {
    return this.out.toString();
  }

  // The following methods are for Assignment 5 testing purposes.
  public void play() {
    Map<String, IShape> shapes = model.getShapes();
    Map<Command, String> commands = model.getCommands();

    for (Map.Entry<Command, String> entry : commands.entrySet()) {
      Command command = entry.getKey();
      IShape shape = shapes.get(entry.getValue());
      try {
        out.append("shape ").append(entry.getValue()).append(" ").append(shape.getShapeType())
            .append("\n");

        out.append("motion ").append(entry.getValue()).append(" ").append(command.getStart() + " ")
            .append(command.getStartX() + " ").append(command.getStartY() + " ")
            .append(command.getStartWidth() + " ").append(command.getStartHeight() + " ")
            .append(command.getStartR() + " ").append(command.getStartG() + " ")
            .append(command.getStartB() + " ");

        out.append(" ").append(command.getEnd() + " ")
            .append(command.getEndX() + " ").append(command.getEndY() + " ")
            .append(command.getEndWidth() + " ").append(command.getEndWidth() + " ")
            .append(command.getEndHeight() + " ")
            .append(command.getEndR() + " ").append(command.getEndG() + " ")
            .append(command.getEndB() + "\n");
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
