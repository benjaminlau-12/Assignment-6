package hw05;

import static org.junit.Assert.assertEquals;

import cs3500.animator.model.Command;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.Rectangle;
import org.junit.Test;

/**
 * Tests for the class Command.
 */
public class CommandTest {

  IShape sqaure = new Rectangle(0, 0, 10, 10, 50, 50, 50);
  Command command = new Command(0, sqaure.getX(), sqaure.getY(), sqaure.getWidth(),
      sqaure.getHeight(),
      sqaure.getR(), sqaure.getG(), sqaure.getB(), 10, 300, 200, 60,
      40, 0, 20, 100);

  /**
   * Test that the starting time is 0.
   */
  @Test
  public void testGetStart() {
    assertEquals(command.getStart(), 0);
  }

  /**
   * Test that the starting x-value is 0.
   */
  @Test
  public void testGetStartX() {
    assertEquals(command.getStartX(), 0);
  }

  /**
   * Test that the starting y-value is 0.
   */
  @Test
  public void testGetStartY() {
    assertEquals(command.getStartY(), 0);
  }

  /**
   * Test that the starting width is 0.
   */
  @Test
  public void testGetStartWidth() {
    assertEquals(command.getStartWidth(), 10);
  }

  /**
   * Test that the starting height is 0.
   */
  @Test
  public void testGetStartHeight() {
    assertEquals(command.getStartHeight(), 10);
  }

  /**
   * Test that the starting r-value is 0.
   */
  @Test
  public void testGetStartR() {
    assertEquals(command.getStartR(), 50);
  }

  /**
   * Test that the starting g-value is 0.
   */
  @Test
  public void testGetStartG() {
    assertEquals(command.getStartG(), 50);
  }

  /**
   * Test that the starting b-value is 0.
   */
  @Test
  public void testGetStartB() {
    assertEquals(command.getStartB(), 50);
  }

  /**
   * Test that the ending time is 0.
   */
  @Test
  public void testGetEnd() {
    assertEquals(command.getEnd(), 10);
  }

  /**
   * Test that the ending x-value is 0.
   */
  @Test
  public void testGetEndX() {
    assertEquals(command.getEndX(), 300);
  }

  /**
   * Test that the ending y-value is 0.
   */
  @Test
  public void testGetEndY() {
    assertEquals(command.getEndY(), 200);
  }

  /**
   * Test that the ending width is 0.
   */
  @Test
  public void testGetEndWidth() {
    assertEquals(command.getEndWidth(), 60);
  }

  /**
   * Test that the ending height is 0.
   */
  @Test
  public void testGetEndHeight() {
    assertEquals(command.getEndHeight(), 40);
  }

  /**
   * Test that the ending r-value is 0.
   */
  @Test
  public void testGetEndR() {
    assertEquals(command.getEndR(), 0);
  }

  /**
   * Test that the ending g-value is 0.
   */
  @Test
  public void testGetEndG() {
    assertEquals(command.getEndG(), 20);
  }

  /**
   * Test that the ending b-value is 0.
   */
  @Test
  public void testGetEndB() {
    assertEquals(command.getEndB(), 100);
  }
}