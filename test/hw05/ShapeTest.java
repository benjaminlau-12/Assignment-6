package hw05;

import static org.junit.Assert.assertEquals;

import cs3500.animator.model.shapes.Shape;
import org.junit.Test;

/**
 * Test for the class Shape.
 */
public class ShapeTest {

  Shape shape = new Shape("",200, 250, 100, 150, 255, 0, 0);

  /**
   * To test setter methods.
   */
  @Test
  public void testSetters() {
    assertEquals(150, shape.getWidth());
    shape.setColor(27, 58, 230);
    shape.setX(175);
    shape.setY(228);
    shape.setHeight(150);
    shape.setWidth(200);

    assertEquals(230, shape.getB());
    assertEquals(58, shape.getG());
    assertEquals(27, shape.getR());
    assertEquals(175, shape.getX());
    assertEquals(228, shape.getY());
    assertEquals(150, shape.getHeight());
    assertEquals(200, shape.getWidth());

    shape.setPosition(210, 230);
    shape.setSize(95, 105);

    assertEquals(95, shape.getWidth());
    assertEquals(105, shape.getHeight());
    assertEquals(210, shape.getX());
    assertEquals(230, shape.getY());
  }

  /**
   * To test the getter methods.
   */
  @Test
  public void testGetters() {
    assertEquals(0, shape.getB());
    assertEquals(0, shape.getG());
    assertEquals(255, shape.getR());
    assertEquals(200, shape.getX());
    assertEquals(250, shape.getY());
    assertEquals(100, shape.getHeight());
    assertEquals(150, shape.getWidth());
  }

  /**
   * To test that the setColor method throws an IllegalArgumentException when given a value greater
   * than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorErrorWithOutOfBoundsValue() {
    shape.setColor(255, 0, 256);
  }

  /**
   * To test that the setColor method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorErrorWithNegativeValue() {
    shape.setColor(255, -1, 18);
  }

  /**
   * To test that the setSize method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeErrorWithNegativeValue() {
    shape.setSize(1, -1);
  }

  /**
   * To test that the setSize method throws an IllegalArgumentException when both height and width
   * is 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeErrorWithValuesEqualToZero() {
    shape.setSize(0, 0);
  }

  /**
   * To test that the setWidth method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetWidthErrorWithNegativeValue() {
    shape.setWidth(-15);
  }

  /**
   * To test that the setHeight method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetHeightErrorWithNegativeValue() {
    shape.setHeight(-7);
  }

  /**
   * To test that the setHeight method throws an IllegalArgumentException when trying to set height
   * to zero when width is already zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetHeightErrorGivenZeroWidth() {
    shape.setWidth(0);
    shape.setHeight(0);
  }

  /**
   * To test that the setWidth method throws an IllegalArgumentException when trying to set width to
   * zero when height is already zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetWidthErrorGivenZeroHeight() {
    shape.setHeight(0);
    shape.setWidth(0);
  }
}