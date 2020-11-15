package cs3500.animator.view;

import cs3500.animator.model.helpers.Canvas;
import cs3500.animator.model.shapes.IShape;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class VisualView extends AnimationView {

  private int tick;
  private final Drawing panel;

  /**
   * A constructor that will later be used in the controller.
   *
   * @param tick given tick per second
   */
  public VisualView(int tick) {
    super();
    this.tick = tick;
    panel = new Drawing();
    panel.setBackground(Color.WHITE);

    JScrollPane scrollPane = new JScrollPane(panel);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);

    add(scrollPane);

    setVisible(true);
  }

  /**
   * Renders the given output depends on with view the user is selecting.
   *
   * @param shapes given IShape that are from the model
   */
  @Override
  public void render(List<IShape> shapes) {
    panel.draw(shapes);
  }

  /**
   * setter that sets the default canvas to the given size.
   *
   * @param c given canvas size
   */
  @Override
  public void setCanvas(Canvas c) {
    this.canvas = c;
    panel.setBounds(canvas.getBoundX(), canvas.getBoundY(), canvas.getBoundWidth(), canvas.getBoundHeight());
    setSize(1000, 800);
    panel.setPreferredSize(new Dimension(canvas.getBoundWidth(), canvas.getBoundHeight()));
  }

  /**
   * @return
   */
  @Override
  public int getTick() {
    return this.tick;
  }
}

