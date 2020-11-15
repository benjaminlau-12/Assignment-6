package hw05;

import static org.junit.Assert.assertEquals;

import cs3500.animator.model.shapes.Ellipse;
import org.junit.Test;

/**
 * Test for the class Ellipse.
 */
public class EllipseTest {

  Ellipse ellipse = new Ellipse("",200, 250, 100, 150, 50, 75, 255, 0, 0);

  /**
   * To test setter methods.
   */
  @Test
  public void testSetters() {
    assertEquals(150, ellipse.getWidth());
    ellipse.setColor(27, 58, 230);
    ellipse.setX(175);
    ellipse.setY(228);
    ellipse.setHeight(150);
    ellipse.setWidth(200);

    assertEquals(230, ellipse.getB());
    assertEquals(58, ellipse.getG());
    assertEquals(27, ellipse.getR());
    assertEquals(175, ellipse.getX());
    assertEquals(228, ellipse.getY());
    assertEquals(150, ellipse.getHeight());
    assertEquals(200, ellipse.getWidth());

    ellipse.setPosition(210, 230);
    ellipse.setSize(95, 105);

    assertEquals(95, ellipse.getWidth());
    assertEquals(105, ellipse.getHeight());
    assertEquals(210, ellipse.getX());
    assertEquals(230, ellipse.getY());
  }

  /**
   * To test the getter methods.
   */
  @Test
  public void testGetters() {
    assertEquals(0, ellipse.getB());
    assertEquals(0, ellipse.getG());
    assertEquals(255, ellipse.getR());
    assertEquals(200, ellipse.getX());
    assertEquals(250, ellipse.getY());
    assertEquals(100, ellipse.getHeight());
    assertEquals(150, ellipse.getWidth());
    assertEquals(50, ellipse.getCx());
    assertEquals(75, ellipse.getCy());
  }

  /**
   * To test that the setColor method throws an IllegalArgumentException when given a value greater
   * than 255.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorErrorWithOutOfBoundsValue() {
    ellipse.setColor(255, 0, 256);
  }

  /**
   * To test that the setColor method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetColorErrorWithNegativeValue() {
    ellipse.setColor(255, -1, 18);
  }

  /**
   * To test that the setSize method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeErrorWithNegativeValue() {
    ellipse.setSize(1, -1);
  }

  /**
   * To test that the setSize method throws an IllegalArgumentException when both height and width
   * is 0.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetSizeErrorWithValuesEqualToZero() {
    ellipse.setSize(0, 0);
  }

  /**
   * To test that the setWidth method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetWidthErrorWithNegativeValue() {
    ellipse.setWidth(-15);
  }

  /**
   * To test that the setHeight method throws an IllegalArgumentException when given a negative
   * value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetHeightErrorWithNegativeValue() {
    ellipse.setHeight(-7);
  }

  /**
   * To test that the setHeight method throws an IllegalArgumentException when trying to set height
   * to zero when width is already zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetHeightErrorGivenZeroWidth() {
    ellipse.setWidth(0);
    ellipse.setHeight(0);
  }

  /**
   * To test that the setWidth method throws an IllegalArgumentException when trying to set width to
   * zero when height is already zero.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetWidthErrorGivenZeroHeight() {
    ellipse.setHeight(0);
    ellipse.setWidth(0);
  }

  /**
   * Test that the constructor throws an IllegalArgumentException if given a negative value for cx.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorCx() {
    Ellipse ellipseWithInvalidValues =
        new Ellipse("",200, 250, 100, 175, -8, 50, 255, 0, 0);
  }

  /**
   * Test that the constructor throws an IllegalArgumentException if given a negative value for cy.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorCy() {
    Ellipse ellipseWithInvalidValues =
        new Ellipse("",200, 250, 100, 175, 18, -1, 255, 0, 0);
  }
}