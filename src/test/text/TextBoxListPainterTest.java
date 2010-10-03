package test.text;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.vecmath.Point2d;

import org.junit.Test;

import test.BasePaintingTest;

public class TextBoxListPainterTest extends BasePaintingTest {
    
    // would be nice to have alpha = [chr(i) for i in range(ord('A'), ord('Z')]
    public final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    @Test
    public void basicUsage() {
        // make the model
        List<Point2d> points = getRandomPointsInModelSpace(5);
        List<TextBox> textBoxes = new ArrayList<TextBox>();
        for (int i = 0; i < points.size(); i++) {
            textBoxes.add(new TextBox(alphabet.substring(i, i+1), points.get(i)));
        }
        
        // render it
        Image image = getBlankTestImage();
        TextBoxListPainter painter = new TextBoxListPainter(image.getGraphics());
        painter.paint(textBoxes, getCanvas());
        writeImage(image, "alphabet");
    }

}
