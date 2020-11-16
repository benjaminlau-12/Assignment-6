import static org.junit.Assert.assertEquals;

import cs3500.animator.model.AnimationModel;
import cs3500.animator.model.IAnimationModel;
import cs3500.animator.model.commands.Color;
import cs3500.animator.model.commands.Command;
import cs3500.animator.model.commands.Height;
import cs3500.animator.model.commands.Move;
import cs3500.animator.model.commands.Width;
import cs3500.animator.model.helpers.RGB;
import cs3500.animator.model.helpers.TimeLapse;
import cs3500.animator.model.shapes.Ellipse;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.view.IView;
import cs3500.animator.view.TextualView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.junit.Test;

/**
 * To test the correct output of the TextualView class
 */
public class TextualViewTest {

  IAnimationModel model = new AnimationModel(0, 0, 50, 50);
  IView textualView = new TextualView();
  List<IShape> shapes = new ArrayList<IShape>();
  TimeLapse fiveSecondTimeLapse = new TimeLapse(0, 5);
  TimeLapse threeSecondTimeLapse = new TimeLapse(5, 8);
  TimeLapse oneSecondTimeLapse = new TimeLapse(8, 9);
  RGB white = new RGB(255,255,255);
  RGB darkRed = new RGB(139,0,0);

  /**
   * Initializes all Shapes and Commands.
   */
  private void init(){
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    IShape rectangle = new Rectangle("R", 40,30,
        70, 50, 255, 0, 0);
    shapes.add(ellipse);
    shapes.add(rectangle);

    Command moveRectangle1 = new Move(rectangle, fiveSecondTimeLapse, 100, 200);
    Command changeRectangleWidth = new Width(rectangle, threeSecondTimeLapse, 120);
    Command changeRectangleHeight = new Height(rectangle, threeSecondTimeLapse, 100);
    Command moveRectangle2 = new Move(rectangle, fiveSecondTimeLapse, 101, 201);
    Command changeColorToWhite = new Color(rectangle, oneSecondTimeLapse, white);

    Command moveEllipse1 = new Move(ellipse, threeSecondTimeLapse, 30, 50);
    Command changeEllipseHeight = new Height(ellipse, threeSecondTimeLapse, 30);
    Command moveEllipse2 = new Move(ellipse, fiveSecondTimeLapse, 20, 80);
    Command changeEllipseWidth = new Width(ellipse, threeSecondTimeLapse, 70);
    Command changeColorToDarkRed = new Color(ellipse, oneSecondTimeLapse, darkRed);

  }

  /**
   * To test whether the textual view is what is expected.
   */
  @Test
  public void testGetText(){
    textualView.render(shapes);
    String expectedOutput = "canvas 0 0 50 50\n shape R rectangle\n"
        + "motion R 0.00 40 30 70 50 255 0 0 5.00 100 200 70 50 255 0 0\n"
        + "motion R 5.00 100 200 70 50 255 0 0 8.00 100 200 70 120 255 0 0\n"
        + "motion R 8.00 100 200 70 120 255 0 0 11.00 100 200 100 120 255 0 0\n"
        + "motion R 11.00 100 200 100 120 255 0 0 16.00 101 201 100 120 255 0 0\n"
        + "motion R 16.00 100 200 100 120 255 0 0 17.00 101 201 100 120 255 255 255\n"
        + "shape C ellipse\n"
        + "motion C 0.00 10 30 15 40 10 100 103 3.00 30 50 15 40 10 100 103\n"
        + "motion C 3.00 30 50 15 40 10 100 103 6.00 30 50 15 30 10 100 103\n"
        + "motion C 6.00 30 50 15 30 10 100 103 11.00 20 80 15 30 10 100 103\n"
        + "motion C 11.00 20 80 15 30 10 100 103 14.00 20 80 70 30 10 100 103\n"
    + "motion C 14.00 20 80 15 30 10 100 103 15.00 20 80 70 30 139 0 0";
    assertEquals(textualView.getText(), expectedOutput);
  }

  /**
   * To test that the Move constructor throws an IllegalArgumentException given a negative Y.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMoveConstructorGivenNegativeY() {
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    Command move = new Move(ellipse, oneSecondTimeLapse, 0, -1);
  }

  /**
   * To test that the Move constructor throws an IllegalArgumentException given a negative X.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testMoveConstructorGivenNegativeX() {
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    Command move = new Move(ellipse, oneSecondTimeLapse, -37, 29);
  }

  /**
   * To test that the Width constructor throws an IllegalArgumentException given negative values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testWidthConstructor() {
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    Command width = new Width(ellipse, oneSecondTimeLapse, -9);
  }

  /**
   * To test that the Height constructor throws an IllegalArgumentException given negative values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testHeightConstructor() {
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    Command height = new Height(ellipse, oneSecondTimeLapse, -7);
  }

  /**
   * To test that the RGB constructor throws an IllegalArgumentException given negative values.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRGBConstructorGivenNegativeValues() {
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    RGB negativeValues = new RGB(-139,0,0);
  }

  /**
   * To test that the RGB constructor throws an IllegalArgumentException 
   * given values greater than 255.
   */
  @Test (expected = IllegalArgumentException.class)
  public void testRGBConstructorGivenValuesGreaterThan255() {
    IShape ellipse = new Ellipse("C", 10,30,15,40,10,100,103);
    RGB outOfBounds = new RGB(0,0,256);
  }

}
