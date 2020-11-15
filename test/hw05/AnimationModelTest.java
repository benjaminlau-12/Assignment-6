package hw05;

import cs3500.animator.model.AnimationModel;
import cs3500.animator.model.IAnimationModel;
import cs3500.animator.model.shapes.Ellipse;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.model.shapes.Rectangle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for the AnimationModel class.
 */
public class AnimationModelTest {

  IAnimationModel model = new AnimationModel(0, 0, 50, 50);
  IShape square = new Rectangle(0, 0, 10, 10, 255, 255, 255);
  IShape circle = new Ellipse("",0, 0, 3, 3, 0, 0, 0, 0, 0);

  /**
   * Test that adding a shape to the model will add that shape to the Map(String,Shape) shapes.
   */
  @Test
  public void testAddShape() {
    assertEquals(model.getShapes().containsKey("R"), false);
    model.addShape("R", square);
    assertEquals(model.getShapes().containsKey("R"), true);
  }

  /**
   * Test that adding a shape to the model will add that shape to the Map(String,Shape) shapes.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeRepeated() {
    model.addShape("R", square);
    model.addShape("R", circle);
  }

  /**
   * Test that adding a shape to the model will add that shape to the Map(String,Shape) shapes.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeSameShape() {
    model.addShape("R", square);
    model.addShape("R", square);
  }

  /**
   * Test that inputting null shape will result in an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeShapeNull() {
    model.addShape("name", null);
  }

  /**
   * Test that inputting null String for name will result in an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddShapeNameNull() {
    model.addShape(null, square);
  }

  /**
   * Test that removeShape() removes the desired shape from model.shapes.
   */
  @Test
  public void testRemoveShape() {
    model.addShape("A", circle);
    assertEquals(model.getShapes().containsKey("A"), true);
    model.removeShape("A");
    assertEquals(model.getShapes().containsKey("A"), false);
  }

  /**
   * Test that removing a shape with a null input will result in IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveShapeNull() {
    model.addShape("A", circle);
    model.removeShape(null);
  }

  /**
   * Test that removing a shape when there is no shape connected to the name or if there is nothing
   * in model.shapes will result in IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testRemoveShapeDNE() {
    model.removeShape("ABC");
  }

  /**
   * Test that setBounds will change the fields of the model.
   */
  @Test
  public void testSetBounds() {
    // Before setBounds()
    assertEquals(model.getX(), 0);
    assertEquals(model.getY(), 0);
    assertEquals(model.getWidth(), 50);
    assertEquals(model.getHeight(), 50);

    model.setBounds(10, -10, 30, 100);
    // After setBounds()
    assertEquals(model.getX(), 10);
    assertEquals(model.getY(), -10);
    assertEquals(model.getWidth(), 30);
    assertEquals(model.getHeight(), 100);
  }

  /**
   * Test that inputting 0 width into setBounds will cause IllegalArgumentExceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetBoundsZeroWidth() {
    model.setBounds(10, 10, 0, 100);
  }

  /**
   * Test that inputting negative width into setBounds will cause IllegalArgumentExceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetBoundsNegativeWidth() {
    model.setBounds(10, 10, -10, 100);
  }

  /**
   * Test that inputting 0 height into setBounds will cause IllegalArgumentExceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetBoundsZereoHeight() {
    model.setBounds(10, 10, 20, 0);
  }

  /**
   * Test that inputting negative height into setBounds will cause IllegalArgumentExceptions.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetBoundsNegativeHeight() {
    model.setBounds(10, 10, 20, -1);
  }

  /**
   * Tests that moveShape() changes the position of the given shape to the input x and y.
   */
  @Test
  public void testMoveShapePositive() {
    model.addShape("R", square);
    assertEquals(square.getX(), 0);
    assertEquals(square.getY(), 0);

    model.moveShape(0, 1, "R", 10, 10);
    assertEquals(square.getX(), 10);
    assertEquals(square.getY(), 10);
  }

  /**
   * Tests that the shape can be moved to negative x and y positions.
   */
  @Test
  public void testMoveShapeNegative() {
    model.addShape("R", square);
    assertEquals(square.getX(), 0);
    assertEquals(square.getY(), 0);

    model.moveShape(0, 1, "R", -10, -10);
    assertEquals(square.getX(), -10);
    assertEquals(square.getY(), -10);
  }

  /**
   * Tests that inputting negative starting time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveShapeNegativeStart() {
    model.addShape("R", square);
    model.moveShape(-1, 0, "R", 2, 3);
  }

  /**
   * Tests that inputting negative ending time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveShapeNegativeEnd() {
    model.addShape("R", square);
    model.moveShape(10, -4, "R", 2, 3);
  }

  /**
   * Tests that inputting end < start will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveShapeNegativeInterval() {
    model.addShape("R", square);
    model.moveShape(10, 2, "R", 2, 3);
  }

  /**
   * Tests that inputting a name that does not belong to a already-created shape will lead to an
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveShapeDNE() {
    model.addShape("R", square);
    model.moveShape(10, 12, "AShape", 2, 3);
  }

  /**
   * Tests that changeColor() will change the shape's color to the input compositions.
   */
  @Test
  public void testChangeColor() {
    model.addShape("R", square);
    assertEquals(square.getR(), 255);
    assertEquals(square.getG(), 255);
    assertEquals(square.getB(), 255);

    model.changeColor(1, 3, "R", 14, 171, 42);
    assertEquals(square.getR(), 14);
    assertEquals(square.getG(), 171);
    assertEquals(square.getB(), 42);
  }

