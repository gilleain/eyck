package test.text;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point2d;

import test.BasePaintingTest;
import test.text.model.Text;

public class BaseTextListTest extends BasePaintingTest {
    
    public final Font LARGE_FONT = Font.decode("ARIAL-50");
    
    // would be nice to have alpha = [chr(i) for i in range(ord('A'), ord('Z')]
    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public List<Text> makeLetterPairModel() {
        List<Text> model = new ArrayList<Text>();
        model.add(new Text("H", new Point2d(-1, 0)));
        model.add(new Text("H", new Point2d(1, 0)));
        return model;
    }

}
