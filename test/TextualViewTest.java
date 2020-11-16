import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

import cs3500.animator.model.AnimationModel;
import cs3500.animator.model.IAnimationModel;
import cs3500.animator.model.shapes.Ellipse;
import cs3500.animator.model.shapes.IShape;
import cs3500.animator.view.IView;
import cs3500.animator.view.TextualView;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 *
 */
public class TextualViewTest {

  IAnimationModel model = new AnimationModel(0, 0, 50, 50);
  IView textualView = new TextualView();
  List<IShape> shapes = new ArrayList<IShape>();

  /**
   *
   */
  private void init(){
    IShape ellipse = new Ellipse("E", 10,10,10,10,10,10,10);
    shapes.add(ellipse);
  }

  /**
   *
   */
  @Test
  public void testGetText(){
    textualView.render(shapes);
    assertEquals(textualView.getText(),"");
  }
}