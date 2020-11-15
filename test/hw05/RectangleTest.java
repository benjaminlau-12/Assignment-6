package hw05;

import static org.junit.Assert.assertEquals;

import cs3500.animator.model.shapes.Rectangle;
import cs3500.animator.model.shapes.Shape;
import org.junit.Test;

/**
 * Test for the class Rectangle.
 */
public class RectangleTest {

  Shape rectangle = new Rectangle(200, 250, 100, 150, 255, 0, 0);

  /**
   * To test setter methods.
   */
  @Test
  public void testSetters() {
    assertEquals(150, rectangle.getWidth());
    rectangle.setColor(27, 58, 230);
    rectangle.setX(175);
    rectangle.setY(228);
    rectangle.setHeight(150);
    rectangle.setWidth(200);

    assertEquals(230, rectangle.getB());
    assertEquals(58, rectangle.getG());
    assertEquals(27, rectangle.getR());
    assertEquals(175, rectangle.getX());
    assertEquals(228, rectangle.getY());
    assertEquals(150, rectangle.getHeight());
    assertEquals(200, rectangle.getWidth());

    rectangle.setPosition(210, 230);
    rectangle.setSize(95, 105);

    assertEquals(95, rectangle.getWidth());
    assertEquals(105, rectangle.getHeight());
    assertEquals(210, rectangle.getX());
    assertEquals(230, rectangle.getY());
  }

  /**
   * To test the getter methods.
   */
  @Test
  public void testGetters() {
    assertEquals(0, rectangle.getB());
    assertEquals(0, rectangle.getG());
    assertEquals(255, rectangle.getR());
    assertEquals(200, rectangle.getX());
    assertEquals(250, rectangle.getY());
    assertEquals(100, rectangle.getHeight());
    assertEquals(150, rectangle.getWidth());
  }

  /**
   * To test that the setColor method throws an IllegalArgumentException when given a value greater
   * than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorErrorWithOutOfBoundsValue() {
    rectangle.setColor(255, 0, 256);
  }

  /**
   * To test that the setColor method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorErrorWithNegativeValue() {
    rectangle.setColor(255, -1, 18);
  }

  /**
   * To test that the setSize method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeErrorWithNegativeValue() {
    rectangle.setSize(1, -1);
  }

  /**
   * To test that the setSize method throws an IllegalArgumentException when both height and width
   * is 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeErrorWithValuesEqualToZero() {
    rectangle.setSize(0, 0);
  }

  /**
   * To test that the setWidth method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetWidthErrorWithNegativeValue() {
    rectangle.setWidth(-15);
  }

  /**
   * To test that the setHeight method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetHeightErrorWithNegativeValue() {
    rectangle.setHeight(-7);
  }

  /**
   * To test that the setHeight method throws an IllegalArgumentException when trying to set height
   * to zero when width is already zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetHeightErrorGivenZeroWidth() {
    rectangle.setWidth(0);
    rectangle.setHeight(0);
  }

  /**
   * To test that the setWidth method throws an IllegalArgumentException when trying to set width to
   * zero when height is already zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetWidthErrorGivenZeroHeight() {
    rectangle.setHeight(0);
    rectangle.setWidth(0);
  }
}