  /**
   * Tests that inputting negative r value will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeR() {
    model.addShape("R", square);
    model.changeColor(0, 1, "R", -1, 3, 4);
  }

  /**
   * Tests that inputting negative g value will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeG() {
    model.addShape("R", square);
    model.changeColor(-1, 0, "R", 2, -3, 4);
  }

  /**
   * Tests that inputting negative b value will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeB() {
    model.addShape("R", square);
    model.changeColor(-1, 0, "R", 2, 3, -2);
  }

  /**
   * Tests that inputting r value greater than 255 will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOutOfBoundR() {
    model.addShape("R", square);
    model.changeColor(0, 0, "R", 284, 3, 2);
  }

  /**
   * Tests that inputting g value greater than 255 will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOutOfBoundG() {
    model.addShape("R", square);
    model.changeColor(0, 0, "R", 0, 3490, 2);
  }

  /**
   * Tests that inputting b value greater than 255 will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorOutOfBoundB() {
    model.addShape("R", square);
    model.changeColor(0, 0, "R", 2, 3, 2830);
  }

  /**
   * Tests that inputting negative starting time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeStart() {
    model.addShape("R", square);
    model.changeColor(-1, 0, "R", 2, 3, 4);
  }

  /**
   * Tests that inputting negative ending time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeEnd() {
    model.addShape("R", square);
    model.changeColor(10, -4, "R", 2, 3, 4);
  }

  /**
   * Tests that inputting end < start will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorNegativeInterval() {
    model.addShape("R", square);
    model.changeColor(10, 2, "R", 2, 3, 4);
  }

  /**
   * Tests that inputting a name that does not belong to a already-created shape will lead to an
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeColorDNE() {
    model.addShape("R", square);
    model.changeColor(10, 12, "AShape", 2, 3, 4);
  }

  /**
   * Tests that changeWidth() will change the shape's width to the input value.
   */
  @Test
  public void testChangeWidth() {
    model.addShape("R", square);
    assertEquals(square.getHeight(), 50);

    model.changeHeight(1, 3, "R", 100);
    assertEquals(square.getHeight(), 100);
  }

  /**
   * Tests that inputting negative width will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeWidthNegative() {
    model.addShape("R", square);
    model.changeWidth(0, 1, "R", -1);
  }

  /**
   * Tests that inputting negative width will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeWidthZeroWhenHeightIsZero() {
    model.addShape("R", square);
    model.changeHeight(1, 1, "R", 0);
    model.changeWidth(1, 2, "R", 0);
  }

  /**
   * Tests that inputting negative starting time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeWidthNegativeStart() {
    model.addShape("R", square);
    model.changeWidth(-1, 0, "R", 30);
  }

  /**
   * Tests that inputting negative ending time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeWidthNegativeEnd() {
    model.addShape("R", square);
    model.changeWidth(10, -5, "R", 30);
  }

  /**
   * Tests that inputting end < start will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeWidthNegativeInterval() {
    model.addShape("R", square);
    model.changeWidth(1, 0, "R", 30);
  }

  /**
   * Tests that inputting a name that does not belong to a already-created shape will lead to an
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeWidthDNE() {
    model.addShape("R", square);
    model.changeWidth(0, 20, "Something", 30);
  }

  /**
   * Tests that changeHeight() will change the shape's height to the input value.
   */
  @Test
  public void testChangeHegiht() {
    model.addShape("R", square);
    assertEquals(square.getWidth(), 50);

    model.changeWidth(1, 3, "R", 100);
    assertEquals(square.getWidth(), 100);
  }

  /**
   * Tests that inputting negative width will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeHeightNegative() {
    model.addShape("R", square);
    model.changeHeight(0, 1, "R", -1);
  }

  /**
   * Tests that inputting negative width will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeHeightZeroWhenWidthIsZero() {
    model.addShape("R", square);
    model.changeWidth(1, 2, "R", 0);
    model.changeHeight(1, 1, "R", 0);
  }

  /**
   * Tests that inputting negative starting time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeHeightNegativeStart() {
    model.addShape("R", square);
    model.changeHeight(-1, 0, "R", 30);
  }

  /**
   * Tests that inputting negative ending time will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeHeightNegativeEnd() {
    model.addShape("R", square);
    model.changeHeight(10, -5, "R", 30);
  }

  /**
   * Tests that inputting end < start will lead to an IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeHeightNegativeInterval() {
    model.addShape("R", square);
    model.changeHeight(1, 0, "R", 30);
  }

  /**
   * Tests that inputting a name that does not belong to a already-created shape will lead to an
   * IllegalArgumentException.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testChangeHeightDNE() {
    model.addShape("R", square);
    model.changeHeight(0, 20, "Something", 30);
  }

  @Test
  public void testToString() {
    model.addShape("R", square);
    model.moveShape(10, 10, "R", 20, 20);
    assertEquals(model.toString(),
        "shape R rectangle\n" + "motion R 0 0 0 10 10 255 255 255  10 20 20 10 10 255 255 "
            + "255");
    model.changeColor(10, 20, "R", 0, 0, 0);
    assertEquals(model.toString(),
        "shape R rectangle\n" + "motion R 0 0 0 10 10 255 255 255  10 20 20 10 10 255 255 "
            + "255\n" + "motion R 10 20 20 10 10 255 255  10 20 20 10 10 0 0 0\n");
    model.addShape("C", circle);
    model.changeHeight(0, 2, "C", 30);
    assertEquals(model.toString(),
        "shape R rectangle\n" + "motion R 0 0 0 10 10 255 255 255  10 20 20 10 10 255 255 "
            + "255\n" + "motion R 10 20 20 10 10 255 255  10 20 20 10 10 0 0 0\n" +
            "shape C ellipse\n" + "motion C 0 0 0 3 3 0 0 0  2 0 0 3 30 0 0 0");
  }
}