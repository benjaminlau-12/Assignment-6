package cs3500.animator.view;

import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.ShapeTypes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.List;

import javax.swing.JPanel;

/**
 *
 */
public class Drawing extends JPanel implements IDrawing{

  private List<IShape> shapes = null;

  /**
   * A constructor that is called in the controller to enable this action.
   */
  public Drawing() {
    super();
  }

  /**
   * Draws a shape with corresponding position, color, and size.
   *
   * @param g given graphics
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (shapes != null) {
      Graphics2D g2d = (Graphics2D) g;
      for (IShape shape : shapes) {
        g2d.setColor(new Color((int) shape.getR(),
            (int) shape.getG(),
            (int) shape.getB()));

        if (shape.getShapeType().equals(ShapeTypes.RECTANGLE)) {
          g2d.fillRect((int) shape.getX(), (int) shape.getY(),
              (int) shape.getWidth(), (int) shape.getHeight());
        }
        if (shape.getShapeType().equals(ShapeTypes.ELLIPSE)) {
          g2d.fillRect((int) shape.getX(), (int) shape.getY(),
              (int) shape.getWidth(), (int) shape.getHeight());
        }
      }

    }
  }

  /**
   * draws the shapes on the canvas with the corresponding animations.
   *
   * @param shapes Given IShape that are able to be mutated
   */
  @Override
  public void draw(List<IShape> shapes) {
    this.shapes = shapes;
    repaint();
  }
}
